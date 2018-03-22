//package stocksFeed;
import java.util.*;

/**
 * Clasa contine metodele necesare construirii unui arbore de expresie,
 * stocarea acestuia intr-un atribut si intoarcerea valorii de adevar
 * in urma evaluarii acestuia prin Visitor Design Pattern;
 * @author bogdan
 *
 */
public class ExpressionTree {
	
	private NodeOperation root;
	
    /**
     * @param tokens elementele necesare construirii arborelui de expresie, stocate intr-un vector de Stringuri
     * sub forma de tokenuri;
     * @param stockName numele stockului;
     * @param stockValue valoarea stockului;
     */
    public ExpressionTree(String[] tokens, String stockName, String stockValue){
        root = BuildTheTree(tokens, stockName, stockValue);
    }
    
    /**
     * @return valoarea de adevar a arborelui de expresie (stockul respectiv trece/nu trece de filtru)
     * in urma evaluarii acestuia cu ajutorul Visitor Design Pattern; 
     */
    public boolean FilterFeed(){
    	InitiateOperationVisitor visitor = new InitiateOperationVisitor();
    	return ((Operation)root).accept(visitor); 
    }
    
    /**
     * Aceasta metoda implementeaza crearea unui arbore de expresie conform algoritmului Shunting-Yard,
     * adaptat pentru operatorii specificati;
     * @param tokens elementele necesare construirii arborelui de expresie, stocate intr-un vector de Stringuri
     * sub forma de tokenuri;
     * @param stockName numele stockului;
     * @param stockValue valoarea stockului;
     * @return arborele de expresie;
     */
    private NodeOperation BuildTheTree(String[] tokens, String stockName, String stockValue){
    	
    	Stack<String> operators = new Stack<String>();
    	Stack<Operation> opNodes = new Stack<Operation>();
    	OperationFactory opFactory = OperationFactory.getFactory();
    	
    	if(tokens[0].equals("nil")){
    		return (NodeOperation)opFactory.getOperation("nil", null, null);
    	}
    	
    	for(int i = 0; i<tokens.length; i++){
    		
    		if(tokens[i].equals("(") && !(tokens[i+1].matches("eq|ne|gt|ge|lt|le")))
    			operators.push(tokens[i]);
    		
    		else if(tokens[i].matches("eq|ne|gt|ge|lt|le")){
    			
    			Operation leftLeaf;
    			
    			if(tokens[i+1].equals("name"))
    				leftLeaf = opFactory.getOperation(stockName, null, null);
    			else
    				leftLeaf = opFactory.getOperation(stockValue, null, null);
    				
    			Operation rightLeaf = opFactory.getOperation(tokens[i+2], null, null);	
    			Operation op = opFactory.getOperation(tokens[i], leftLeaf, rightLeaf);
    			opNodes.push(op);
    			
    			i+=3;
    			continue;
    		}
    		
    		else if(tokens[i].equals(")")){
    			
    			while(!(operators.peek().equals("("))){
    				
    				Operation rightNode = opNodes.pop();
    				Operation leftNode = opNodes.pop();
    				Operation op = opFactory.getOperation(operators.pop(), leftNode, rightNode);
    				opNodes.push(op);
    			}
    			operators.pop();
    		}
    		
    		else if(tokens[i].matches("&&|\\|\\|")){
    			
    			if(operators.empty())
    				operators.push(tokens[i]);
    			
    			else{
    			
    				while( operators.peek().matches("&&|\\|\\|") ){
    				
	    				Operation rightNode = opNodes.pop();
	    				Operation leftNode = opNodes.pop();
	    				Operation op = opFactory.getOperation(operators.pop(), leftNode, rightNode);
	    				opNodes.push(op);
    				}
    				operators.push(tokens[i]);
    			}
    		}
    	}
    	
    	while(!(operators.empty())){
    		
    		Operation rightNode = opNodes.pop();
			Operation leftNode = opNodes.pop();
			Operation op = opFactory.getOperation(operators.pop(), leftNode, rightNode);
			opNodes.push(op);
    	}
    
    	return (NodeOperation)opNodes.pop();
    }
}
