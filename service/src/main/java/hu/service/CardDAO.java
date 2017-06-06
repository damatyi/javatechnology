package hu.service;

import java.util.Collection;

import hu.api.Simcard;

public interface CardDAO {
	
	void createCard(Simcard simcard);
	
	Collection<Simcard> readCards();	

}
