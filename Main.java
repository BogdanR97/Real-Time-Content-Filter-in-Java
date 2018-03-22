//package stocksFeed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeMap;

public class Main {
	
	/**
	 * Metoda proceseaza o linie din input pentru a o transforma intr-un vector de String-uri(tokens), ignorand spatiile albe din input;
	 * @param line o linie din input
	 * @return vectorul de String-uri(tokens)
	 */
	public static String[] lineTokenizer(String line){
		String[] tokens =line.trim().split("(?<=\\()|(?=\\()|(?=\\))| +");  	
    	String str =Arrays.toString(tokens);
    	tokens = str.trim().split("[ \\[,\\]]+");
    	tokens = Arrays.copyOfRange(tokens, 1, tokens.length  );
    	
    	return tokens;
	}

	/**
	 * Metoda main a programului
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		
		ObserverFactory obsFactory = ObserverFactory.getFactory();
		Subject feeds = new Subject();
		
		/* In aceasta structura TreeMap sunt pastrati toti observatorii, indexati in functie de id-ul lor */
		TreeMap<Integer, AbstractObserver> mainObservers = new TreeMap<Integer, AbstractObserver>();
		
		BufferedReader in = null;
		try{
			in = new BufferedReader(new InputStreamReader(System.in));
			
			String line = in.readLine();
			if(!line.equals("begin"))
				System.exit(-1);
			
			while(!(line = in.readLine()).equals("end")){
				
				/* In cazul in care trebuie creat un nou observator, se va genera o instanta a clasei Observer
				 * cu ajutorul fabricii de observatori ObserverFactory si se va introduce aceasta instanta in TreeMap-ul de observatori */
				
				String[] words = lineTokenizer(line);
				if(words[0].equals("create_obs")){
					mainObservers.put(Integer.parseInt(words[1]), obsFactory.getObserver(feeds, Arrays.copyOfRange(words, 2, words.length)));
				}
				
				/* In cazul in care trebuie sters un anumit observator(in functie de id), instanta acestuia va fi stearsa
				 * din TreeMap-ul observatorilor si de asemena,  nu va mai fi notificat in privinta actualizarii feed-urilor
				 * prin detasarea de la subiect */
				
				else if(words[0].equals("delete_obs")){
					int obs_id = Integer.parseInt(words[1]);
					feeds.detach((Observer)mainObservers.get(obs_id));
					mainObservers.remove(obs_id);
				}
				/* In cazul comnezii print, se va afisa feed-ul corespunzator utlizatorului specificat in comanda */
				
				else if(words[0].equals("print")){
					int obs_id = Integer.parseInt(words[1]);
					mainObservers.get(obs_id).print(feeds.getStocks(), obs_id);
				}
				
				/* Comanda feed actualizeaza sau creeaza stock-ul specificat in comanda */
				
				else if(words[0].equals("feed")){
					feeds.addStock(words[1], Double.parseDouble(words[2]));
					
				}
			}
			
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}

}
