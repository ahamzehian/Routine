package com.amirportfolio;

import java.util.*;

public class PickPeaks {

    public static void main(String[] args) {

        new PickPeaks().testRun();

    }

    /**
     * The method will look for largest numbers and their index in an array. It will look for peaks.
     * for example {1,2,3,4,2,1} has following result "pos"=>{3} "peaks"=>{4}
     * in case of {1,2,2,2,1} there is "pos"=>{1} "peaks"=>{2}
     * but {1,2,2,2,2} or {1,2,2,2,3} there is "pos"=>{} "peaks"=>{}
      * @param arr int[] input
     * @return Map<String, List<Integer>>
     */
    private static Map<String, List<Integer>> getPeaks(int[] arr){
        Map<String, List<Integer>> locPeaks = new HashMap<>();
        List<Integer> pos = new ArrayList<>();
        List<Integer> peaks = new ArrayList<>();
        for(int i=1;i< arr.length-1;i++){
            if(arr[i-1]<arr[i]){
                if (arr[i] > arr[i+1]) {
                    pos.add(i);
                    peaks.add(arr[i]);
                }else if(arr[i] == arr[i+1]){
                    int j=i+1;
                    int p = arr[i];
                    while(arr[j]==p && j != arr.length-1){
                        j++;
                    }
                    if(arr[j]<p){
                        pos.add(i);
                        peaks.add(arr[i]);
                    }
                }
            }
        }
        locPeaks.put("pos",pos);
        locPeaks.put("peaks",peaks);
        return locPeaks;
    }

    // An array of arrays to run your method easier for a group.
    private static void check(int[][] arrays){
        for(int[] array:arrays){
            Map<String, List<Integer>> test = getPeaks(array);
            for(String s: test.keySet()){
                System.out.print(s + "=>" + test.get(s).toString() + " | ");
            }
            System.out.println();
        }

    }

    // An automated test to see if your modification is working fine.
    public void testRun(){
        Map<int[],Map<String,List<Integer>>> tests = new HashMap<>(Map.of(
                new int[]{0,1,2,5,1,0}, new HashMap<>(Map.of("pos",new ArrayList<>(List.of(3)),
                        "peaks",new ArrayList<>(List.of(5)))),
                new int[]{3,2,3,6,4,1,2,3,2,1,2,3},
                new HashMap<>(Map.of("pos",new ArrayList<>(List.of(3,7)),
                        "peaks",new ArrayList<>(List.of(6,3)))),
                new int[]{3, 2, 3, 6, 4, 1, 2, 3, 2, 1, 2, 2, 2, 1},
                new HashMap<>(Map.of("pos",new ArrayList<>(List.of(3,7,10)),
                        "peaks",new ArrayList<>(List.of(6,3,2)))),
                new int[]{1,2,2,2,2},
                new HashMap<>(Map.of("pos",new ArrayList<>(List.of()),
                        "peaks",new ArrayList<>(List.of()))),
                new int[]{1,2,2,2,3},
                new HashMap<>(Map.of("pos",new ArrayList<>(List.of()),
                        "peaks",new ArrayList<>(List.of())))
        ));

        for(int[] arr: tests.keySet()){

            Map<String, List<Integer>> testHolder = getPeaks(arr);

            String resultPos = testHolder.get("pos").toString();
            String resultPeaks = testHolder.get("peaks").toString();

            String expectedPos = tests.get(arr).get("pos").toString();
            String expectedPeaks = tests.get(arr).get("peaks").toString();

            System.out.println("Input: " + Arrays.toString(arr) + " | " +
                    "expected: pos" + expectedPos +
                    " peaks" + expectedPeaks + " | " +
                    "result: pos" + resultPos +
                    " peaks" + resultPeaks + " | " +
                    "pos=>" + expectedPos.equals(resultPos) +
                    " peaks=>" + expectedPeaks.equals(resultPeaks)
            );
        }

    }

}
