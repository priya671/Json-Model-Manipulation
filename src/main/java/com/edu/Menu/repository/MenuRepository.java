package com.edu.Menu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edu.Menu.dao.MenuEntity;

@Repository
public interface MenuRepository extends JpaRepository<MenuEntity, Integer>{

}
