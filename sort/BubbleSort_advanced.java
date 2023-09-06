package org.example.sort;

public class BubbleSort_advanced {

    public static void bubbleSort_advanced(int[] arr){

        long before = System.currentTimeMillis();

        for(int i=0;i<arr.length-1;i++){

            boolean flag = false;
            for(int j=1;j<arr.length-i;j++){

                if(arr[j-1]>arr[j]) {
                    flag = true;
                    Main.swap(arr, j - 1, j);
                }
            }
            if(!flag) break;
        }

        long after = System.currentTimeMillis();
        long dif = (after-before);
        System.out.println("걸린 시간 : " + dif);
    }
}
