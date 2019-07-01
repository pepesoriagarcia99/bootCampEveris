package org.springframework.samples.petclinic.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.samples.petclinic.model.Bill;
import org.springframework.samples.petclinic.service.BillService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillController {
	@Autowired
	private BillService service;
	
	@RequestMapping(value="/bills", method=RequestMethod.GET)
	public List<Bill> findAll(){
		List<Bill> l = new ArrayList<Bill>();
//		l = service.findAll();
//		for(Bill i : l) {
//			System.err.println(i.toString());
//		}
		return l;
	}
	
	@RequestMapping(value="/bill/{idBill}", method=RequestMethod.GET)
	public Bill findById(@PathVariable("idBill") Integer id){
		return service.findById(id);
	}
	
	@RequestMapping(value="/bill", method=RequestMethod.POST)
	public ResponseEntity<Bill> save(Bill bill) {
		if(bill != null) {
			
			//OK, FORBIDDEN, BAD_REQUEST
			return ResponseEntity.status(HttpStatus.OK).body(this.service.save(bill));
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}
	
	@RequestMapping(value="/bill/{idBill}", method=RequestMethod.PUT)
	public ResponseEntity<Bill> edit(@PathVariable("idBill") int idBill,Bill bill) {
		if(bill != null && idBill > 0) {
			Bill b = service.findById(idBill);
			if(b != null) {
				bill.setId(idBill);
				bill = service.save(bill);
			}
			//OK, FORBIDDEN, BAD_REQUEST
			return ResponseEntity.status(HttpStatus.OK).body(bill);
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}
	
	@RequestMapping(value="/bills", method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteAll() {
		service.deleteAll();
		//OK, FORBIDDEN, BAD_REQUEST
		return ResponseEntity.status(HttpStatus.OK).body("");
	}
	
	@RequestMapping(value="/bill/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Bill> deleteOne(@PathVariable("id") int idBill) {
		Bill b = service.findById(idBill);
		if ( b != null) {
			service.delete(idBill);
			return ResponseEntity.status(HttpStatus.OK).body(b);
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}
	
	@RequestMapping(value="/bill/filtro/{filter}", method=RequestMethod.GET)
	public ResponseEntity<Bill> pagadas(@RequestParam("filter") String filter) {
		List<Bill> bills;
		bills = service.filter(filter);
		
		return null;
	}
	
	
}
