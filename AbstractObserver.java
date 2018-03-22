//package stocksFeed;
import java.util.*;

/**
 * Clasa abstracta ce defineste atrbutele si metodele
 * ce stau la baza fiecarui observator, in conformitate cu Observer Design Pattern;
 * @author bogdan
 */
public abstract class AbstractObserver {
	protected Subject subject;
	/**
	 * Observatorul va fi notificat in privinta crearii sau actualizarii oricarui stock;
	 * Observatorul nu va retine valorea stockului actulizat, ci numarul de actualizari
	 * ale acestuia de la ultima comanda print, prin gestionarea TreeMap-ului updatedStocks;
	 * @param name numele stockului care a suferit o modificare
	 */
	public abstract void update(String name);
	
	/**
	 * @param stocks TreeMap in care se gasesc toate stockurile actuale;
	 * @param id id-ul observatorului
	 */
	public abstract void print(TreeMap<String, Double> stocks, int id);
}
