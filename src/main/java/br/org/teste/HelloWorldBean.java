package br.org.teste;

import javax.ejb.Stateless;


/**
 * Created with IntelliJ IDEA.
 * User: guilherme
 * Date: 2/27/14
 * Time: 12:59 AM
 * To change this template use File | Settings | File Templates.
 */
@Stateless
public class HelloWorldBean
{
    public HelloWorldBean() {
    }

    public String sayHello() {
        return "Hello World !!!";
    }

}
