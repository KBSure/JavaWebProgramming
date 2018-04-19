package examples.boot.simpleboard.controller.api;

import examples.boot.simpleboard.domain.User;
import examples.boot.simpleboard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //Web Api 리턴
@RequestMapping("/api/users")
public class UserApiController {
    @Autowired
    UserService userService;

    @GetMapping
    public List<User> getUsers(){
        return userService.getUsers();
    }
}
