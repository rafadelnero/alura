package br.caelum.jms.consumidor;

import java.util.Scanner;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.naming.InitialContext;

import br.caelum.jms.modelo.Pedido;

public class TesteConsumidorTopicoDeObjeto {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		System.setProperty("org.apache.activemq.SERIALIZABLE_PACKAGES", "*");

		InitialContext context = new InitialContext();

		ConnectionFactory connectionFactory = (ConnectionFactory) context.lookup("ConnectionFactory");

		Connection conexao = connectionFactory.createConnection();

		conexao.start();

		Session session = conexao.createSession(false, Session.AUTO_ACKNOWLEDGE);

		Destination topico = (Destination) context.lookup("loja");

		MessageConsumer consumer = session.createConsumer(topico);

		// Receber várias mensagens do tópico
		consumer.setMessageListener(new MessageListener() {

			@Override
			public void onMessage(Message message) {
				ObjectMessage objectMessage = (ObjectMessage) message;
				Pedido pedido;
				try {
					pedido = (Pedido) objectMessage.getObject();
					System.out.println(pedido.getItens());
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		});

		new Scanner(System.in).nextLine();

		session.close();

		conexao.close();
		context.close();
	}
}
