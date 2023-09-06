package org.example.sort;

public class InsertionSort_advanced {

    public static void insertionSort(int[] arr){
        long before = System.currentTimeMillis();
        for(int i=1;i<arr.length;i++){

            int target = arr[i];
            int idx = binarySearch(arr,i);
            for(int j=i;j>idx;j--){
                arr[j] = arr[j-1];
            }
            arr[idx] = target;
        }
        long after = System.currentTimeMillis();
        long dif = (after-before);
        System.out.println("Insertion Sort 개선 : " + dif);
    }

    //upper bound 사용
    public static int binarySearch(int[] arr, int idx){

        int l = 0, r = idx;
        int target = arr[idx];
        while(l<r){

            int mid = (l+r)/2;
            if(arr[mid]<=target){
                l = mid+1;
            }else r = mid;
        }
        return r;
    }
}
