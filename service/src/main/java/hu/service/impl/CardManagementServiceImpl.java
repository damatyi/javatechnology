package hu.service.impl;

import java.util.Collection;
import hu.api.Simcard;
import hu.api.service.CardManagementService;
import hu.service.CardDAO;

public class CardManagementServiceImpl implements CardManagementService{

	private CardDAO cardDAO;
	
	public CardManagementServiceImpl(CardDAO cardDAO) {
		super();
		this.cardDAO = cardDAO;
	}
	public Collection<Simcard> listCards() {
		return cardDAO.readCards();
	}
	public void acquireSimcard(Simcard simcard) {
		cardDAO.createCard(simcard);
	}
}
