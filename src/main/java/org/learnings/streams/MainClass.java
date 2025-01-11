package org.learnings.streams;

import org.learnings.streams.service.factory.OperationFactory;

class MainClass {
    public static void main(String[] args) {
        OperationFactory.startService("faq");
    }
}
