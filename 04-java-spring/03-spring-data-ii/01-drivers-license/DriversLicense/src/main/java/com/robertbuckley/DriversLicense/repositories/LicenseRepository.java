package com.robertbuckley.DriversLicense.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.robertbuckley.DriversLicense.models.LicenseModels;

@Repository
public interface LicenseRepository extends CrudRepository<LicenseModels, Long> {
	List<LicenseModels> findAll();
	LicenseModels findTopByOrderByNumberDesc();
}
