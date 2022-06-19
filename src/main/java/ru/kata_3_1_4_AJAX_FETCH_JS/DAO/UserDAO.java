package ru.kata_3_1_4_AJAX_FETCH_JS.DAO;

import ru.kata_3_1_4_AJAX_FETCH_JS.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface UserDAO extends JpaRepository<User,Long> {
    @Query("SELECT u from User u join fetch u.roles where u.username = :username")
    User findByUsername(@Param("username")String username);
}