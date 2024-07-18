package org.learnings.multithreading.dto;

import java.util.concurrent.locks.StampedLock;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SharedResource {

    private static final Logger log = LogManager.getLogger(SharedResource.class.getName());
    int a = 10;
    StampedLock stampedLock = new StampedLock();

    public void produce() {
        long stamp = stampedLock.tryOptimisticRead();
        try {
            log.info("Taken optimistic lock");
            a = 11;
            Thread.sleep(6000);
            if (stampedLock.validate(stamp)) {
                log.info("Updated the value successfully");
            } else {
                log.warn("Failed to update the value rollback changes");
                a = 10;
            }
        } catch (Exception e) {
            //
        }
    }

    public void consume() {
        long stamp = stampedLock.writeLock();
        log.info("Write lock acquired by {}", Thread.currentThread().getName());
        try {
            log.info("Performing work");
            a = 9;
        } finally {
            stampedLock.unlock(stamp);
            log.info("Write lock released by {}", Thread.currentThread().getName());
        }
    }
}
