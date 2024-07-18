/*
    ref:- https://www.javatpoint.com/proxy-pattern
    if we need to do some auth check before calling actual object then we can create a proxy of it
 */
package org.learnings.designPatterns.ProxyDesignPattern;

public class MainClass {
    public static void main(String[] args) {
        /*
            First object of proxy will be created, and internally it checks the validation and then call the real object method
         */
        Subject subject = new ProxySubject();
        subject.foo();
    }
}
