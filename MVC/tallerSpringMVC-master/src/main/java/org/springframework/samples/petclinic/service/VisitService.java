package org.springframework.samples.petclinic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Visit;
import org.springframework.samples.petclinic.repository.VisitRepository;
import org.springframework.stereotype.Service;

@Service
public class VisitService {
	
	@Autowired
	private VisitRepository repository;

	public void save(Visit visit) {
		repository.save(visit);
	}
	
	public List<Visit> findByPetId(Integer petId){
		return repository.findByPetId(petId);
	}
}
