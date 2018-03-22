//package stocksFeed;

public class Greater extends NodeOperation implements Operation {
	
	public boolean accept(OperationVisitor operationVisitor){
		return operationVisitor.visit(this);
	}
	
	public Greater(Operation left, Operation right){
		super(left, right);
	}
}
