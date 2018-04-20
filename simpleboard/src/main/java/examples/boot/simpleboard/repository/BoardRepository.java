
package examples.boot.simpleboard.repository;

import examples.boot.simpleboard.base.JpaQueryDslPredicateRepository;
import examples.boot.simpleboard.domain.Board;
import org.springframework.data.jpa.repository.Query;

public interface BoardRepository
        extends JpaQueryDslPredicateRepository<Board, Long> {
    @Query("SELECT COUNT(b) FROM Board b")
    public Long countAll();

    @Query("SELECT COUNT(b) FROM Board b WHERE b.user.name = ?1")
    public Long countAllByUserName(String name);
}