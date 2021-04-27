package com.walfen.training.api.controllers;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.walfen.training.api.entities.Manager;
import com.walfen.training.api.services.ManagerService;


@RestController
@RequestMapping("/manager")
public class ManagerController {
	
		@Resource
		private ManagerService managerService;

		@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public List<Manager> list() {

			return managerService.list();
		}
		
		@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public Manager get(@PathVariable Long id) {

			return managerService.get(id);
		}

		@ResponseStatus(HttpStatus.CREATED)
		@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public Manager create(@RequestBody Manager manager) {

			return managerService.create(manager);
		}

		@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public Manager update(@PathVariable Long id, @RequestBody Manager manager) {

			return managerService.update(manager);
		}
		
		@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
		@ResponseStatus(HttpStatus.NO_CONTENT)
		public void delete(@PathVariable Long id) {
			managerService.delete(id);
		}
		
	}


