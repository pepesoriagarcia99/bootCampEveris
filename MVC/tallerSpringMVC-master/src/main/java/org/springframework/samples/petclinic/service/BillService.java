package org.springframework.samples.petclinic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Bill;
import org.springframework.samples.petclinic.repository.BillRepository;
import org.springframework.stereotype.Service;

@Service
public class BillService {
	
	@Autowired
	private BillRepository repository;

	public List<Bill> findAll(){
		return repository.findAll();
	}
	
	public Bill findById(int id) {
		return null;
	}
	
	public Bill save(Bill bill) {
		if(bill != null) {
			return repository.save(bill);
		}
		else {
			return null;
		}
	}
	
	public void saveList(List<Bill> bills) {
		repository.save(bills);
	}
	
	public void delete(int id) {
		repository.delete(id);
	}
	
	public void deleteAll() {
		repository.deleteAll();
	}
	
	public List<Bill> filter(String f){
		return repository.findByVisitAIsNull();
	}
}
