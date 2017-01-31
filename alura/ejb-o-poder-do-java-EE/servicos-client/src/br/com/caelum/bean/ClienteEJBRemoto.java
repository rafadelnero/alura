package br.com.caelum.bean;

import javax.naming.NamingException;

public class ClienteEJBRemoto {
	public static void main(String[] args) throws NamingException {

		/////////////////////////////////////////////////////////////////////////////////////
		// (Tentativa_1)
		// Tentei sem sucesso essas configurações de propriedade
		// Recebia: java.lang.IllegalStateException...No EJB receiver available
		///////////////////////////////////////////////////////////////////////////////////// for
		///////////////////////////////////////////////////////////////////////////////////// handling
		// Deixei aqui como informação, talvez funcione no caso de vcs.
		// ==============================================================
		// ===== Propriedades - poderiam estar em jndi.properties

		/*
		 * final Properties jndiProperties = new Properties();
		 * jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY,
		 * "org.jboss.naming.remote.client.InitialContextFactory");
		 * jndiProperties.put(Context.URL_PKG_PREFIXES,
		 * "org.jboss.ejb.client.naming");
		 * jndiProperties.put(Context.PROVIDER_URL,
		 * "ttp-remoting:localhost:8080"); // 8080 default wildfly
		 * 
		 * // Passando credenciais - Application User
		 * jndiProperties.put(Context.SECURITY_PRINCIPAL, "eder"); // username
		 * jndiProperties.put(Context.SECURITY_CREDENTIALS, "@eder1"); //
		 * password
		 * 
		 * // EJBReceiver (jboss-remoting project) é criado usando a mesma
		 * conexao remota // Se for pela EJB client API terá de configurar
		 * jboss-ejb-client.properties ou prog.na unha
		 * jndiProperties.put("jboss.naming.client.ejb.context", true);
		 * jndiProperties.put("org.jboss.ejb.client.scoped.context", "true");
		 * 
		 * // Cria o contexto passando essas propriedades Context jndi = new
		 * InitialContext(jndiProperties);
		 * 
		 */

		// =========================================================
		// ===== Montando jndiName

		// nome do file.ear sem sufixo.ear('file') ou app_name in
		// application.xml
		// se nao tiver .ear deixar vazio
		String appName = "";

		// nome do .jar ou .war (-sufixo) ou module-name in web.xml/ejb-jar.xml
		String moduleName = "dado";

		String distinctName = "";

		// Nome da classe do bean ou apelido<(@Stateless(name="apelido")> ou
		// ainda ejb-jar.xml
		String beanName = "LancadorDadosBean";

		// Interface fully qualified
		String interfaceFullName = "br.com.eder.sessionbean.LancadorDados";

		// ejb:{app-Name}/{module-Name}/{distinct-Name}/{bean-Name}!{fullPath-remote-Interface}

		// Meu
		// caso:ejb:/dado//LancadorDadosBean!br.com.eder.sessionbean.LancadorDados
		String jndiName = "ejb:/servicos-ejb-remote/ServicoBean!br.com.caelum.bean.Servico";

		// IMPORTANTE:
		// |=> No deploy, o objBeam deve aparecer em
		// "java:jboss/exported/namespaceJNDI"
		// |=> O objBean tem de ser serializable
		// Tentativa_1(fail): setando propriedades
		// LancadorDados lancadorDados = (LancadorDados) jndi.lookup(jndiName);

		// Tentativa2(ok) - Usando a classe auxiliar que cria o EJBReceiver
		Servico servico = EJBLocator.locateEJB(jndiName);
		
//		InitialContext ctx = new InitialContext();
//		Servico servico = (Servico) ctx.lookup("ejb:/Servicos/ServicoBean!br.com.caelum.bean.Servico");

		servico.executa();
	}
}
