package ru.kata_3_1_4_AJAX_FETCH_JS.service;

import ru.kata_3_1_4_AJAX_FETCH_JS.model.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {
    List<Role> findAllRole();
    void addDefaultRole();
    //void addRole(Role role);
    Set<Role> findByIdRoles(List<Long>roles);
}

