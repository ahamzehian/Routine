package com.amirportfolio;

import java.util.*;

public class Premutation {

    // A list of all combinations from given word.
    public static List<String> words = new ArrayList<>();

    public static void main(String[] args) {

        new Premutation().testRun();

        for(String s:args){
            System.out.println(singlePermutations(s).toString());
        }

    }

    private static List<String> singlePermutations(String s){

        words.removeAll(words);
        premutation(s,"");
        return getWords();

    }

    // Return a simple int to show count of all possible outcome
    public static int distribution(int numberOfElements){
        int result = 1;
        while(numberOfElements!=0){
            result*=numberOfElements;
            numberOfElements--;
        }
        return result;
    }

    // Add a String to words
    private static void setWords(String str){
        words.add(str);
    }

    // Return the reference list of words combination
    private static List<String> getWords(){
        return words;
    }

    /**
     * The method use an input string and find all combinations of the characters
     * @param str String str.
     * @param ans one String at a time will be added to the list.
     */
    private static void premutation(String str, String ans){

        if(str.length() == 0){
//            System.out.println(ans + " ");
            setWords(ans);
            return;
        }

        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            String ros = str.substring(0,i) + str.substring(i + 1);
            premutation(ros, ans + c);
        }

    }

    // A test run to check that modified method is matching with what is intended.
    public void testRun(){
        Map<String, List<String>> tests = new HashMap<>(Map.of(
                "abc",List.of("abc","acb","bac","bca","cba","cab"),
                "ab",List.of("ab","ba"),
                "a",List.of("a"),
                "aab",List.of("aab","aba","aab","aba","baa","baa")
        ));

        for(String s:tests.keySet()){
            List<String> check = singlePermutations(s);
            System.out.println(s + " | expected:\n" + tests.get(s).toString() + "\nresult:\n" +
                    check.toString() + "\n" + (tests.get(s).containsAll(check)) +
                    "\n-------------------------\n");
        }
    }

}
