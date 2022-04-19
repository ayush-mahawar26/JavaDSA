package Arrays.Algorithm.Sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        
        // Put the element at ith position to its correct position to its left hand side
        // time complexity - O(N^2) 

        int[] arr = {1,-50,4,2,3,-6,9} ;
        int n = arr.length ;

        for(int i = 0 ; i < n-1 ; i++){
            for(int j = i+1 ; j > 0  ;j--){
                if(arr[j] < arr[j-1]){
                    int temp = arr[j] ; 
                    arr[j] = arr[j-1] ;
                    arr[j-1] = temp ;
                }else{
                    break ;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
