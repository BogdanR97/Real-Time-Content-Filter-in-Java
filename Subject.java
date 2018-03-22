//package stocksFeed;
import java.util.*; 


/**
 * Clasa construita conform Observer Design Pattern;
 * @author bogdan
 *
 */
public class Subject {
	
	/* In acest ArrayList sunt retinuti toti observatorii ce trebuie notificati
	 * in privinta actualizarii feedurilor */
	private ArrayList<AbstractObserver> observers;
	
	/* TreeMap ce contine toate stockurile */
	private TreeMap<String, Double> stocks;

	public Subject(){
		observers = new ArrayList<AbstractObserver>();
		stocks = new TreeMap<String, Double>();
	}
	
	public TreeMap<String, Double> getStocks(){
		return stocks;
	}
	
	/**
	 * Metoda asigura adaugarea/actualizarea stockului si apelarea metodei 
	 * ce notifica toti observatorii in privinta acestui fapt;
	 * @param name numele stockului ce trebuie adaugat/actualizat;
	 * @param stockValue valoarea stockului ce trebuie adaugat/actualizat;
	 */
	public void addStock(String name, double stockValue){
		stocks.put(name, stockValue);
		notifyAllObservers(name);
	}
	
	/**
	 * @param observer observatorul ce trebuie atasat (adaugat in ArrayList observers;
	 */
	public void attach(Observer observer){
		observers.add(observer);
	}
	
	/**
	 * @param observer observatorul ce trebuie detasat (sters din ArrayList observers;
	 */
	public void detach(Observer observer){
		observers.remove(observer);
	}
	
	/**
	 * Metoda prin care toti observatorii sunt notificati de adaugarea/actualizarea
	 * unui anumit stock;
	 * @param name numele stockului;
	 */
	public void notifyAllObservers(String name){
		for(AbstractObserver observer : observers){
			observer.update(name);
		}
	}
}
