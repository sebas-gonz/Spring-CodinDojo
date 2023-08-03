package com.codingdojo.countries.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.codingdojo.countries.models.City;

public interface CityRepository extends CrudRepository<City, Long> {

//	3. ¿Qué consulta harías para obtener todas las ciudades de México con una población de más de 500,000? Tu consulta debe organizar el resultado por población en orden descendente.
	
	@Query("SELECT ct.name, ct.population, c.id FROM City ct INNER JOIN ct.country c WHERE c.name = 'Mexico' AND ct.population > 500000 ORDER BY ct.population DESC")
	List<Object[]> findCitiesOfMexicoByPopulation();
	
//	*7. ¿Qué consulta harías para obtener todas las ciudades de Argentina dentro del distrito de Buenos Aires y tener una población superior a 500,000?
//			 La consulta debe devolver el nombre del país, el nombre de la ciudad, el distrito y la población.
	
	@Query("SELECT c.name, ct.name, ct.district, ct.population FROM City ct INNER JOIN ct.country c WHERE ct.district = 'Buenos Aires' AND ct.population > 500000")
	List<Object[]> findCitiesArg();
}
