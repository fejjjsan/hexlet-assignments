package exercise.dto.users;

import exercise.model.User;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

// BEGIN
@AllArgsConstructor
@Getter
public final class UsersPage {
    public List<User> users = new ArrayList<>();
}

// END
