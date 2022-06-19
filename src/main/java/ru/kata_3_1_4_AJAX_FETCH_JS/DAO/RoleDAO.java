package ru.kata_3_1_4_AJAX_FETCH_JS.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.kata_3_1_4_AJAX_FETCH_JS.model.Role;
import javax.transaction.Transactional;

@Repository
@Transactional
public interface RoleDAO extends JpaRepository<Role, Long> {
}
