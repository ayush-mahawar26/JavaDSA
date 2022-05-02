package Arrays.Algorithm;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class AddAndRemove {

    // Duplicate zeros 

    static void rightShift(int[] a , int s){
        int j = s+1 ; 
        for(int i = j ; i < a.length ; i++){
            int temp = a[s] ;
            a[s] = a[i] ;
            a[i] = temp ;
        }
    }

    static void duplicateZero(int arr[]){
        for(int i = 0 ; i < arr.length-2 ; i++){
            if(arr[i] == 0){
                rightShift(arr , i+1) ;
                arr[i+1] = 0 ;
                i+=1 ;
            }
            if(i == arr.length-3){
                if(arr[i+1] == 0){
                    arr[i+2] = 0 ;
                    return ;
                }
            }
        }

    }


    // Merge two Sorted Array 
    static void merge(int a[] , int b[] , int m , int n){
        int i = 0 ; 
        int j= 0 ; 
        int ind = 0 ;

        int[] res = new int[m+n] ;

        while (i<=m-1 && j<=n-1) {
            if(a[i] < b[j]){
                res[ind] = a[i] ;
                i++ ;
            }else if(b[j] <= a[i]){
                res[ind] = b[j]; 
                j++ ;
            }

            ind++; 
        }

        while(i <= m-1){
            res[ind] = a[i] ;
            i++;
            ind ++; 
        }

        while(j <= n-1){
            res[ind] = b[j] ;
            j++ ; 
            ind ++ ;
        }

        for(int s = 0 ; s < m+n ; s++){
            a[s] = res[s] ;
        }
    }

    // removing element 
    static int removingEle(int[] nums){

        if(nums.length == 0){
            return 0 ;
        }
        
        int i = 0 ; 
        for(int j = i+1 ; j < nums.length ;j++){
            if(nums[j] != nums[i]){
                i++ ;
                nums[i] = nums[j] ;
            }
        }


        return i+1 ;

    }


    // Using - Two Pointer 
    static void reverseArray(int a[]){
        int m = a.length/2 ;

        for(int i = 0 ; i < m ; i++){
            int temp= a[i] ; 
            a[i] = a[a.length-1-i] ;
            a[a.length-1-i] = temp ; 
        }
    }
    static int[] sqOfSorted(int a[]){
        int i = 0 ; 
        int j = a.length-1 ;
        int[] res = new int[a.length] ;
        int ind = 0 ; 

        while(i<=j){
            if(a[i]*a[i] > a[j]*a[j]){
                res[ind] = a[i]*a[i] ;
                i++ ;
            }else{
                res[ind] = a[j]*a[j] ;
                j-- ;
            }

            ind ++ ;
        }
        reverseArray(res);
        return res ;
    }

    static int[] sortEvenOdd(int[] nums){

        if(nums.length==1 || nums.length ==2){
            return nums ;
        }
        int even[] ; 
        if(nums.length%2!=0){
            even = new int[nums.length/2+1] ;
        }else{

            even = new int[nums.length/2] ;
        }
        int[] odd = new int[nums.length/2];
        
        int ei = 0 ; 
        int oi = 0 ;
        
        for(int i = 0 ; i < nums.length ; i+=2){
            even[ei] = nums[i] ;
            ei ++ ;

            if(i==nums.length-1){
                break ;
            }
            
            odd[oi] = nums[i+1] ;
            oi++ ;
        }
        
        Arrays.sort(even) ;
        Arrays.sort(odd , Collections.reverseOrder()) ;
        
        int trk = 0 ; 
        for(int i = 0; i < nums.length ; i+=2){
            nums[i] = even[trk] ;
            if(i==nums.length-1){
                break ;
            }
            nums[i+1] = odd[trk] ;

            trk++ ;
            
        }
        
        return nums ;
        
    }

    public static void main(String[] args) {
        int[] a = {199,3,24};
        // int[] b = {2,,5,,6} ;
        // // duplicateZero(a);
        // merge(a, b, 3, 3);
        // System.out.println(Arrays.toString(a));
        // System.out.println(removingEle(a));

        System.out.println(Arrays.toString(sortEvenOdd(a)));
        
    }
}
