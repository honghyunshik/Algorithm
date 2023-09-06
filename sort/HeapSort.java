package org.example.sort;

import java.util.Arrays;

public class HeapSort {


    public static void heapSort(int[] arr){
        long before = System.currentTimeMillis();
        int size = arr.length;
        if(size<2) return;

        int parentIdx = getParent(size-1);
        for(int i=parentIdx;i>=0;i--){
            heapify(arr,i,size);
        }

        for(int i=size-1;i>=0;i--){
            Main.swap(arr,0,i);
            heapify(arr,0,i);
        }
        long after = System.currentTimeMillis();
        long dif = (after-before);
        System.out.println("Heap Sort : " + dif);

    }
    public static int getParent(int child){ return (child-1)/2;}

    public static void heapify(int[] arr, int parentIdx, int lastIdx){

        //index가 0부터 시작이므로
        int leftChildIdx = parentIdx*2 + 1;
        int rightChildIdx = parentIdx*2 + 2;
        int largestIdx = parentIdx;

        //IndexOutOfRange 방지
        if(leftChildIdx<lastIdx&&arr[largestIdx]<arr[leftChildIdx]){
            largestIdx = leftChildIdx;
        }

        if(rightChildIdx<lastIdx&&arr[largestIdx]<arr[rightChildIdx]){
            largestIdx = rightChildIdx;
        }

        //교환이 일어났나?
        if(largestIdx!=parentIdx){
            Main.swap(arr,largestIdx,parentIdx);
            //자식 Node들에 대해 heapify 재귀적 진행
            heapify(arr,largestIdx,lastIdx);
        }
    }


}
