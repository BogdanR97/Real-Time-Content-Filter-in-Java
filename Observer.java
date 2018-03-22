//package stocksFeed;
import java.text.DecimalFormat;
import java.util.*;

/**
 * Clasa concreta de observatori, ale carei metode si atribute gestioneaza interactiunea
 * unui observator cu fluxul de feed-uri, construita conform Observer Design Pattern;
 * @author bogdan
 *
 */
public class Observer extends AbstractObserver {
	
	/* TreeMap in care sunt retinute stockurile ce trec de filtrul observatorului */
	private TreeMap<String, Double> filteredStocks;
	
	/* TreeMap in care sunt retinute stockurile ce sunt actualizate 
	 * si numarul de actualizari ale acestora de la ultima afisare a feed-ului specific observatorului */
	private TreeMap<String, Integer> updatedStocks;
	
	/* expressionFilter - obiectul de tip ExpressionTree se ocupa cu construirea
	 * arborelui de expresie  */
	private ExpressionTree expressionFilter;
	
	/* elementele din arborele de expresie-sub forma de tokenuri-
	 * pentru construirea ulterioara a acestuia */
	private String[] expressionTokens;
	
	private DecimalFormat df = new DecimalFormat("0.00");
	
	/**
	 * @param subject totalitatea stockurilor ce sunt urmarite de observatori
	 * @param expressionTokens elementele din arborele de expresie
	 */
	public Observer(Subject subject, String[] expressionTokens){
		this.subject = subject;
		this.subject.attach(this);
		this.expressionTokens = expressionTokens;
		filteredStocks = new TreeMap<String, Double>();
		updatedStocks = new TreeMap<String, Integer>();
	}
	
	public void update(String name){
		
		if(updatedStocks.containsKey(name)){
			int change = updatedStocks.get(name);
			change ++;
			updatedStocks.put(name, change);
		}
		else
			updatedStocks.put(name, 1);
	}
	
	public void print(TreeMap<String, Double> stocks, int id){
		
		for(Map.Entry<String, Double> entry: stocks.entrySet()){
			/* pentru fiecare feed se va crea arborele de expresie corespunzator */
			expressionFilter = new ExpressionTree(expressionTokens, entry.getKey(), Double.toString( entry.getValue() ) );
			
			/* in urma evaluarii arborelui de expresie, se va decide daca feed-ul trece/nu trece de filtru */
			if( expressionFilter.FilterFeed() ){
				
				double fluctuation;
				int changes;
				String filteredStockKey = entry.getKey();
				Double filteredStockValue = entry.getValue();
				
				/* se calculeaza flcutuatia stockului de la ultima afisare;
				 * se va afisa 0% daca acesta nu a fost afisat si in trecut */
				
				if (filteredStocks.containsKey(filteredStockKey) )
					fluctuation = (filteredStockValue - filteredStocks.get(filteredStockKey)) / filteredStocks.get(filteredStockKey) * 100;
				else
					fluctuation = 0;
				
				if(updatedStocks.get(filteredStockKey) == null)
					changes = 0;
				else
					changes = updatedStocks.get(filteredStockKey);
					
				System.out.println("obs " + id + ": " + filteredStockKey + " " +  df.format(filteredStockValue) + " " + df.format(fluctuation) + "%" + " " + changes );
				
				/* in urma afisarii stockului, se reseteaza numarul de schimbari ale acestuia */
				updatedStocks.put(entry.getKey(), 0);
				
				/* daca stockul trece de filtru, acesta va fi introdus in TreeMap-ul corespunzator */
				filteredStocks.put(entry.getKey(), entry.getValue());
			}
				
		}
	}
	
}
