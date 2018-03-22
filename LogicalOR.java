//package stocksFeed;

public class LogicalOR extends NodeOperation implements Operation {
	
	public boolean accept(OperationVisitor operationVisitor){
		return operationVisitor.visit(this);
	}
	
	public LogicalOR(Operation left, Operation right){
		super(left, right);
	}
}
