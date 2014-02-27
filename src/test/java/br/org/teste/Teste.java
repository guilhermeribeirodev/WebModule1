package br.org.teste;

import org.testng.annotations.Test;

import javax.naming.Context;
import javax.naming.NamingException;

/**
 * Created with IntelliJ IDEA.
 * User: guilherme
 * Date: 2/27/14
 * Time: 1:30 AM
 * To change this template use File | Settings | File Templates.
 */
public class Teste {


    @Test
    public void testa(){
        HelloWorldBean bean = null;
        try {
            bean = doLookup();
        } catch (NamingException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        System.out.println(bean.sayHello()); // 4. Call business logic
    }

    private static HelloWorldBean doLookup() throws NamingException {
        Context context = null;
        HelloWorldBean bean = null;
        try {
            // 1. Obtaining Context
            context = ClientUtility.getInitialContext();
            // 2. Generate JNDI Lookup name
            String lookupName = getLookupName();
            // 3. Lookup and cast
            bean = (HelloWorldBean) context.lookup(lookupName);

        } catch (NamingException e) {
            e.printStackTrace();
        }
        return bean;
    }

    private static String getLookupName() {
/*
The app name is the EAR name of the deployed EJB without .ear suffix.
Since we haven't deployed the application as a .ear,
the app name for us will be an empty string
*/
        String appName = "";

        /* The module name is the JAR name of the deployed EJB
        without the .jar suffix.
        */
        String moduleName = "HelloWorldSessionBean";

/*AS7 allows each deployment to have an (optional) distinct name.
This can be an empty string if distinct name is not specified.
*/
        String distinctName = "";

        // The EJB bean implementation class name
        String beanName = HelloWorldBean.class.getSimpleName();

        // Fully qualified remote interface name
        final String interfaceName = HelloWorldBean.class.getName();

        // Create a look up string name
        String name = "ejb:" + appName + "/" + moduleName + "/" +
                distinctName    + "/" + beanName + "!" + interfaceName;

        return name;
    }
}
