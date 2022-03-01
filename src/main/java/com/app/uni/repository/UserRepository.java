package com.app.uni.repository;

import com.app.uni.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {

    User findByEmail(String email);
    User findUserByUsernameAndPassword(String username, String password);

    @Modifying
    @Transactional
    @Query(value = "delete from Users u where u.id in :listIds", nativeQuery = true)
    void deleteUserByIds(@Param("listIds") List <Long> listIds);
}
