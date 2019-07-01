package org.springframework.samples.petclinic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.model.PetType;
import org.springframework.samples.petclinic.repository.PetRepository;
import org.springframework.stereotype.Service;

@Service
public class PetService {
	
	@Autowired
	private PetRepository reposiroty;

	public List<PetType> findPetTypes(){
		return reposiroty.findPetTypes();
	}
	
	public Pet findById(Integer id) {
		return reposiroty.findById(id);
	}
	
	public void save(Pet pet) {
		reposiroty.save(pet);
	}
	
}
