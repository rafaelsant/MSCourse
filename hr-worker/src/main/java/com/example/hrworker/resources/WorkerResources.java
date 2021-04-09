package com.example.hrworker.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hrworker.entities.Worker;
import com.example.hrworker.repositories.WorkerRepository;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResources {

	private static Logger logger = LoggerFactory.getLogger(WorkerResources.class);
	
	@Autowired
	private Environment env;
	
	@Autowired
	private WorkerRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Worker>> FindAll(){
		List<Worker> list = new ArrayList<Worker>();
		list = repository.findAll();
		return ResponseEntity.ok(list);
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<Optional<Worker>> FindOne(@PathVariable Long id){
		
		logger.info("PORT = "+ env.getProperty("local.server.port"));
		
		Optional<Worker> worker = repository.findById(id);
		return ResponseEntity.ok(worker);
	}
}
