package org.learnings.multithreading.service;

import org.learnings.multithreading.dto.SharedResource;

public class MainClass {

    public static void main(String[] args) {

        SharedResource sharedResource = new SharedResource();

        Thread thread1 = new Thread(sharedResource::produce);

        Thread thread2 = new Thread(sharedResource::consume);
        thread1.start();
        thread2.start();
    }
}
