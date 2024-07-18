package org.learnings.designPatterns.ProxyDesignPattern;

public class ProxySubject extends SubjectImpl {

    @Override public void foo() {
        /* do some check at onInit check like access control if pass then call the super class method
         * if the user is allowed then only we will call the actual method of our real object
         */
        init();
    }

    private void init(){
        super.foo();
    }
}
