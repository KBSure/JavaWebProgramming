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
    //컴파일 때가 아니라 실행될 때 만들어진다.
    //컴파일 때 만들어지는 건 Q File

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
