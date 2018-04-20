package examples.boot.simpleboard.service;

import examples.boot.simpleboard.domain.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    User addUser(User user);
    User getUserByEmail(String email);
}