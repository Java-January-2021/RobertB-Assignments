package com.robertbuckley.DriversLicense.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.robertbuckley.DriversLicense.models.DLModels;
import com.robertbuckley.DriversLicense.models.LicenseModels;
import com.robertbuckley.DriversLicense.repositories.LicenseRepository;
import com.robertbuckley.DriversLicense.repositories.PersonRepository;

@Service
public class DriversLicenseService {
	private PersonRepository pRepo;
	private LicenseRepository lRepo;
	
	public DriversLicenseService(PersonRepository pRepo, LicenseRepository lRepo) {
		this.pRepo = pRepo;
		this.lRepo = lRepo;
	}
	
	public List<DLModels> getAllPerson(){
		return this.pRepo.findAll();
	}
	
	public List<DLModels> getUnlicensedPeople(){
		return this.pRepo.findByLicenseIdIsNull();
	}
	
	public DLModels getOnePerson(Long id) {
		return this.pRepo.findById(id).orElse(null);
	}
	
	public DLModels createPerson(DLModels newPerson) {
		return this.pRepo.save(newPerson);
	}
	
	public LicenseModels createLicense(LicenseModels newLicense) {
		newLicense.setNumber(this.generateLicenseNumber());
		return lRepo.save(newLicense);
	}
	
	public int generateLicenseNumber() {
		LicenseModels newLicense = lRepo.findTopByOrderByNumberDesc();
		if(newLicense == null) {
			return 1;
		}else {
			int largestNumber = newLicense.getNumber();
			largestNumber++;
			return(largestNumber);
		}
	}
	
	
	
	
}
