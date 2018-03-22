//package stocksFeed;

public class Lower extends NodeOperation implements Operation {
	
	public boolean accept(OperationVisitor operationVisitor){
		return operationVisitor.visit(this);
	}
	
	public Lower(Operation left, Operation right){
		super(left, right);
	}
}
