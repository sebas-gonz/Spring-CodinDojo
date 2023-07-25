package com.codingdojo.relationships.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.relationships.models.License;
import com.codingdojo.relationships.repositories.LicenseRepository;

@Service
public class LicenseService {
	
	@Autowired
	private LicenseRepository licenseRepository;
	
	public License createLicense(License license) {
		return licenseRepository.save(license);
	}
	
	
	 public String getLastNumberLicense(Long personId) {
	        List<License> licenses = licenseRepository.getLastLicenseNumberById(personId);
	        if (licenses.isEmpty()) {
	            return null;
	        } else {
	            License lastNumber = licenses.get(0);	
	            return lastNumber.getNumber();
	        }
	    }
	public License getLicenseByPersonById(Long id) {
		return licenseRepository.getLicenseByPersonId(id);
		}

}
