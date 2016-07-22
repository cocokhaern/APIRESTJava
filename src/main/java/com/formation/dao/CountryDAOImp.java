package com.formation.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.formation.metier.Country;
import com.formation.metier.Continent;

public class CountryDAOImp implements ICountryDAO {

	public CountryDAOImp(){
		super();
	}
	
	@Override
	public boolean createCountry(Country country) {
		Statement state = null;
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String url = "jdbc:mysql://localhost:3306/world";
			String user = "root";
			String password = "";
			
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("Connection effectuée");

			state = conn.createStatement();

			int result = state.executeUpdate(
					"INSERT INTO `country` (`Code`, `Name`, `Continent`, `Region`, `Population`) VALUES ('"
							+ country.getCode() + "', '" + country.getName() + "', '"
							+ country.getContinent().toString() + "', '" + country.getRegion() + "', '"
							+ country.getPopulation() + "')");
			state.close();
			conn.close();

			if (result != 0)
				return true;
			else
				return false;

		} catch (Exception e) {
			System.out.println("ERREUR !");
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (state != null)
					state.close();

				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

	@Override
	public Country retrieveCountryAvecId(String code) {

		Connection conn = null;
		Statement state = null;

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String url = "jdbc:mysql://localhost:3306/world";
			String user = "root";
			String password = "";

			conn = DriverManager.getConnection(url, user, password);
			System.out.println("Connection effectuée");

			state = conn.createStatement();

			ResultSet result = state.executeQuery("SELECT * FROM `country` WHERE `Code`=\"" + code+"\"");

			if (result.next()) {
				Country foundCountry = new Country();
				foundCountry.setCode(result.getString("Code"));
				foundCountry.setName(result.getString("Name"));
				foundCountry.setContinent(Continent.fromString(result.getString("Continent")));
				foundCountry.setRegion(result.getString("Region"));
				foundCountry.setPopulation(result.getInt("Population"));
				state.close();
				conn.close();
				return foundCountry;
			} else {
				state.close();
				conn.close();
				return null;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (state != null)
					state.close();

				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return null;

	}

	@Override
	public List<Country> retrieveAllCountry() {
		Connection conn = null;
		Statement state = null;

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String url = "jdbc:mysql://localhost:3306/world";
			String user = "root";
			String password = "";

			conn = DriverManager.getConnection(url, user, password);
			System.out.println("Connection effectuée");

			state = conn.createStatement();

			ResultSet result = state.executeQuery("SELECT * FROM `country`");

			Country foundCountry = null;
			List<Country> countryList = new ArrayList<>();
			
			while (result.next()) {
				foundCountry = new Country();
				foundCountry.setCode(result.getString("Code"));
				foundCountry.setName(result.getString("Name"));
				foundCountry.setContinent(Continent.fromString(result.getString("Continent")));
				foundCountry.setRegion(result.getString("Region"));
				foundCountry.setPopulation(result.getInt("Population"));
				countryList.add(foundCountry);
			} 
			state.close();
			conn.close();
			return countryList;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (state != null)
					state.close();

				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return null;
	}

	@Override
	public boolean updateCountry(Country country) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCountryAvecId(String code) {
		// TODO Auto-generated method stub
		return false;
	}

}
