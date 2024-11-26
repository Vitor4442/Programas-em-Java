public class NodeC{
	private char x;
	private NodeC prox;
	
	public NodeC(char valor){
		x = valor;
		prox = null;
	}
	
	public void setX(char valor){
		x = valor;
	}
	
	public char getX(){
		return x;
	}
	
	public void setProx(NodeC p){
		prox = p;
	}
	
	public NodeC getProx(){
		return prox;
	}
}