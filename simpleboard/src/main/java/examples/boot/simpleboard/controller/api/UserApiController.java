package examples.boot.simpleboard.controller.api;

import examples.boot.simpleboard.domain.User;
import examples.boot.simpleboard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.Authenticator;
import java.security.Principal;
import java.util.List;

@RestController //Web Api 리턴
@RequestMapping("/api/users")
public class UserApiController {
    @Autowired
    UserService userService;

    @GetMapping
    public List<User> getUsers(Principal principal){


        System.out.println("-------------------------------");
        System.out.println(principal.getName());
        System.out.println("-------------------------------");

//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String currentPrincipalName = authentication.getName();
//        System.out.println(currentPrincipalName);

        return userService.getUsers();
    }
}
