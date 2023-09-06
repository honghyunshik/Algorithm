package org.example.sort;

public class SelectionSort_advanced {

    public static void selectionSort_advanced(int[] arr){

        long before = System.currentTimeMillis();

        for(int i=0;i<arr.length/2;i++){

            int minIdx = i;
            int maxIdx = arr.length-1-i;
            for(int j=i+1;j<arr.length-1-i;j++){
                if(arr[minIdx]>arr[j]){
                    minIdx = j;
                }
                if(arr[maxIdx]<arr[j]){
                    maxIdx = j;
                }
            }
            Main.swap(arr,i,minIdx);
            Main.swap(arr,arr.length-1-i,maxIdx);
        }

        long after = System.currentTimeMillis();
        long dif = (after-before);
        System.out.println("Selection Sort 개선 : " + dif);
    }
}
