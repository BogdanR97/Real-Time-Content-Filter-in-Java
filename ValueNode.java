//package stocksFeed;

public class ValueNode implements Operation {
	
	private double value;
	
	public ValueNode(double value){
		this.value = value;
	}
	
	public double getValue(){
		return value;
	}
	
	public boolean accept(OperationVisitor opVisitor){
		opVisitor.visit(this);
		return true;
	}

}
