package org.example.sort;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args){

        int[] arr = new int[1001];
        int[] bubble_arr = new int[100001];
        int[] bubble_arr_advanced = new int[100001];
        int[] selection_arr = new int[100001];
        int[] selection_arr_advanced = new int[100001];
        int[] insertion_arr = new int[100001];
        int[] insertion_arr_advanced = new int[100001];
        int[] heap_arr = new int[100001];
        int[] merge_arr = new int[100001];
        int[] merge_arr_advanced = new int[100001];
        int[] quick_arr = new int[100001];
        int[] quick_arr_advanced = new int[100001];

        for(int i=0;i<arr.length;i++){

            arr[i] = new Random().nextInt(1000);
        }


        /*
        BubbleSort.bubbleSort(arr);
        BubbleSort_advanced.bubbleSort_advanced(arr);
        SelectionSort.selectionSort(arr);
        SelectionSort_advanced.selectionSort_advanced(arr);
        InsertionSort.insertionSort(arr);
        InsertionSort_advanced.insertionSort(arr);
        HeapSort.heapSort(arr);
         */


        System.out.println(Arrays.toString(arr));

    }

    public static void swap(int[] arr, int l, int r){

        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }


}
