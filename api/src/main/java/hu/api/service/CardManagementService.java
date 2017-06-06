package hu.api.service;

import java.util.Collection;

import hu.api.Simcard;

public interface CardManagementService {
	
	Collection<Simcard> listCards();
	void acquireSimcard(Simcard simcard);

}
