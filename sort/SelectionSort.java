package org.example.sort;

public class SelectionSort {

    public static void selectionSort(int[] arr){

        long before = System.currentTimeMillis();

        for(int i=0;i<arr.length-1;i++){

            int minIdx = i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[minIdx]>arr[j]){
                    minIdx = j;
                }
            }
            Main.swap(arr,i,minIdx);
        }

        long after = System.currentTimeMillis();
        long dif = (after-before);
        System.out.println("걸린 시간 : " + dif);
    }
}
