package com.app.uni.repository;

import com.app.uni.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface RolesRepository extends JpaRepository<Roles, Long> {

    @Modifying
    @Transactional
    @Query(value = "delete from Roles r where r.id in :listIds", nativeQuery = true)
    void deleteRoleByIds(@Param("listIds") List<Long> listIds);
}
