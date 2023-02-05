package org.springframework.samples.petclinic.vet;

import org.springframework.data.repository.Repository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import java.util.Collection;

public interface SpecialityRepository extends Repository<Vet, Integer>{

	@Transactional(readOnly = true)
	@Cacheable("vets")
	Collection<Vet> findAll() throws DataAccessException;
	
	Page<Vet> findAll(Pageable pageable) throws DataAccessException;
	
	void save(Specialty speciality);
	
	Specialty findById(@Param("id") Integer id);
}