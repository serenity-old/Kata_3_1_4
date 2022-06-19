package ru.kata_3_1_4_AJAX_FETCH_JS.service;

import ru.kata_3_1_4_AJAX_FETCH_JS.DAO.RoleDAO;
import ru.kata_3_1_4_AJAX_FETCH_JS.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService{

    private final RoleDAO roleDAO;

    @Autowired
    public RoleServiceImpl(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    @Override
    public List<Role> findAllRole() {
        return roleDAO.findAll();
    }

    @Override
    public Set<Role> findByIdRoles(List<Long> roles) {
        return new HashSet<>(roleDAO.findAllById(roles));
    }

    @Override
    @PostConstruct
    public void addDefaultRole() {
        roleDAO.save(new Role("ROLE_USER"));
        roleDAO.save(new Role("ROLE_ADMIN"));
    }
}

