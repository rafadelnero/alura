package br.caelum.jms.produtor;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.naming.InitialContext;

import br.caelum.jms.modelo.Pedido;
import br.caelum.jms.modelo.PedidoFactory;

public class TesteProdutorTopicoDeObjeto {
	public static void main(String[] args) throws Exception {
		InitialContext context = new InitialContext();
		
		ConnectionFactory connectionFactory = (ConnectionFactory) context.lookup("ConnectionFactory");
		
		Connection conexao = connectionFactory.createConnection();
		
		conexao.start();
		
		Session session = conexao.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination fila = (Destination) context.lookup("loja");
		
		Pedido pedido = new PedidoFactory().geraPedidoComValores();
		Message message = session.createObjectMessage(pedido);

		message.setBooleanProperty("ebook", false);
		
		MessageProducer producer = session.createProducer(fila);
		
		producer.send(message);
		
		session.close();
		
		conexao.close();
		context.close();
	}
}
