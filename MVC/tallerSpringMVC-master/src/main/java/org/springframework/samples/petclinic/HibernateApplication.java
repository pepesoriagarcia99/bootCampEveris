package org.springframework.samples.petclinic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.samples.petclinic.model.Bill;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.model.Visit;
import org.springframework.samples.petclinic.service.BillService;
import org.springframework.samples.petclinic.service.PetService;
import org.springframework.samples.petclinic.service.VisitService;

@SpringBootApplication
public class HibernateApplication implements CommandLineRunner {
	
	@Autowired 
	private BillService billService;
	
	@Autowired
	private VisitService visitService;
	@Autowired
	private PetService petService;
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(HibernateApplication.class, args);
	}
	
	@Override
	@Transactional
	public void run(String... args) {
		System.out.println("\n\nPruebas de Hibernate\n=====================\n\n");
		Pet p = petService.findById(8);
		List<Visit> visits = visitService.findByPetId(p.getId());
		for(Visit v : visits) {
			System.out.println(v.toString());
		}
		
		/***
		 * Crear aquí las facturas y enlazarlas, por último, volver a mostrar dichas visitas
		 */
		Bill b = new Bill();
		b.setIdNumber(1234567890);
		b.setMoney(1.0);
		b.setPaymentDate(new Date());
		List<Bill> listaFacturas = new ArrayList<Bill>();
		listaFacturas.add(b);
		billService.saveList(listaFacturas);
		
		visits.get(0).setBill(b);
		visitService.save(visits.get(0));

		p = petService.findById(8);
		visits = visitService.findByPetId(p.getId());
		for(Visit v : visits) {
			System.out.println(v.toString());
		}
	}
}
