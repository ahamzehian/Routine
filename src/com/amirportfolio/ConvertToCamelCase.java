package com.amirportfolio;

import java.util.HashMap;
import java.util.Map;

public class ConvertToCamelCase {

    public static void main(String[] args) {

        for(String s:args){
            if(!checkInput(s)){
                System.out.println(s);
            }else{
                System.out.println(toCamelCase(s));
            }
        }

    }

    /**
     * Convert a text with '-' or '_' to camel case text.
     * Example: This-is-a-test   changes to:  ThisIsATest
     */
    private static String toCamelCase(String s){
        if(!s.isEmpty() && checkInput(s)){
            String[] words = s.split("-|\\_");
            StringBuilder result = new StringBuilder(words[0]);
            // For every word checks to see if the first character is an alphabet
            for(int i=1;i<words.length;i++){
                if(!words[i].isEmpty() && Character.getNumericValue(words[i].charAt(0))>=10 &&
                        Character.getNumericValue(words[i].charAt(0))<=35)
                    result.append(words[i].substring(0,1).toUpperCase()).append(words[i].substring(1));
                else if(!words[i].isEmpty())
                    result.append(words[i]);
            }
            return result.toString();
        }else{
            return s;
        }
    }

    // Check if there are '-' or '_' or both inside the word
    private static boolean checkInput(String in){
        return in.contains("-") || in.contains("_");
    }

    // A test run to check if the duplicateCount method or any modification on it works as expected
    public void testRun(){
        Map<String, String> samples = new HashMap<>(Map.of("-hello_world", "HelloWorld",
                "test_6n-game", "test6nGame",
                "hello world", "hello world",
                "This is-a_test", "This isATest",
                "--hello____7____world-_-_-", "Hello7World"));

        for(String s:samples.keySet()){
            System.out.println("Input: " + s + " | Method output: " + toCamelCase(s) + " | expected: " +
                    samples.get(s) + " | status: " + (toCamelCase(s).equals(samples.get(s))));
        }
    }

    public String details = "Convert a text with '-' or '_' to camel case text.";

}
