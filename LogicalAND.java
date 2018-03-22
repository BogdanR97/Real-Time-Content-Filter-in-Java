//package stocksFeed;

public class LogicalAND extends NodeOperation implements Operation {
	public boolean accept(OperationVisitor operationVisitor){
		return operationVisitor.visit(this);
	}
	
	public LogicalAND(Operation left, Operation right){
		super(left, right);
	}
}
