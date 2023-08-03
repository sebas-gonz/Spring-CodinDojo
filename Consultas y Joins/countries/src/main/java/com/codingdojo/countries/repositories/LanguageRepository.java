package com.codingdojo.countries.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.codingdojo.countries.models.Language;

public interface LanguageRepository extends CrudRepository<Language,Long>{
	
//	4. ¿Qué consulta ejecutarías para obtener todos los idiomas en cada país con un porcentaje superior al 89%?
//	Tu consulta debe organizar el resultado por porcentaje en orden descendente.
	
	@Query("SELECT c.name, l.language, l.percentage FROM Language l INNER JOIN l.country c WHERE l.percentage > 89.0 ORDER BY l.percentage DESC")
	List<Object[]> findLanguageByPercentage();
	
}
