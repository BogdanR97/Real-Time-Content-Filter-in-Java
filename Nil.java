//package stocksFeed;

public class Nil extends NodeOperation implements Operation {
	
	public Nil(Operation left, Operation right){
		super(left, right);
	}
	
	public boolean accept(OperationVisitor operationVisitor){
		return operationVisitor.visit(this);
	}
	
}
