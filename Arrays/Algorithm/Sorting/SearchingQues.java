package Arrays.Algorithm.Sorting;

import java.util.*;

public class SearchingQues {
    
    static boolean checkNDouble(int arr[]){

        HashSet<Integer> set = new HashSet<>() ;

        for(int cur : arr) {
            if(cur%2==0){
                int mul = cur*2 ;
                int div = cur/2 ;

                if(set.contains(mul)|| set.contains(div)){
                    return true ;
                }
            }else{
                int mul = cur*2 ;
                if(set.contains(mul)){
                    return true ;
                }
            }

            set.add(cur) ;
        }


        return false ;
    }

    static boolean validMountain(int[] arr){
        int i = 0 ; 
        int j = arr.length-1 ;

        while(i<j){
            if(arr[i] < arr[j]){
                i++ ;
            }
            else if(arr[i] > arr[j]){
                j-- ;
            }else{
                i++ ;
                j-- ;
            }
        }

        // left check
        boolean left = false ;
        for(int k = 0 ; k < i; k++){
            if(arr[k] >= arr[k+1]){
                left = false ;
                break ;
            }

            left = true ;
        }

        // // right check

        boolean right = false ;
        for(int k = i+1 ; k < arr.length ; k++){
            if(arr[k] >= arr[k-1]){
                right = false ;
                break ;
            }

            right = true ;
        }

        return left&&right;
    }

    static void moveZeroes(int[] nums){
        int i = 0 ; 

        while(i < nums.length-1){

            while(nums[i]!=0){
                if(i == nums.length-1){
                    break ;
                }
                i++ ;
            } 
            if(i==nums.length-1){
                break;
            }

            int j = i+1 ;
            while(nums[j] == 0){
                j++ ;
                if(j==nums.length){
                    break ;
                }
            }
            if(j==nums.length){
                break;
            }

            int temp = nums[i] ;
            nums[i] = nums[j] ;
            nums[j] = temp ;
            i++ ;
        }

    }

    static int[] paritySort(int a[]){
        int i = 0 ; int j = a.length-1 ;

        while(i<j){
            while(a[i]%2==0){
                if(i==a.length-1){
                    break ;
                }
                i++ ;
            }
            if(i == a.length-1){
                break ;
            }

            while(a[j]%2!=0){
                j-- ;
                if(j < 0){
                    break ;
                }
            }

            if(j <0){
                break;
            }

            if(i<j){
                int temp = a[i] ;
                a[i] = a[j] ;
                a[j] = temp ;
                i++ ; 
                j-- ;
            }
        }

        return a ;
    }

    static int heightChecker(int[] height){
        int[] comp = height.clone();
        Arrays.sort(comp);
        int count = 0 ;
        for(int i = 0 ; i < height.length ; i++){
            if(height[i] != comp[i]){
                count++ ;
            }
        }

        return count ;
    }

    public static void main(String[] args) {
        int[] a = {1,1,4,2,1,3};
        System.out.println(heightChecker(a));
    }
}
