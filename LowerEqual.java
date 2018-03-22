//package stocksFeed;

public class LowerEqual extends NodeOperation implements Operation {
	
	public boolean accept(OperationVisitor operationVisitor){
		return operationVisitor.visit(this);
	}
	
	public LowerEqual(Operation left, Operation right){
		super(left, right);
	}
}
