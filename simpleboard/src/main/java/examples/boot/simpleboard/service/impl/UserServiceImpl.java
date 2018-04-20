package examples.boot.simpleboard.service.impl;

import examples.boot.simpleboard.domain.User;
import examples.boot.simpleboard.repository.UserRepository;
import examples.boot.simpleboard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User addUser(User user) {
        User saveUser = userRepository.save(user); //save 메서드는 JPA 가지고 있음 // user와 연관된 것도 자동으로 저장됨
        return saveUser;
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }
}