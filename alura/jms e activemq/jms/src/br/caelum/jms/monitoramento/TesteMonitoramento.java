package br.caelum.jms.monitoramento;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Queue;
import javax.jms.QueueBrowser;
import javax.jms.Session;
import javax.naming.InitialContext;

public class TesteMonitoramento {
	
	public static void main(String[] args) throws Exception {
		InitialContext context = new InitialContext();
		
		ConnectionFactory connectionFactory = (ConnectionFactory) context.lookup("ConnectionFactory");
		
		Connection conexao = connectionFactory.createConnection();
		
		conexao.start();
		
		Session session = conexao.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination fila = (Destination) context.lookup("financeiro");        
		QueueBrowser browser = session.createBrowser((Queue) fila);
		
		while(browser.getEnumeration().hasMoreElements()) {
			Object message = browser.getEnumeration().nextElement();
			
			System.out.println(message);
		}
		
		System.out.println(browser.getQueue());
		System.out.println(browser.getMessageSelector());
		
		session.close();
		
		conexao.close();
		context.close();
	}
}
