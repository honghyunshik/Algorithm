package org.example.sort;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args){

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

        for(int i=0;i<100001;i++){

            bubble_arr[i] = new Random().nextInt(100000000);
            bubble_arr_advanced[i] = bubble_arr[i];
            selection_arr[i] = bubble_arr[i];
            selection_arr_advanced[i] = bubble_arr[i];
            insertion_arr[i] = bubble_arr[i];
            insertion_arr_advanced[i] = bubble_arr[i];
            heap_arr[i] = bubble_arr[i];
            merge_arr[i] = bubble_arr[i];
            merge_arr_advanced[i] = bubble_arr[i];
            quick_arr[i] = bubble_arr[i];
            quick_arr_advanced[i] = bubble_arr[i];
        }



        BubbleSort.bubbleSort(bubble_arr);
        BubbleSort_advanced.bubbleSort_advanced(bubble_arr_advanced);
        SelectionSort.selectionSort(selection_arr);
        SelectionSort_advanced.selectionSort_advanced(selection_arr_advanced);
        InsertionSort.insertionSort(insertion_arr);
        InsertionSort_advanced.insertionSort(insertion_arr_advanced);
        HeapSort.heapSort(heap_arr);
        MergeSort.mergeSort(merge_arr);
        MergeSort_advanced.mergeSort(merge_arr_advanced);
        QuickSort.quickSort(quick_arr);


    }

    public static void swap(int[] arr, int l, int r){

        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }


}
