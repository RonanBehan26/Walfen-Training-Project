package com.walfen.training.api.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.walfen.training.api.dtos.ManagerDto;
import com.walfen.training.api.entities.Manager;
import com.walfen.training.api.services.ManagerService;

@RestController
@RequestMapping("/managers")
public class ManagerController {

	@Resource
	private ManagerService managerService;
	
	@Resource
	private ModelMapper mapper;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ManagerDto> list() {
		
		List<Manager> managers = managerService.list();
		
		return managers.stream().map( a -> mapper.map(a, ManagerDto.class)).collect(Collectors.toList());
	}	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ManagerDto get(@PathVariable Long id) {
		Manager manager = managerService.get(id);

		return mapper.map(manager, ManagerDto.class);
	}
			

	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ManagerDto create(@RequestBody ManagerDto managerDto) {
		Manager manager = mapper.map(managerDto, Manager.class);
		manager = managerService.create(manager);

		return mapper.map(manager, ManagerDto.class);
	}
	

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ManagerDto update(@PathVariable Long id, @RequestBody Manager manager) {
		
		manager = managerService.update(manager);

		return mapper.map(manager, ManagerDto.class);
	}	

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		managerService.delete(id);
	}
	
	

}
