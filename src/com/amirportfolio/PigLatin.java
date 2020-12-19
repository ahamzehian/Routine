package com.amirportfolio;

import java.sql.SQLOutput;
import java.util.*;

public class PigLatin {

    public static void main(String[] args) {

        for(String s:args){
            System.out.println(pigIt(s));
        }

    }

    /**
     * The method will take the first character and move it to the end of the word and add "ay" to its end.
     * this process is only supposed to happen on alphabets. It is not supposed to do any thing with special
     * characters or numbers.
     * @param str
     * @return
     */
    private static String pigIt(String str){
        str = str.trim();
        String[] words = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String s:words){
            if(Character.getNumericValue(s.charAt(0))<10 ||
                    Character.getNumericValue(s.charAt(0))>35){
                sb.append(s);
            }else{
                sb.append(s.substring(1)).append(s.charAt(0)).append("ay ");
            }
        }
        return sb.toString().trim();
    }

    private static String pigIt2(String str){
        return str.replaceAll("(\\w)(\\w*)", "$2$1ay");
    }

    // A series of test to check if your modification on the method worked correctly or no.
    public void testRun(){
        Map<String, String> tests = new HashMap<>(Map.of("Test","estTay",
                "Hello World !","elloHay orldWay !", "1234", "1234"
        ,"This is a very long text to test if everything is working fine .",
        "hisTay siay aay eryvay onglay exttay otay esttay fiay verythingeay siay orkingway inefay .",
                "!test","!test","1test","1test"));
        for(String s:tests.keySet()){
            long begin = System.nanoTime();
            System.out.printf("Input: %s | expected: %s | result: %s | %b\n"
            ,s,tests.get(s),pigIt(tests.get(s)), pigIt(s).equals(tests.get(s)));
            long end = System.nanoTime();
            System.out.println("Duration: " + ((end-begin)/1000) + " micro s");
        }
    }

}
