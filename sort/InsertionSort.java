package org.example.sort;

public class InsertionSort {


    public static void insertionSort(int[] arr){
        long before = System.currentTimeMillis();
        for(int i=1;i<arr.length;i++){

            int target = arr[i];
            int idx = i-1;
            while(idx>=0&&target<arr[idx]){
                arr[idx+1] = arr[idx--];
            }
            arr[idx+1] = target;
        }
        long after = System.currentTimeMillis();
        long dif = (after-before);
        System.out.println("걸린 시간 : " + dif);
    }


}
