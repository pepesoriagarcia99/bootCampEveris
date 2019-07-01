package org.springframework.samples.petclinic.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.repository.OwnerRepository;
import org.springframework.stereotype.Service;

@Service
public class OwnerService {
	
	@Autowired
	private OwnerRepository ownerRepository;
	
	public Owner findById(int id) {
		return ownerRepository.findById(id);
	}
	
	public Collection<Owner> findByLastName(String lastName){
		return ownerRepository.findByLastName(lastName);
	}
	
	public void save(Owner owner) {
		ownerRepository.save(owner);
	}
}
