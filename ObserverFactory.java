//package stocksFeed;

/**
 * Clasa construita conform Factory si Singleton Design Patterns
 * pentru crearea de observatori;
 * @author bogdan
 *
 */
public class ObserverFactory {
	
	/* Conform Singleton Design Pattern, se va genera o singura instanta de tipul
	 * ObserverFactory */	
	private static ObserverFactory factory = new ObserverFactory();
	
	private ObserverFactory(){}
	
	/**
	 * Conform Singleton Design Pattern, se va genera o singura instanta de tipul
	 * ObserverFactory;
	 * @return instanta de tipul ObserverFactory;
	 */
	public static ObserverFactory getFactory(){
		return factory;
	}
	
	/**
	 * @param subject feedurile ce sunt urmarite de catre observator;
	 * @param expressionTokens elementele necesare construirii arborelui de expresie;
	 * @return o instanta de tip Observer;
	 */
	public AbstractObserver getObserver(Subject subject, String[] expressionTokens){
		
		return new Observer(subject, expressionTokens);
	}
}
