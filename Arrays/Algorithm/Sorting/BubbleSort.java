package Arrays.Algorithm.Sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        
        // Compare the two adjacent element in array and swap

        int[] arr = {5,4,3,9,6,8,45,1,2} ;

        int n = arr.length ;

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n-1-i ; j++){ 
                // n-1-i , will exclude the checking in sorted part of array 
                if(arr[j] > arr[j+1]){
                    int temp  = arr[j] ; 
                    arr[j] = arr[j+1]; 
                    arr[j+1] = temp ;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
