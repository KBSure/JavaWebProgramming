package examples.boot.simpleboard.domain;

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
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    @JsonIgnore
    private String password;
    private LocalDateTime regdate;

    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name="user_id") // 기존 테이블에 user_no 라는 Column이 대신 있었다면 새로운 Column(user_id)가 생기게 되는 것인가?
    private List<UserRole> roles;
}


//joinColumn은 Users Table에 생기는 게 아니다. UserRole이 지정되어있는 테이블에 생긴다.