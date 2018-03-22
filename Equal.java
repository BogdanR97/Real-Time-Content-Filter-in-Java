//package stocksFeed;

public class Equal extends NodeOperation implements Operation {
	
	public boolean accept(OperationVisitor operationVisitor){
		return operationVisitor.visit(this);
	}
	
	public Equal(Operation left, Operation right){
		super(left, right);
	}
}
