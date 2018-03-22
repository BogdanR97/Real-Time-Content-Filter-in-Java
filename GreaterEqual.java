//package stocksFeed;

public class GreaterEqual extends NodeOperation implements Operation {
	
	public boolean accept(OperationVisitor operationVisitor){
		return operationVisitor.visit(this);
	}
	
	public GreaterEqual(Operation left, Operation right){
		super(left, right);
	}
}
