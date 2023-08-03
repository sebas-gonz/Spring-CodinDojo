package com.codingdojo.countries.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.countries.repositories.CityRepository;
import com.codingdojo.countries.repositories.CountryRepository;
import com.codingdojo.countries.repositories.LanguageRepository;

@Service
public class ApiService {
	@Autowired
	private CityRepository cityRepo; 
	
	@Autowired
	private CountryRepository countryRepo;
	
	@Autowired
	private LanguageRepository lenguageRepo;
	
	
	//1
	public List<Object[]> findCountriesWithSloveneLanguage(){
		return countryRepo.findCountriesWithSloveneLanguage();
	}
	//2
	public List<Object[]> findCitiesByCountries(){
		return countryRepo.findCitiesByCountries();
	}
	//3
	public List<Object[]> findCitiesOfMexicoByPopulation(){
		return cityRepo.findCitiesOfMexicoByPopulation();
	}
	//4
	public List<Object[]> findLanguageByPercentage(){
		return lenguageRepo.findLanguageByPercentage();
	}
	//5
	public List<Object[]> findCountriesByDensity(){
		return countryRepo.findCountriesBySurface();
	}
	//6
	public List<Object[]> findCountriesByGobMonarchy(){
		return countryRepo.findCountriesByGobMonarchy();
	}
	//7
	public List<Object[]> findCitiesArg(){
		return cityRepo.findCitiesArg();
	}
	//8
	public List<Object[]> findCountriesByRegion(){
		return countryRepo.findCountriesByRegion();
	}
	
}
