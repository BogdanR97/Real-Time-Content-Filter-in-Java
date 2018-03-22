//package stocksFeed;

public class NotEqual extends NodeOperation implements Operation {
	public boolean accept(OperationVisitor operationVisitor){
		return operationVisitor.visit(this);
	}
	
	public NotEqual(Operation left, Operation right){
		super(left, right);
	}
}
