public class PilhaC{
	private NodeC topo;
	
	public PilhaC(){
		topo = null;
	}
	
	public void push(char valor){
		NodeC novoTopo = new NodeC(valor);
		novoTopo.setProx(topo);
		topo = novoTopo;
	}
	
	public char pop(){
		NodeC velhoTopo = topo;
		topo = topo.getProx();
		return velhoTopo.getX();	
	}
	
	public boolean isEmpty(){
		return (topo == null);
	}
}