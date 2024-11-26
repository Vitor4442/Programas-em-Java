public class FilaC{
	private NodeC inicio, fim;
	
	public FilaC(){
		inicio = fim = null;
	}
	
	public void push(char valor){
		NodeC novoFim = new NodeC(valor);
		if(inicio!=null){
			fim.setProx(novoFim);
			fim = novoFim;
		}
		else{
			inicio = fim = novoFim;
		}
	}
	
	public char pop(){
		NodeC velhoInicio = inicio;
		inicio = inicio.getProx();
		return velhoInicio.getX();
	}
	
	public boolean isEmpty(){
		return (inicio == null);
	}
}