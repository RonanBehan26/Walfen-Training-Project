package com.walfen.training.api.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.walfen.training.api.daos.CompanyDao;
import com.walfen.training.api.entities.Company;
import com.walfen.training.api.services.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CompanyServiceImpl.class);

	@Resource
	private CompanyDao companyDao;

	@Override
	public List<Company> list() {
		LOGGER.info("list companies");

		return companyDao.findAll();
	}

}
