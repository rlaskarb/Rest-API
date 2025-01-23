package com.ohgiraffers.testapi.model.dao;

import com.ohgiraffers.testapi.model.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {}
