package com.rauldionisio.louvores.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rauldionisio.louvores.entities.Moment;
import com.rauldionisio.louvores.repositories.MomentRepository;

@Service
public class MomentService {
	
	@Autowired
	private MomentRepository repository;
	
	public List<Moment>findAll(){
		return repository.findAll();
	}
	
	public List<Moment>findByName(String name){
		return repository.findByDescriptionContainingIgnoreCase(name);
	}
	
	public Moment insert(Moment moment) {
		return repository.save(moment);
	}
	
	public Moment findById(Long id) {
		return repository.findById(id);
	}

}
