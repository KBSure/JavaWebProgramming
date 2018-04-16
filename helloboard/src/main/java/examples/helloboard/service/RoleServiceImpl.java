package examples.helloboard.service;

import examples.helloboard.dao.RoleDao;
import examples.helloboard.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    RoleDao roleDao;

    @Override
    @Transactional(readOnly = true)
    public List<Role> getRoles() {
        return roleDao.selectAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Role getRole(int roleId) {
        return roleDao.selectRole(roleId);
    }

    @Override
    @Transactional
    public int addRole(Role role) {
        int roleId = roleDao.insertRole(role);
        return roleId;
    }

    @Override
    @Transactional
    public int deleteRole(int roleId) {
        return roleDao.deleteRole(roleId);
    }

    @Override
    @Transactional
    public int updateRole(Role role) {
        return roleDao.updateRole(role);
    }
}
