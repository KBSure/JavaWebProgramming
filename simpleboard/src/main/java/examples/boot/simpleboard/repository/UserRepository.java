package examples.boot.simpleboard.repository;

import com.querydsl.core.Tuple;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import examples.boot.simpleboard.base.JpaQueryDslPredicateRepository;
import examples.boot.simpleboard.domain.QUser;
import examples.boot.simpleboard.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

// @Repository를 붙이지 않아도 Repository로 등록된다.
public interface UserRepository
        extends JpaQueryDslPredicateRepository<User, Long> {

    public User findUserByEmail(String email);

}