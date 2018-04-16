package examples.helloboard.dao;

import examples.helloboard.config.DbConfig;
import examples.helloboard.config.RootApplicationContextConfig;
import examples.helloboard.domain.Role;
import examples.helloboard.service.RoleService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootApplicationContextConfig.class)
@Transactional
public class RoleServiceTest {
    @Autowired
    RoleService roleService;

    @Test
    public void config() throws Exception{
        Assert.assertTrue(true);
    }

    @Test
    public void getRole() throws Exception{
        // given
        Role role = new Role();
        role.setRoleId(500);
        role.setDescription("ADMIN");
        roleService.addRole(role);

        // Mock을 사용한다면 roleDao의 selectRole()에 500을 파라티터로 전달하면 어떤 Role이 리턴되도록 설정한다.

        // when
        Role resultRole = roleService.getRole(500);

        // then
        Assert.assertEquals(role.getRoleId(), resultRole.getRoleId());
        Assert.assertEquals(role.getDescription(), resultRole.getDescription());
    }

}
