package com.formation.dao;

import java.util.List;

import com.formation.metier.Country;

public interface ICountryDAO {
	
	public boolean createCountry(Country country);

	public Country retrieveCountryAvecId(String code);

	public List<Country> retrieveAllCountry();

	public boolean updateCountry(Country country);

	public boolean deleteCountryAvecId(String code);

}
