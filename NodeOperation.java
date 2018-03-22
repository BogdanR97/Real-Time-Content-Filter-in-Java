//package stocksFeed;

/**
 * Implementarea unui arbore binar pentru evaluarea expresiei de filtrare;
 * @author bogdan
 *
 */
public abstract class NodeOperation  {
	
	/* Nodurile din arbore vor fii de tipul Operation, pentru facilitarea
	 * evaluarii arborelui folosind Visitor Design Pattern */
	private Operation left, right;
	
	/**
	 * @return fiul stang al nodului;
	 */
	public Operation getLeft(){
		return left;
	}
	
	/**
	 * @return fiul drept al nodului;
	 */
	public Operation getRight(){
		return right;
	}
	
	/**
	 * Constructorul unui nod;
	 * @param left operator
	 * @param right operator
	 */
	public NodeOperation(Operation left, Operation right){
		this.left = left;
		this.right = right;
		
	}
}
