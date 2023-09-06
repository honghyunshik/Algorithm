package org.example.sort;

public class BubbleSort {

    public static void bubbleSort(int[] arr){

        long before = System.currentTimeMillis();

        for(int i=0;i<arr.length-1;i++){

            for(int j=1;j<arr.length-i;j++){

                if(arr[j-1]>arr[j]) {

                    Main.swap(arr, j - 1, j);
                }
            }
        }

        long after = System.currentTimeMillis();
        long dif = (after-before);
        System.out.println("Bubble Sort : " + dif);

    }
}
