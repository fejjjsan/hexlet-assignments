package exercise.controller;

import exercise.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.HttpStatus;
import java.util.List;

import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.exception.ResourceNotFoundException;

// BEGIN
@RestController
@RequestMapping("/posts")
public class PostsController {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CommentRepository commentRepository;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<Post> index() {
        return postRepository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Post show(@PathVariable long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " not found"));
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Post create(@RequestBody Post post) {
        return postRepository.save(post);
    }

    @PutMapping("/{id}")
    public Post update(@RequestBody Post data, @PathVariable long id) {
        var post = postRepository.findById(id);
        if (post.isPresent()) {
            post.get().setTitle(data.getTitle());
            post.get().setBody(data.getBody());
            postRepository.save(post.get());
        } else {
            throw new ResourceNotFoundException("Post with id " + id + " not found");
        }

        return data;
    }

    @DeleteMapping("/{id}")
    public Post delete(@PathVariable long id) {
        var post = postRepository.findById(id);

        if (post.isPresent()) {
            postRepository.deleteById(id);
            commentRepository.deleteByPostId(id);
        } else {
            throw new ResourceNotFoundException("Post with id " + id + " not found");
        }

        return post.get();
    }
}
// END
