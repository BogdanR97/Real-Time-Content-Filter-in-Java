//package stocksFeed;

/**
 * Clasa construita conform Factory si Singleton Design Patterns
 * pentru crearea de operatori;
 * @author bogdan
 *
 */
public class OperationFactory {
	
	private static OperationFactory factory = new OperationFactory();
	
	private OperationFactory(){}
	
	/**
	 * Conform Singleton Design Pattern, se va genera o singura instanta de tipul
	 * OperationFactory;
	 * @return instanta de tipul OperationFactory;
	 */
	public static OperationFactory getFactory(){
		return factory;
	}

	/**
	 * @param opType tipul operatorului;
	 * @param left nodul stang;
	 * @param right nodul drept;
	 * @return nodul corespunzator Stringului introdus;
	 */
	public Operation getOperation(String opType, Operation left, Operation right){
		
		if(opType.equals("nil")){
			return new Nil(left, right);
		}
		
		if(opType.equals("eq")){
			return new Equal(left, right);
		}
		
		else if(opType.equals("ne")){
			return new NotEqual(left, right);
		}
		
		else if(opType.equals("gt")){
			return new Greater(left, right);
		}
		
		else if(opType.equals("ge")){
			return new GreaterEqual(left, right);
		}
		
		else if(opType.equals("lt")){
			return new Lower(left, right);
		}
		
		else if(opType.equals("le")){
			return new LowerEqual(left, right);
		}
		
		else if(opType.equals("&&")){
			return new LogicalAND(left, right);
		}
		
		else if(opType.equals("||")){
			return new LogicalOR(left, right);
		}
		
		else if(opType.matches("[0-9]+\\.[0-9]+|[0-9]+"))
			return new ValueNode(Double.parseDouble(opType));
		
		else return new NameNode(opType);
	}
	
}
