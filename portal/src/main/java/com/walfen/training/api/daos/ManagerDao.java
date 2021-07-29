package com.walfen.training.api.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.walfen.training.api.entities.Manager;

public interface ManagerDao extends JpaRepository<Manager, Long> {

	List<Manager> findAllByOrderByBirthdayDesc();

}
