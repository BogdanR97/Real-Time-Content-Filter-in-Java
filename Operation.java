//package stocksFeed;

/**
 * Interfata pentru un operator, ce ajuta la implementarea Visitor Design Pattern;;
 * @author bogdan
 *
 */
public interface Operation {
	/**
	 * @param operationVisitor obiectul ce viziteaza toate nodurile
	 * pentru evaluarea acestora;
	 * @return valoarea de adevar in urma evaluarii operatiei
	 * unui nod din arborele de expresie;
	 */
	public boolean accept(OperationVisitor operationVisitor);
}
