package com.amirportfolio;

import java.util.HashMap;
import java.util.Map;

public class BracesValidityCheck {
    public static void main(String[] args) {

        for(String s:args){
            if(!isValid(s)){
                System.out.println(s);
            }else{
                System.out.println(s + " braces validity is valid.");
            }
        }

    }

    /**
     * The method will look one character ahead and check with the one before.
     * It also consider the index change of an opening brace and closing brace. For example, if on a correct version,
     * we have a '(' on index 0 then the ')' is on index 1, and if there are something like '[]' then the index of ')'
     * change from 1 to 3. Its formula is as follow: 'i+1+(2*m)'.
     * 'i' is the index of opening brace. 'i+1' is the expected location of closing brace and 'm' is the number of
     * opening braces in between which means there should be '2*m' braces in the middle.
     * example:
     *      index: 0 1 2 3 4 5
     *      chars: ( [ { } ] )
     *      i=0
     *      m=2 which means m*2 = 4
     *      index of ')' is i+1+(2*m) = 0+1+(2*2) = 5
     * @param braces get a text input made only out of braces
     * @return boolean
     */
    private static boolean isValid(String braces){
        boolean result = false;
        for(int i=0;i<braces.length()-1;i++){
            if(braces.charAt(0)!=')' && braces.charAt(0)!='}' && braces.charAt(0)!=']'){  // Check to see if the first character is illegal
                int j = i+1;
                int m = 0;

                // Count for braces between the one we are checking now and its closing one.
                while((braces.charAt(j)=='(' && j!=braces.length()-1) || (braces.charAt(j)=='{' && j!=braces.length()-1) || (braces.charAt(j)=='[' && j!=braces.length()-1)){
                    m++;
                    j++;
                }

                // If there is no closing brace, then there is no need to continue
                if(j==braces.length()-1 && (braces.charAt(j)=='(' || braces.charAt(j)=='{' || braces.charAt(j)=='[')){
                    result = false;
                    break;
                }

                // erase the correct braces from the string and replace it with new string
                if(braces.charAt(i)=='(' && braces.charAt(i+1+(2*m))==')'){
                    if(i+1+(2*m)!=braces.length()-1){
                        braces = braces.substring(i+1,i+1+(2*m)) + braces.substring(i+2+(2*m));
                    }else{
                        braces = braces.substring(i+1,i+1+(2*m));
                    }
                    result = true;
                }else if(braces.charAt(i)=='[' && braces.charAt(i+1+(2*m))==']'){
                    if(i+1+(2*m)!=braces.length()-1){
                        braces = braces.substring(i+1,i+1+(2*m)) + braces.substring(i+2+(2*m));
                    }else{
                        braces = braces.substring(i+1,i+1+(2*m));
                    }
                    result = true;
                }else if(braces.charAt(i)=='{' && braces.charAt(i+1+(2*m))=='}'){
                    if(i+1+(2*m)!=braces.length()-1){
                        braces = braces.substring(i+1,i+1+(2*m)) + braces.substring(i+2+(2*m));
                    }else{
                        braces = braces.substring(i+1,i+1+(2*m));
                    }
                    result = true;
                }
            }else{
                result = false;
            }
        }
        return result;
    }

    // runs a series of input to check if the method is working correctly.
    public void testRun(){

        // Testing units with predetermined answers
        Map<String, Boolean> tests = new HashMap<>(Map.of("()", true, "([{}])", true,
                "([)]", false, "((((", false, "(((()))){{{}}}[[]]([{}])", true,
                "())({}}{()][][", false));

        // Check one by one
        for(String s:tests.keySet()){
            System.out.println(s + ": " + isValid(s) + " | expected: " + tests.get(s));
        }

    }

    public String details = "Check the validity of braces.";

}
