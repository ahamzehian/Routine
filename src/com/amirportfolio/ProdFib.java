package com.amirportfolio;

import java.util.*;

public class ProdFib {

    public static void main(String[] args) {

        for(String s:args){
            System.out.println("result: " + Arrays.toString(fibMulti4(convert(s))));
        }

    }

    // Convert input to integer
    private static int convert(String num){
        int out = Integer.MIN_VALUE;
        try{
            out = Integer.parseInt(num);
        }catch(NumberFormatException nfe){
            throw new IllegalArgumentException(num + " cannot convert to integer.");
        }
        return out;
    }

    /**
     * The method produce an array with size of 3 with three integer. The method will check if a number is
     * a result of multiplying two consecutive fibonacci numbers or no? If they are then you see first two
     * numbers and 1 at the end as true result.
     * If the condition does not match then it considers biggest closest result and shows those two numbers
     * with a 0 in the end to represent false.
     * example: 104 = 8*13 result:[8,13,1]
     *          8*13 < 105 < 13*21 result:[13,21,0]
     * @param input int input
     * @return new int[3]    int[2] = 0|1
     */
    private static int[] fibMulti4(int input){
        int num1 = 1;
        int num2 = 1;
        int j;
        int m = 1;
        while(input>m){
            m=num1*num2;
            j = num1+num2;
            int cup = num1;
            num1 = j;
            num2 = cup;
        }
        return new int[]{num1-num2!=0?num1-num2:1,num2,m==input?1:0};
    }

    // A test run to check modification on the method is working as expected.
    public void testRun(){
        Map<Integer,int[]> tests = new HashMap<>(Map.of(1,new int[]{1,1,1},2,new int[]{1,2,1}
        ,104,new int[]{8,13,1},20,new int[]{5,8,0},36,new int[]{5,8,0}));
        for(int i:tests.keySet()){
            int[] fib = fibMulti4(i);
            System.out.printf("input = %d | expected: %s | produced: %s | %b\n",
                    i, Arrays.toString(tests.get(i)), Arrays.toString(fib),
                    Arrays.equals(tests.get(i), fib));
        }
    }
}
