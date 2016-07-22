package com.formation.metier;

public enum Continent {
	ASIA("Asia"),
	EUROPE("Europe"),
	NORTH_AMERICA("North America"),
	AFRICA("Africa"),
	OCEANIA("Oceania"),
	ANTARCTICA("Antarctica"),
	SOUTH_AMERICA("South America");
	
	private String nomContinent = "";

	private Continent(String nomContinent) {
		this.nomContinent = nomContinent;
	}
	
	public String toString(){
		return nomContinent;
	}
	
	public static Continent fromString(String nomContinent){
		switch(nomContinent){
		case "Asia":
			return Continent.ASIA;
		case "Europe":
			return Continent.EUROPE;
		case "North America":
			return Continent.NORTH_AMERICA;
		case "Africa":
			return Continent.AFRICA;
		case "Oceania":
			return Continent.OCEANIA;
		case "Antarctica":
			return Continent.ANTARCTICA;
		case "South America":
			return Continent.SOUTH_AMERICA;
		default : 
			return null;
		}
	}
}
