//package stocksFeed;

/**
 * Interfata ce ajuta la implementarea Visitor Design Pattern;
 * Aceasta reprezinta interfata vizitatorului;
 * Metodele corespunzatoare fiecarui tip de operator vor intoarce valoarea de adevar
 * in urma evaluarii operatiei aferente;
 * @author bogdan
 *
 */
public interface OperationVisitor {
	
	/**
	 * @param nil instanta a clsei Nil;
	 * @return metoda va intoarce true de fiecare data;
	 * deoarece feedurile nu vor trece prin nici un filtru;
	 */
	public boolean visit (Nil nil);
	
	/**
	 * Metoda verifica daca valorile/numele stockurilor sunt identice;
	 * @param eq instanta a clasei Equal;
	 * @return valoarea de adevar in urma evaluarii operatiei eq;
	 */
	public boolean visit(Equal eq);
	
	/** Metoda verifica daca valorile/numele stockurilor difera;
	 * @param ne instanta a clasei NotEqual;
	 * @return valoarea de adevar in urma evaluarii operatiei ne;
	 */
	public boolean visit(NotEqual ne);
	
	/**
	 * Meotda verifica daca valoarea stockului din feed este mai mare
	 * decat o valoare data;
	 * @param gt instanta a clasei Greater;
	 * @return valoarea de adevar in urma evaluarii operatiei gt;
	 */
	public boolean visit(Greater gt);
	
	/**
	 * Meotda verifica daca valoarea stockului din feed este mai mare 
	 * decat o valoare data sau egala cu aceasta;
	 * @param ge instanta a clasei GreaterEqual;
	 * @return valoarea de adevar in urma evaluarii operatiei ge;
	 */
	public boolean visit(GreaterEqual ge);
	
	/**
	 * Metoda verifica daca valoarea stockului din feed este mai mica
	 * decat o valoare data
	 * @param lt instanta a clasei Lower;
	 * @return valoarea de adevar in urma evaluarii operatiei lt;
	 */
	public boolean visit(Lower lt);
	
	/**
	 * Metoda verifica daca valoarea stockului din feed este mai mica
	 * decat o valoare data sau egala cu aceasta;
	 * @param le instanta a clasei LowerEqual;
	 * @return valoarea de adevar in urma evaluarii operatiei le;
	 */
	public boolean visit(LowerEqual le);
	
	/**
	 * Nodul fiind o frunza, insemnand ca acesta nu implementeaza o operatie,
	 * ci retine o valoare, in urma vizitarii acestuia se va intoarce valoarea respectiva;
	 * @param db instanta a clasei ValueNode;
	 * @return valoarea din nod;
	 */
	public double visit(ValueNode db);
	
	/**
	 * Nodul fiind o frunza, insemnand ca acesta nu implementeaza o operatie,
	 * ci retine un nume al unui feed, in urma vizitarii acestuia se va intoarce numele respectiv;
	 * @param nn instanta a clasei NameNode;
	 * @return numele din nod;
	 */
	public String visit(NameNode nn);
	
	/**Metoda implementeaza Logical And intre doua noduri de tip
	 * Equal, NotEqual, Greater, GreaterEqual, Lower, LowerEqual;
	 * @param loa instanta a clasei LogicalAND;
	 * @return valoarea de adevar in urma evaluarii operatiei &&;
	 */
	public boolean visit(LogicalAND loa);
	
	/**Metoda implementeaza Logical Or intre doua noduri de tip
	 * Equal, NotEqual, Greater, GreaterEqual, Lower, LowerEqual;
	 * @param lor instanta a clasei LogicalOR;
	 * @return valoarea de adevar in urma evaluarii operatiei ||;
	 */
	public boolean visit(LogicalOR lor);
}
