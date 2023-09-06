package org.example.sort;

import java.util.Arrays;

public class QuickSort {


    public static void quickSort(int[] arr){
        long before = System.currentTimeMillis();
        l_quickSort(arr,0,arr.length-1);
        long after = System.currentTimeMillis();
        long dif = (after-before);
        System.out.println("Quick Sort : " + dif);
    }


    public static void l_quickSort(int[] arr, int l, int r){

        if(l>=r) return;
        int pivot = partition(arr,l,r);
        l_quickSort(arr,l,pivot-1);
        l_quickSort(arr,pivot+1,r);
    }

    //가장 왼쪽 원소를 피벗으로 선정함
    public static int partition(int[] arr, int l, int r){

        int left = l;
        int right = r;
        int pivot = arr[l];

        while(left<right){

            while(arr[right]>pivot){
                right--;
            }
            while(left<right&&arr[left]<=pivot){
                left++;
            }
            Main.swap(arr,left,right);
        }
        Main.swap(arr,l,left);
        return left;
    }
}
