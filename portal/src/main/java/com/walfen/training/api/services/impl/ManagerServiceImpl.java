package com.walfen.training.api.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;

import com.walfen.training.api.daos.ManagerDao;
import com.walfen.training.api.entities.Manager;
import com.walfen.training.api.services.ManagerService;

@Service
public class ManagerServiceImpl implements ManagerService {


		private static final Logger LOGGER = LoggerFactory.getLogger(ManagerServiceImpl.class);
		
		@Resource
		private ManagerDao managerDao;

		@Override
		@Transactional(readOnly = true)
		public List<Manager> list() {
			LOGGER.info("list managers");
			return managerDao.findAll();
		}
		
		@Override
		@Transactional(readOnly = true)
		public Manager get(Long id) {
			LOGGER.info("get manager - id: {}", id);
			return managerDao.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
		}


		@Override
		@Transactional
		public Manager create(Manager manager) {
			LOGGER.info("create manager");
			return managerDao.save(manager);
		}

		@Override
		@Transactional
		public Manager update(Manager manager) {
			LOGGER.info("update manager - id: {}", manager.getId());

			Manager storedManager = managerDao.findById(manager.getId()).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
			storedManager.setFirstName(manager.getFirstName());
			storedManager.setLastName(manager.getLastName());
			storedManager.setCompany(manager.getCompany());
			storedManager.setBirthday(manager.getBirthday());

			return managerDao.save(storedManager);
		}

		@Override
		@Transactional
		public void delete(Long id) {
			LOGGER.info("delete manager - id: {}", id);
			
			managerDao.deleteById(id);
			
		}	


}