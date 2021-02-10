package com.robertbuckley.DriversLicense.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.robertbuckley.DriversLicense.models.DLModels;

@Repository
public interface PersonRepository extends CrudRepository<DLModels, Long> {
	List<DLModels> findAll();
	@Query(value="SELECT p.* FROM persons p LEFT OUTER JOIN licenses l ON p.id = l.person_id WHERE l.id IS NULL", nativeQuery=true)
	List<DLModels> findByNoLicense();
	
	List<DLModels> findByLicenseIdIsNull();

}
