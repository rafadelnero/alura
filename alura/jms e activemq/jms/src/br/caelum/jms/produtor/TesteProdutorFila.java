package br.caelum.jms.produtor;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.naming.InitialContext;

public class TesteProdutorFila {
	public static void main(String[] args) throws Exception {
		InitialContext context = new InitialContext();
		
		ConnectionFactory connectionFactory = (ConnectionFactory) context.lookup("ConnectionFactory");
		
		Connection conexao = connectionFactory.createConnection();
		
		conexao.start();
		
		Session session = conexao.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination fila = (Destination) context.lookup("financeiro");
		
		MessageProducer producer = session.createProducer(fila);
		
		for (int i = 0; i < 1000; i++) {
			Message message = session.createTextMessage("<pedido><id>"+ i + "</id><pedido>");
			producer.send(message);
		}
		
		session.close();
		
		conexao.close();
		context.close();
	}
}
