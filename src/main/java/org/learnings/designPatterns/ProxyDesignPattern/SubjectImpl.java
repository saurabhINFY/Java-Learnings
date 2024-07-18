package org.learnings.designPatterns.ProxyDesignPattern;

/**
 * The real object which implementing subject
 */
abstract public class SubjectImpl implements Subject{
    @Override
    public void foo() {
        System.out.println("foo is called");
    }
}
