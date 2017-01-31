package command;

public class Programa {
	public static void main(String[] args) {
		Pedido pedido1 = new Pedido("Zezão", 150);
		Pedido pedido2 = new Pedido("Asdrebilde", 550);
		
		FilaDeTrabalho fila = new FilaDeTrabalho();
		
		fila.adiciona(new PagaPedido(pedido1));
		fila.adiciona(new PagaPedido(pedido2));
		fila.adiciona(new ConcluiPedido(pedido1));
		
		fila.processa();
		
		System.out.println(pedido1.getStatus());
		System.out.println(pedido2.getStatus());
	}
}
