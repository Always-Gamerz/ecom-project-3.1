package com.dy.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dy.Model.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
	 

}
