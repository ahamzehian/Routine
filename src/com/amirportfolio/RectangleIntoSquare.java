package com.amirportfolio;

import java.util.*;

public class RectangleIntoSquare {

    public static void main(String[] args) {

//        new RectangleIntoSquare().testRun();
        if(args.length%2==0){
            for(int i=0;i< args.length;i+=2){
                getSquares(getInt(args[i]),getInt(args[i+1]));
            }
        }else{
            System.out.println("Missing one input");
        }

    }

    /**
     * The method will try to find the list of squares that fit inside a rectangle.
     * example: rectangle with length of 5 and width of 3 has a 3x3 then a 2x2 then two 1x1
     * we are expecting the following array [3,2,1,1]
     * @param length int length
     * @param width int width
     * @return int[] result
     */
    public static int[] getSquares(int length, int width){
        List<Integer> sqrs = new ArrayList<>();
        if(length%width==0){
            sqrs.add(width);
        }else{
            while(width>= 1){
                int cup = Math.max(length - width, width);
                sqrs.add(width);
                width = Math.min(length - width, width);
                length = cup;
            }
        }
        int[] result = new int[sqrs.size()];
        for(int i=0;i<sqrs.size();i++){
            result[i] = sqrs.get(i);
        }
        return result;
    }

    // Check if any modification on the method is matching with what is expected
    public void testRun(){
        Map<int[], int[]> tests = new HashMap<>(Map.of(new int[]{2,1},new int[]{1},
                new int[]{5,3},new int[]{3,2,1,1},new int[]{10,5},new int[]{5},
                new int[]{9,2},new int[]{2,2,2,2,1,1}));
        for(int[] i: tests.keySet()){
            System.out.println("input: " + Arrays.toString(i) + " | expected: " +
                    Arrays.toString(tests.get(i)) + " | method result: " +
                    Arrays.toString(getSquares(i[0],i[1])) + " | " +
                    Arrays.equals(tests.get(i),getSquares(i[0],i[1])));
        }
    }

    // Convert string to integer.
    private static int getInt(String num){
        int out = Integer.MIN_VALUE;
        try{
            out = Integer.parseInt(num);
        }catch(NumberFormatException nfe){
            throw new IllegalArgumentException(num + " cannot convert to integer.");
        }
        return out;
    }

}
