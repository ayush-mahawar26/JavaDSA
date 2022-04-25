package Arrays.Algorithm.Sorting;
import java.util.*;

public class Selection {

    public static void swap(int[] a , int i, int j){
        int temp = a[i] ;
        a[i] = a[j] ;
        a[j] = temp ;
    }

    public static void main(String[] args) {
        // Find the minimum element and swap it with elemrnt at first

        int[] arr = {5,1,2,4,8,7,9,6,3};
        
        int n = arr.length ; 
        for(int i = 0 ; i < n-1 ;i++){
            int min = Integer.MAX_VALUE ;
            int itsPos = i ;
            for(int j = i+1 ; j < n ; j++ ){
                if(arr[j] < min){
                    min = arr[j] ;
                    itsPos = j ;
                }
            }

            if(arr[i] > arr[itsPos]) swap(arr, i, itsPos);
        }

        System.out.println(Arrays.toString(arr));
    }
}
