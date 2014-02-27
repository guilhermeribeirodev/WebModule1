package br.org.teste;

/**
 * Created with IntelliJ IDEA.
 * User: guilherme
 * Date: 2/27/14
 * Time: 1:36 AM
 * To change this template use File | Settings | File Templates.
 */
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

public class ClientUtility {

    private static Context initialContext;

    private static final String PKG_INTERFACES = "org.jboss.ejb.client.naming";

    public static Context getInitialContext() throws NamingException {
        if (initialContext == null) {
            Properties properties = new Properties();
            properties.put(Context.URL_PKG_PREFIXES, PKG_INTERFACES);

            initialContext = new InitialContext(properties);
        }
        return initialContext;
    }
}
