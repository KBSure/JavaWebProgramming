package examples.boot.simpleboard.repository;

import examples.boot.simpleboard.base.JpaQueryDslPredicateRepository;
import examples.boot.simpleboard.domain.User;

public interface UserRepository extends JpaQueryDslPredicateRepository<User, Long> {

}
