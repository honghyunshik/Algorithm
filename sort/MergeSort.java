package org.example.sort;

import java.util.Arrays;

public class MergeSort {


    static int[] sorted;
    public static void mergeSort(int[] arr){

        int size = arr.length;
        sorted = new int[size];
        long before = System.currentTimeMillis();
        mergeSort(arr,0,size-1);
        sorted = null;  //메모리 해제
        long after = System.currentTimeMillis();
        long dif = (after-before);
        System.out.println("Merge Sort : " + dif);
    }

    public static void mergeSort(int[] arr, int l, int r){

        if(l==r) return;
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
