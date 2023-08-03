package com.codingdojo.countries.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "countries")
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(columnDefinition = "CHAR(3)")
	private String code;
	@Column(columnDefinition = "CHAR(52)")
	private String name;
	
	@Column(columnDefinition = "ENUM('Africa','Antarctica','Asia','Europe','North America','Oceania','South America')")
    private String continent;
	
	
	@Column(columnDefinition = "CHAR(26)")
	private String region;

	@Column(columnDefinition = "FLOAT(10,2)")
	private float surface_area;
	
	@Column(columnDefinition = "SMALLINT(6)")
	private short indep_year;
	
	@Column(columnDefinition = "INT(11")
	private int population;

	@Column(columnDefinition = "FLOAT(3,1)")
	private float life_expectancy;
	@Column(columnDefinition = "FLOAT(10,2)")
	private float gnp;
	@Column(columnDefinition = "FLOAT(10,2)")
	private float gnp_old;
	@Column(columnDefinition = "CHAR(45)")
	private String local_name;
	@Column(columnDefinition = "CHAR(45)")
	private String government_form;
	@Column(columnDefinition = "CHAR(60)")
	private String head_of_state;
	@Column(columnDefinition = "INT(11)")
	private int capital;
	@Column(columnDefinition = "CHAR(2)")
	private String code2;
	
	 @OneToMany(mappedBy="country", fetch = FetchType.LAZY)
	    private List<Language> languages;
	 
	 @OneToMany(mappedBy="country", fetch = FetchType.LAZY)
	    private List<City> cities;



	public Country() {

	}
	

	public List<Language> getLenguages() {
		return languages;
	}


	public void setLenguages(List<Language> lenguages) {
		this.languages = lenguages;
	}


	public List<City> getCities() {
		return cities;
	}


	public void setCities(List<City> cities) {
		this.cities = cities;
	}


	public Country(int id, String code, String name, String continent, String region, float surface_area,
			short indep_year, int population, float life_expectancy, float gnp, float gnp_old, String local_name,
			String government_form, String head_of_state, int capital, String code2) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.continent = continent;
		this.region = region;
		this.surface_area = surface_area;
		this.indep_year = indep_year;
		this.population = population;
		this.life_expectancy = life_expectancy;
		this.gnp = gnp;
		this.gnp_old = gnp_old;
		this.local_name = local_name;
		this.government_form = government_form;
		this.head_of_state = head_of_state;
		this.capital = capital;
		this.code2 = code2;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public double getSurface_area() {
		return surface_area;
	}

	public void setSurface_area(float surface_area) {
		this.surface_area = surface_area;
	}

	public short getIndep_year() {
		return indep_year;
	}

	public void setIndep_year(short indep_year) {
		this.indep_year = indep_year;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public double getLife_expectancy() {
		return life_expectancy;
	}

	public void setLife_expectancy(float life_expectancy) {
		this.life_expectancy = life_expectancy;
	}

	public double getGnp() {
		return gnp;
	}

	public void setGnp(float gnp) {
		this.gnp = gnp;
	}

	public double getGnp_old() {
		return gnp_old;
	}

	public void setGnp_old(float gnp_old) {
		this.gnp_old = gnp_old;
	}

	public String getLocal_name() {
		return local_name;
	}

	public void setLocal_name(String local_name) {
		this.local_name = local_name;
	}

	public String getGovernment_form() {
		return government_form;
	}

	public void setGovernment_form(String government_form) {
		this.government_form = government_form;
	}

	public String getHead_of_state() {
		return head_of_state;
	}

	public void setHead_of_state(String head_of_state) {
		this.head_of_state = head_of_state;
	}

	public int getCapital() {
		return capital;
	}

	public void setCapital(int capital) {
		this.capital = capital;
	}

	public String getCode2() {
		return code2;
	}

	public void setCode2(String code2) {
		this.code2 = code2;
	}

}

