/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.samples.petclinic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.samples.petclinic.vet.Specialty;
import org.springframework.samples.petclinic.vet.SpecialtyRepository;
import org.springframework.samples.petclinic.vet.Vet;
import org.springframework.samples.petclinic.vet.VetRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import java.util.logging.LogRecord;
import java.util.logging.StreamHandler;

/**
 * PetClinic Spring Boot Application.
 *
 * @author Dave Syer
 */

@Slf4j
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "ProductStore API", version = "2.0", description = "ProductStore Information"))
public class PetClinicApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetClinicApplication.class, args);
	}

	/*
	 * 1 Crear un objeto Vet sin Speciality 2 Persistir el objeto Vet en BBDD 3 Consultar
	 * por ID y comprobar que se ha creado correctamente 4 Editar el elemento recién
	 * creado para añadir una Speciality concreta 5 Listar todos los veterinarios
	 * existentes
	 */

	@Bean
	public CommandLineRunner demoVetRepository(VetRepository vetRepository, SpecialtyRepository specialtyRepository) {
		return (args) -> {
//			log.info("*****************************************************");
//			log.info("BOOTCAMP - Spring y Spring Data - vetRepository");
//			log.info("*****************************************************");
//
//			log.info("Creamos un objeto Vet");
			Vet vet = new Vet();
			vet.setFirstName("Sergio");
			vet.setLastName("Raposo Vargas");
//			log.info("Tienes id ? " + vet.getId());
//
//			log.info("Persistimos en BBDD");
			vetRepository.save(vet);
//
//			log.info("Comprobamos que se ha creado correctamente");
			Vet vetAux = vetRepository.findById(vet.getId());
//			log.info(vetAux.toString());
//			log.info("Editamos el objeto y añadimos una Speciality");
			Specialty s = specialtyRepository.findById(1);
			vet.addSpecialty(s);
			vetRepository.save(vet);
//			log.info(vet.toString());
//
//			log.info("Listamos todos los veterinarios");
//			for (Vet v : vetRepository.findAll()) {
//				log.info("Vet: " + v.getFirstName());
			};
		};
	}


