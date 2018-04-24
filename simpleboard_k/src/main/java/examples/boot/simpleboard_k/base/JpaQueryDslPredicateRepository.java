package examples.boot.simpleboard_k.base;

import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;


import java.io.Serializable;

public interface JpaQueryDslPredicateRepository<T,ID extends Serializable>
        extends JpaRepository<T, ID>, QuerydslPredicateExecutor<T> {

    @Override
    Iterable<T> findAll(Predicate predicate);

    @Override
    Iterable<T> findAll(Predicate predicate, Sort sort);

    @Override
    Iterable<T> findAll(Predicate predicate, OrderSpecifier<?>... orders);

    @Override
    Iterable<T> findAll(OrderSpecifier<?>... orders);
}