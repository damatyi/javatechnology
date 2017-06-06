package hu.console;

import java.io.BufferedReader;
//import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
//import com.fasterxml.jackson.databind.ObjectMapper;

import hu.api.Simcard;
import hu.api.service.CardManagementService;
import hu.persist.CardDAOJSON;
import hu.service.CardDAO;
import hu.service.impl.CardManagementServiceImpl;

public class App 
{
	private static CardManagementService cardManager;
	
	static {
		CardDAO cardDAO = new CardDAOJSON("resource/cards.json");
		cardManager = new CardManagementServiceImpl(cardDAO);
	}
    public static void main( String[] args ) throws IOException
    {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean run = true;
		while (run) {
			
			String line = br.readLine();
			if ("exit".equals(line)) {
				break;
			}
			if ("list sim".equals(line)) {
				listCards();
			}
			if ("add sim".equals(line)) {
				addCard();
			}
		}    	
     
    }
    
	private static void listCards() throws JsonParseException, JsonMappingException, IOException {
		System.out.println("| PIN1 | PIN2 |   PUK1   |   PUK2   |");
		System.out.println();
		
		for (Simcard simcard : cardManager.listCards()) {
			System.out.println("-------------------------------------");
			System.out.println(String.format("| %1$4d | %2$4d | %3$8d | %4$8d | ", simcard.getPin1(),simcard.getPin2(), simcard.getPuk1(), simcard.getPuk2()));
		}
//		ObjectMapper mapper = new ObjectMapper();
//		Simcard simcard = mapper.readValue(new File("C:\\cards.json"), Simcard.class);
//		System.out.println(simcard);
		
//		ObjectMapper mapper = new ObjectMapper();
//		String jsonInString = "{\"pin1\":123,\"pin2\":1234,\"puk1\":654987,\"puk2\":456789}";
//		Simcard sim1 = mapper.readValue(jsonInString, Simcard.class);
//		System.out.println(sim1);
	}

	private static void addCard() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int pin1 = 0;
		while (pin1 < 1 | pin1 > 9999){
			System.out.println("PIN1: ");
			pin1 = Integer.parseInt(br.readLine());
			}
		int pin2 = 0;
		while (pin2 < 1 | pin2 > 9999){
			System.out.println("PIN2: ");
			pin2 = Integer.parseInt(br.readLine());
			}
		int puk1 = 0;
		while (puk1 < 0 | puk1 > 99999999){
			System.out.println("PUK1: ");
			puk1 = Integer.parseInt(br.readLine());
			}
		int puk2 = 0;
		while (puk2 < 0 | puk2 > 99999999){
			System.out.println("PUK2: ");
			puk2 = Integer.parseInt(br.readLine());
			}	
		
		Simcard simcard = new Simcard(pin1,pin2,puk1,puk2);
		cardManager.acquireSimcard(simcard);

	}
}
