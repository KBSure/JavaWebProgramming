package examples.boot.simpleboard_k.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter

public class User implements Serializable {
    public User(){
        regdate = LocalDateTime.now();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    @JsonIgnore
    private String password;
    private LocalDateTime regdate;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER) //eager??
    @JoinColumn(name="user_id")
    private List<UserRole> roles;

}
