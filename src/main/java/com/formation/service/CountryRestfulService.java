package com.formation.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.formation.dao.CountryDAOImp;
import com.formation.dao.ICountryDAO;
import com.formation.metier.Country;

@Path("/country")
public class CountryRestfulService {
	
	public static final ICountryDAO dao = new CountryDAOImp();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{param}")
	public Country retrieveCountryAvecIdToJSON(@PathParam("param") String code){
		return dao.retrieveCountryAvecId(code);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/all")
	public List<Country> retrieveCountryAvecIdToJSON(){
		return dao.retrieveAllCountry();
	}
//	
//	@POST
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.APPLICATION_JSON)
//	@Path("/create")
//	public Country createCountryFromQueryToJSON(){
////		JSONObject json = new JSONObject;
////		System.out.println(json.toString());
//		try {
//			String code = json.getString("code");
//			String name = json.getString("name");
//			String continent = json.getString("continent");
//			String region = json.getString("region");
//			int population = json.getInt("population");
//			Country country = new Country(code, name, Continent.fromString(continent), region, population);
//			dao.createCountry(country);
//			return country;
//		} catch (JSONException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//		
//	}
	
	
	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Country createCountryFromQueryToJSON(Country country){
		try{	
		dao.createCountry(country);
			return country;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	public Country countryToJSON(){
//		return dao.retrieveCountryAvecId("BEL");
//	}
//	
//	
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	public Country countryToJSONTEST(){
//		return new Country("BLA", "Blavonie", Continent.AFRICA, "Zoubilie", 54846);
//	}
//	
	
}
