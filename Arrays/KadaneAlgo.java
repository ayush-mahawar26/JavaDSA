package Arrays;

public class KadaneAlgo {

    // Use -> find the maximum sum of subArray in an Array 

    // BruteForce -> O(N^2) 
    static int bruteForce(int[] arr , int n){
        int max = 0 ;

        for(int i = 0 ; i < n-1 ; i++){
            int sum = arr[i] ;
            for(int j = i+1 ; j < n ; j++){
                sum += arr[j] ;
                if(sum > max){
                    max = sum ;
                }
            }
        }

        return max ;
    }

    // Kadane's Algo -> O(N)

    static int findLargestInNeg(int arr[] , int n){
        int largest = arr[0] ;
        for(int i = 1 ; i < n ; i++){
            if(arr[i] > largest){
                largest = arr[i] ;
            }
        }

        return largest ;
    }

    static int kadaneAlgorithm(int[] arr , int n){
        int max = 0 ; 
        int sum = 0 ; 

        for(int i = 0 ; i < n ; i++){
            sum += arr[i] ;
            if(sum < 0 ){
                sum = 0 ;
            }

            if(sum > max){
                max = sum ;
            }
        }

        if(max == 0){
            return findLargestInNeg(arr, arr.length) ;
        }

        return max ;
    }


    public static void main(String[] args) {
        int[] arr = {-4,-6,-2,-4,-9} ; 

        // System.out.println(bruteForce(arr, arr.length));
        System.out.println(kadaneAlgorithm(arr, arr.length));
    }
}   
