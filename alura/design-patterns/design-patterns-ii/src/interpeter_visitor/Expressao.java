package interpeter_visitor;

public interface Expressao {
	public int avalia();
	
	public void aceita(Visitor visitor);
}
