package Arrays.Algorithm;

import java.util.Arrays;

public class Seaching {


    // Find the element in the array (Linear Search - Bruteforce) 
    // Time COmplexity - O(N) 
    static int linearSearch(int[] arr , int target , int n){
        for(int i = 0 ; i < n ; i++){
            if(arr[i]== target){
                return i ; 
            }       
        }

        return -1 ; // Target not exist 
    }


    // Binary Search - O(logN)
    // condition - Array must be sorted 

    static int BinarySearch(int arr[] , int n , int target){
        int s = 0 ; 
        int e = n ;

        while(s <= e){
            int m = s+(e-s)/2 ;

            if(arr[m] == target){
                return m ;
            }else if(arr[m] > target){
                e = m-1 ; 
            }else{
                s = m+1 ; 
            }
        }

        return -1 ;
    }



    public static void main(String[] args) {
        int arr[] = {1,5,6,8,94,100} ; 
        int target = 100; 

        System.out.println(BinarySearch(arr, arr.length, target));
    }
}
