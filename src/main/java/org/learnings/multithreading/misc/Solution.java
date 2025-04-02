/* 
Question
You are designing a service that needs to communicate with an external API, which occasionally fails due to transient network issues. Describe how you would implement a retry mechanism, to handle these failures.
Followup, explain when you would use a circuit breaker instead of a retry mechanism, and discuss the scenario of implementing both of them together. 
*/
package org.learnings.multithreading.misc;

public class Solution {

    private static final Integer MAX_RETRY_LIMIT = 3;

    public static void main(String[] args) {
        DemoTaskService demoTaskService = new DemoTaskService();
        int currentRetryTimes = 0;
        while (currentRetryTimes < MAX_RETRY_LIMIT) {
            try {
                demoTaskService.performTask();
                return;
            } catch (Exception e) {
                System.out.println(e);
                currentRetryTimes++;
                try {
                    Thread.sleep(6000);
                    if (currentRetryTimes >= MAX_RETRY_LIMIT) {
                        System.out.println("Seems like the DemoTaskService unable to fetch the result at this time");
                    }
                } catch (InterruptedException exception) {
                    throw new RuntimeException("Thread is intrupted in between", exception);
                }
            }
        }
    }
}

class DemoTaskService {
    public void performTask() throws Exception {
        if (Math.random() > 0.5) {
            System.out.println("Able to make Downstream call and fetched the result");
        } else {
            throw new Exception("Unable to call downstream service");
        }
    }
}