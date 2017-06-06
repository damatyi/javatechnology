package hu.persist;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import hu.api.Simcard;
import hu.service.CardDAO;

public class CardDAOJSON implements CardDAO{
	
	private File database;
	

	public CardDAOJSON(String databasePath) {
		this.database = new File(databasePath);
	}

	public void createCard(Simcard simcard) {
		Collection<Simcard> allCards = readCards();
		allCards.add(simcard);
		Simcard[] extendedDatabase = allCards.toArray(new Simcard[allCards.size()]);
		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.writeValue(database, extendedDatabase);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {	
		}
	}

	public Collection<Simcard> readCards() {
		ObjectMapper mapper = new ObjectMapper();
		Simcard[] cards = new Simcard[]{};
		try {
			cards = mapper.readValue(database, Simcard[].class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			
		}
		Collection<Simcard> result = new ArrayList<Simcard>(Arrays.asList(cards));
		return result;
	}



}
