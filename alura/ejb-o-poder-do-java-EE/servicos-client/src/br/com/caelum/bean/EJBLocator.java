package br.com.caelum.bean;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.jboss.ejb.client.EJBClient;
import org.jboss.ejb.client.EJBClientContext;
import org.jboss.ejb.client.PropertiesBasedEJBClientConfiguration;
import org.jboss.ejb.client.StatelessEJBLocator;
import org.jboss.ejb.client.remoting.ConfigBasedEJBClientContextSelector;

public class EJBLocator {

    @SuppressWarnings("unchecked")
    public static <T> T locateEJB(String jndi) throws NamingException {
        Properties clientProperties = new Properties();
        clientProperties
                .put("remote.connectionprovider.create.options.org.xnio.Options.SSL_ENABLED",
                        "false");
        clientProperties.put("remote.connections", "default");
        clientProperties.put("remote.connection.default.port", "8080");
        clientProperties.put("remote.connection.default.host", "localhost");
        clientProperties.put("remote.connection.default.username", "default");
        clientProperties.put("remote.connection.default.password", "default");
        clientProperties.put(
                "remote.connection.default.connect.options.org.xnio.Options.SASL_POLICY_NOANONYMOUS",
                        "false");

        EJBClientContext.setSelector(new ConfigBasedEJBClientContextSelector(
                new PropertiesBasedEJBClientConfiguration(clientProperties)));

        Properties properties = new Properties();
        properties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        Context context = new InitialContext(properties);
        return (T) context.lookup(jndi);
    }

    public static <T> T locateEJBStateless(Class<T> viewType, String appName,
            String moduleName, String beanName, String distinctName) {
        Properties properties = new Properties();

        properties.put("endpoint.name", "client-endpoint");
        properties
                .put("remote.connectionprovider.create.options.org.xnio.Options.SSL_ENABLED",
                        "false");
        properties.put("remote.connections", "default");
        properties.put("remote.connection.default.port", "8080");
        properties.put("remote.connection.default.host", "localhost");
        properties.put("remote.connection.default.username", "default");
        properties.put("remote.connection.default.password", "default");
        properties
                .put("remote.connection.default.connect.options.org.xnio.Options.SASL_POLICY_NOANONYMOUS",
                        "false");

        EJBClientContext.setSelector(new ConfigBasedEJBClientContextSelector(
                new PropertiesBasedEJBClientConfiguration(properties)));

        StatelessEJBLocator<T> locator = new StatelessEJBLocator<T>(viewType,
                appName, moduleName, beanName, distinctName);
        T ejb = EJBClient.createProxy(locator);

        return ejb;
    }
}