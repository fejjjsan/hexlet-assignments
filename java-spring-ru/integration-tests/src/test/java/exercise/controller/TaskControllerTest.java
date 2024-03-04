package exercise.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson;
import static org.assertj.core.api.Assertions.assertThat;
import org.instancio.Instancio;
import org.instancio.Select;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.datafaker.Faker;
import exercise.repository.TaskRepository;
import exercise.model.Task;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

// BEGIN
@SpringBootTest
@AutoConfigureMockMvc
// END
class ApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Faker faker;

    @Autowired
    private ObjectMapper om;

    @Autowired
    private TaskRepository taskRepository;


    @Test
    public void testWelcomePage() throws Exception {
        var result = mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andReturn();

        var body = result.getResponse().getContentAsString();
        assertThat(body).contains("Welcome to Spring!");
    }

    @Test
    public void testIndex() throws Exception {
        var result = mockMvc.perform(get("/tasks"))
                .andExpect(status().isOk())
                .andReturn();

        var body = result.getResponse().getContentAsString();
        assertThatJson(body).isArray();
    }

    private Task generateTask() {
        return Instancio.of(Task.class)
                .ignore(Select.field(Task::getId))
                .supply(Select.field(Task::getTitle), () -> faker.lorem().word())
                .supply(Select.field(Task::getDescription), () -> faker.lorem().paragraph())
                .create();
    }

    // BEGIN


    @Test
    public void testShow() throws Exception {
        var task = generateTask();
        taskRepository.save(task);

        var request = mockMvc.perform(get("/tasks/1"))
                .andExpect(status().isOk())
                .andReturn();

        var body = request.getResponse().getContentAsString();
        assertThatJson(body).and(
                a -> a.node("id").isEqualTo(1),
                a -> a.node("title").isEqualTo(task.getTitle()),
                a -> a.node("description").isEqualTo(task.getDescription())
        );
    }


    @Test
    public void testCreate() throws Exception {
        Map<String, String> task = new HashMap<>();
        task.put("title", "buy porsche");
        task.put("description", "as soon as possible");

        var post = MockMvcRequestBuilders.post("/tasks")
                .contentType(MediaType.APPLICATION_JSON)
                .content(om.writeValueAsString(task));

        var request = mockMvc.perform(post)
                .andExpect(status().isCreated())
                .andReturn();

        var body = request.getResponse().getContentAsString();
        assertThatJson(request.getResponse().getStatus()).isEqualTo(201);
        assertThatJson(body).and(
                a -> a.node("title").isEqualTo("buy porsche"),
                a -> a.node("description").isEqualTo("as soon as possible")
        );
    }


    @Test
    public void testUpdate() throws Exception {
        var task = generateTask();
        var savedTask = taskRepository.save(task);

        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("title", "Terminator");
        requestBody.put("description", "Best film ever");

        var put = MockMvcRequestBuilders.put("/tasks/" + savedTask.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(om.writeValueAsString(requestBody));

        var request = mockMvc.perform(put)
                .andExpect(status().isOk())
                .andReturn();

        var responseBody = request.getResponse().getContentAsString();
        assertThatJson(responseBody).and(
                a -> a.node("title").isEqualTo("Terminator"),
                a -> a.node("description").isEqualTo("Best film ever")
        );
    }


    @Test
    public void testDelete() throws Exception {
        var task = generateTask();
        var savedTask = taskRepository.save(task);

        var request2 = mockMvc.perform(delete("/tasks/" + savedTask.getId()))
                .andExpect(status().isOk())
                .andReturn();
    }
    // END
}
