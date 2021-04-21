package com.walfen.training.api.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.walfen.training.api.entities.Address;

public interface AddressDao extends JpaRepository<Address, Long>  {

}
