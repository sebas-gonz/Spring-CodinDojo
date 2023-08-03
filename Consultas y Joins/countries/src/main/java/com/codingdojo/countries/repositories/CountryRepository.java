package com.codingdojo.countries.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.codingdojo.countries.models.Country;

public interface CountryRepository extends CrudRepository<Country, Long>{
	
	
//	1. ¿Qué consulta ejecutarías para obtener todos los países que hablan Sloveno? Su consulta debe retornar el nombre del país, lenguaje y porcentaje del lenguaje. 
//	Su consulta debe organizar los resultados por porcentaje en orden descendente.

	@Query("SELECT c.name, l.language, l.percentage FROM Country c INNER JOIN c.languages l WHERE l.language = 'Slovene' ORDER BY l.percentage DESC")
	List<Object[]> findCountriesWithSloveneLanguage();
	
	
//	2. ¿Qué consulta ejecutarías para mostrar el número total de ciudades para cada país? Su consulta debe devolver el nombre del país y el número total de ciudades
//			 Tu consulta debe organizar el resultado por el número de ciudades en orden descendente.

	@Query("SELECT c.name, COUNT(ct.id) FROM Country c INNER JOIN c.cities ct GROUP BY c.name ORDER BY COUNT(ct.id) DESC")
	List<Object[]> findCitiesByCountries();
	
	
//	5. ¿Qué consulta haría para obtener todos los países con un área de superficie inferior a 501 y una población superior a 100,000?
	
	@Query("SELECT c.name, c.surface_area, c.population FROM Country c WHERE c.surface_area < 501 AND c.population > 100000")
	List<Object[]> findCountriesBySurface();
	
//	6. ¿Qué consulta harías para obtener países con solo Monarquía Constitucional con un capital superior a 200 y una esperanza de vida superior a 75 años?
	
	@Query("SELECT c.name, c.government_form, c.capital, c.life_expectancy FROM Country c WHERE c.government_form = 'Constitutional Monarchy' AND c.capital > 200 AND c.life_expectancy > 75")
	List<Object[]> findCountriesByGobMonarchy();
	
//	8. ¿Qué consulta harías para resumir el número de países en cada región? La consulta debe mostrar el nombre de la región y el número de países
//			 Además, la consulta debe organizar el resultado por el número de países en orden descendente.
	
	@Query("SELECT c.region, COUNT(c.name) FROM Country c GROUP BY c.region ORDER BY COUNT(c.name) DESC")
	List<Object[]> findCountriesByRegion();
}
