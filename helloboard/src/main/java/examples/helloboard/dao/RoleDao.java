package examples.helloboard.dao;
import examples.helloboard.domain.Role;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class RoleDao {
    // Spring JDBC는 기존 JDBC프로그래밍을 아주 간단하게 할 수 있도록 도와준다.
    // JdbcTemplate , NamedParameterJdbcTemplate 이 핵심객체이다.
    private NamedParameterJdbcTemplate jdbc;
    // insert를 쉽게 도와주는 객체이다. sql을 작성할 필요가 없다.
    private SimpleJdbcInsert insertAction;
    // RowMapper는 한건의 record를 쉽게 객체에 담아줄 수 있도록 도와준다.
    // jdbc에서 ResultSet으로부터 칼럼별로 값을 읽어오는 것을 도와주는 것.
    // Role클래스가 가지는 프로퍼티는 roleId, description이다.
    // role_id, description 칼럼의 값을 roleId, description프로퍼티에 설정한다.
    private RowMapper<Role> rowMapper = BeanPropertyRowMapper.newInstance(Role.class);

    public RoleDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAction = new SimpleJdbcInsert(dataSource)
                .withTableName("ROLE");
//                .usingGeneratedKeyColumns("role_id"); // 자동으로 id가 생성될 경우
    }

    public List<Role> selectAll() {
        return jdbc.query("select role_id, description from ROLE order by role_id", Collections.emptyMap(), rowMapper);
    }

    public int insertRole(Role role){
        SqlParameterSource params = new BeanPropertySqlParameterSource(role);
        // 자동으로 id를 생성할 경우에는 아래와 같이 생성된 pk를 반환할 수 있다.
//        return insertAction.executeAndReturnKey(params).intValue();
        int count = insertAction.execute(params);
        return role.getRoleId();
    }

    public int deleteRole(int roleId){
        Map<String, ?> params = Collections.singletonMap("roleId", roleId);
        // update메소드는 실행된 건수를 리턴한다.
        return jdbc.update("delete from ROLE where role_id = :roleId", params);
    }

    public int updateRole(Role role){
        SqlParameterSource params = new BeanPropertySqlParameterSource(role);
        return jdbc.update("update ROLE set description = :description where role_id = :roleId", params);
    }

    public Role selectRole(int roleId){
        Map<String, ?> params = Collections.singletonMap("roleId", roleId);
        try {
            // 결과가 없으면 Exception이 발생한다.
            Role role = jdbc.queryForObject("select role_id, description from ROLE where role_id = :roleId", params, rowMapper);
            return role;
        }catch(DataAccessException e){
            return null;
        }
    }
}
