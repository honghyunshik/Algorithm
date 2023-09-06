package org.example.sort;

import java.util.Arrays;

public class MergeSort_advanced {

    static final int INSERTION_SORT_NUM = 8;
    static int[] sorted;

    public static void mergeSort(int[] arr){

        long before = System.currentTimeMillis();
        int size = arr.length;
        sorted = new int[size];
        mergeSort(arr,0,size-1);
        sorted = null;  //메모리 해제
        long after = System.currentTimeMillis();
        long dif = (after-before);
        System.out.println("Merge Sort 개선 : " + dif);
    }

    public static void mergeSort(int[] arr, int l, int r){

        if(r-l<=INSERTION_SORT_NUM){
            InsertionSort.insertionSort(arr,l,r);
            return;
        }
        int mid = (l+r)/2;
        mergeSort(arr,l,mid);
        mergeSort(arr,mid+1,r);
        merge(arr,l,r);
    }

    public static void merge(int[] arr, int l, int r){



        int mid = (l+r)/2;
        int left = l;
        int right = mid+1;
        int idx = l;
        while(left<=mid&&right<=r){

            if(arr[left]<arr[right]){
                sorted[idx++] = arr[left++];
            }else sorted[idx++] = arr[right++];
        }
        while(left<=mid){
            sorted[idx++] = arr[left++];
        }
        while(right<=r){
            sorted[idx++] = arr[right++];
        }

        for(int i=l;i<=r;i++){
            arr[i] = sorted[i];
        }

    }


}
