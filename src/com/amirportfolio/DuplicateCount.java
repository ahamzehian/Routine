package com.amirportfolio;

import java.util.HashMap;
import java.util.Map;

public class DuplicateCount {
    public static void main(String[] args) {

        for(String s:args){
            if(!s.isEmpty()){
                System.out.println("There are " + duplicateCount(prepareString(s)) +
                        " characters repeating.");
            }else
                System.out.println("No input!");
        }

    }

    /**
     * Check a text to see how many letters are repeating in a given text.
     * Example: abcd has 0 repeating letters
     * example: aaabbbbcde has 2 repeating letters, 'a' repeated three times, 'b' repeated four times
     * @param text get a String
     * @return int of duplicated character
     */
    private static int duplicateCount(String text){
        int result = 0;
        text = text.toLowerCase();
        for(int i=0;i<text.length()-1;i++){
            for(int j=i+1;j<text.length();j++){
                if(text.substring(j).contains(Character.toString(text.charAt(i)))
                        && text.charAt(i) != '.'){
                    result++;
                    text = text.replaceAll(Character.toString(text.charAt(i)),".");
                }
            }
        }
        return result;
    }

    // The method eliminate spaces between words.
    private static String prepareString(String input){
        input = input.trim();
        String[] words = input.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String s:words)
            sb.append(s);
        return sb.toString();
    }

    // A test run to check if the duplicateCount method or any modification on it works as expected
    public void testRun(){
        Map<String, Integer> samples = new HashMap<>(Map.of("abcd",0,"aabbcde",2,
                "aaabbbcccefggg",4));
        for(String s:samples.keySet()){
            System.out.println(s + ": " + duplicateCount(s) + " | expected: " + samples.get(s) +
                    " | method's function: " + (duplicateCount(s)==samples.get(s)));
        }
    }

    public String details = "Check a text to see how many letters are repeating in a given text.";

}
