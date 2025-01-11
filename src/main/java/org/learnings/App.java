package org.learnings;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class App {

    public boolean isPalindrome(int x) {
        StringBuilder temp = new StringBuilder();
        String input = String.valueOf(x);
        while(input.length() > 0 ){
            int rem = x%10;
            temp.append(rem);
            x = x/10;
            input = String.valueOf(x).toString();
        }
        return temp.toString().equals(Integer.toString(x));
    }

    private static final Logger logger = LogManager.getLogger(App.class);
    public static void main(String[] args) {
        logger.info("Hello World!");
        App app = new App();
        logger.log(Level.INFO,app.isPalindrome(121));
    }
}
