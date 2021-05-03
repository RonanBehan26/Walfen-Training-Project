package com.walfen.training.api.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.walfen.training.api.entities.Company;

public interface CompanyDao extends JpaRepository<Company, Long> {

	List<Company> findAllByOrderByName();

	List<Company> findAllByOrderByCityDesc();

	List<Company> findAllByCity(String city);

}
