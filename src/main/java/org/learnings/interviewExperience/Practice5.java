package org.learnings.interviewExperience;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Practice5 {

    private static final Logger log = LogManager.getLogger(Practice5.class);

    public static void main(String[] args) {
        // let promise = new Promise((resolve,reject)=>{
        //            resolve("resolved with some value")
        // })
        // promise.then(function(value){console.log(value)})
        var promise = new Promise<String, Resolve<String, String>, Reject>() {
            @Override public void executorFunction(Resolve<String, String> resolve, Reject reject) {
                //resolve("resolved with some value");
                var resolved = new Resolve<String, String>() {
                    @Override public String resolve(String result) {
                        return "resolving with " + result;
                    }
                };
            }
        };

    }

    @FunctionalInterface
    interface Promise<Result, Resolve, Reject> {

        void executorFunction(Resolve resolve, Reject reject);
    }

    @FunctionalInterface
    interface Resolve<T, R> {

        R resolve(T input);
    }

    @FunctionalInterface
    interface Reject {

        void reject(Integer integer);
    }
}

