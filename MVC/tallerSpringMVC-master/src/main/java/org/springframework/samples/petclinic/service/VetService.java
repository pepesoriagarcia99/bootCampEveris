package org.springframework.samples.petclinic.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Vet;
import org.springframework.samples.petclinic.repository.VetRepository;
import org.springframework.stereotype.Service;

@Service
public class VetService {
	
	@Autowired
	private VetRepository repository;

	public Collection<Vet> findAll(){
		return repository.findAll();
	}
}
