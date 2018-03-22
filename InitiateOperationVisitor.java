//package stocksFeed;

/**
 * Clasa ce ajuta la implementarea Visitor Design Pattern;
 * Aceasta reprezinta clasa concreta a vizitatorului;
 * @author bogdan
 *
 */
public class InitiateOperationVisitor implements OperationVisitor {
	
	
	public boolean visit(Nil nil){
		return true;
	}
	
	public boolean visit(Equal eq){
		
		if(eq.getRight() instanceof ValueNode){
			if( ((ValueNode)eq.getLeft()).getValue() ==((ValueNode)eq.getRight()).getValue() )
				return true;
			else
				return false;
		}
		
		else{
			
			if( ((NameNode)eq.getLeft()).getName().equals( ((NameNode)eq.getRight()).getName() ) )
				return true;
			else
				return false;
		}
			
	}
	
	public boolean visit(NotEqual ne){
	
		if(ne.getRight() instanceof ValueNode){
			if( ((ValueNode)ne.getLeft()).getValue() != ((ValueNode)ne.getRight()).getValue() )
				return true;
			else
				return false;
		}
		
		else{
			
			if(! ( ((NameNode)ne.getLeft()).getName().equals( ((NameNode)ne.getRight()).getName() ) ) )
				return true;
			else
				return false;
		}
	}
	
	public boolean visit(Greater gt){
		
		if( visit((ValueNode)gt.getLeft()) >  visit((ValueNode)gt.getRight()) )
			return true;
		else
			return false;
	}
	
	public boolean visit(GreaterEqual ge){
		
		if( ((ValueNode)ge.getLeft()).getValue() >=  ((ValueNode)ge.getRight()).getValue() )
			return true;
		else
			return false;
	}
	
	public boolean visit(Lower lt){
		
		if( ((ValueNode)lt.getLeft()).getValue() <  ((ValueNode)lt.getRight()).getValue() )
			return true;
		else
			return false;
	}
	
	public boolean visit(LowerEqual le){
		
		if( ((ValueNode)le.getLeft()).getValue() <=  ((ValueNode)le.getRight()).getValue() )
			return true;
		else
			return false;
	}
	
	public boolean visit(LogicalAND loa){
	
		return loa.getLeft().accept(this) && loa.getRight().accept(this);
	}
	
	public boolean visit(LogicalOR lor){
		
		return lor.getLeft().accept(this) || lor.getRight().accept(this);
	}
	
	public double visit(ValueNode vn){
		
		return vn.getValue();
	}
	
	public String visit(NameNode nn){
		
		return nn.getName();
	}
}
