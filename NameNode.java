//package stocksFeed;

public class NameNode implements Operation {
	
	private String name;
	
	public NameNode(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public boolean accept(OperationVisitor opVisitor){
		opVisitor.visit(this);
		return true;
	}
}
