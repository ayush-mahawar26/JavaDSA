package Arrays.Algorithm.Sorting;
import java.util.Arrays;

public class QuickSort {
    // Recursion Solution 
    // Pivot Element 
    // TIme complex. O(NLogN)


    // 1 5 4 2 6 3  | 5 3
    // 1 3 4 2 6 5 |  4 2
    // 1 3 2 4 6 5 |
    // 1 3 2 || 6 5
    // 1 2 3
    //  

    
    static void sort(int[] a , int lw , int hi){
        if(lw>=hi || lw<0 || hi > a.length-1){
            return ;
        }

        int i = lw ; 
        int j = hi ; 
        int m = i + (j - i)/2 ;
        int piv = a[m] ;

        while (i<j) {
            while(a[i] < piv){
                i++ ;
            }

            while(a[j] > piv){
                j-- ;
            }

            if(i<=j){
                int temp = a[i] ;
                a[i] = a[j] ;
                a[j] = temp ;
                i++ ;
                j-- ;
            }
        }

        sort(a, i, j-1);
        sort(a, j+1, hi);

    }

    public static void main(String[] args) {
        int[] a = {1,5,4,2,6,9,8} ;
        int n = a.length ;

        sort(a, 0 , n-1);    
        System.out.println(Arrays.toString(a));
        
    }


}
