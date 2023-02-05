package org.springframework.samples.petclinic.vet;

import org.springframework.stereotype.Service;

@Service

public class VetService {
	
	private final VetRepository vetRepository;
	
	public Vets showResourcesVetList() {
		Vets vets = new Vets();
		vets.getVetList().addAll(this.vetRepository.findAll());
	}
}