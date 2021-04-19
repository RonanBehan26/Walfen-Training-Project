package com.walfen.training.api.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.walfen.training.api.entities.Company;

public interface CompanyDao extends JpaRepository<Company, Long> {

}
