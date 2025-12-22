package Arrays;

import java.util.ArrayList;
import java.util.List;

public class BasicQuetions {
    public static void findMaxMin(int[] arr, int n) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;

        if (n == 0 || n == 1) {
            System.out.println(-1 + " " + -1);
        }
        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        for (int i = 0; i < n; i++) {
            if (secondMax < arr[i] && arr[i] != max) {
                secondMax = arr[i];
            }
            if (secondMin > arr[i] && arr[i] != min) {
                secondMin = arr[i];
            }
        }
        // Output the second smallest and second largest elements
        System.out.println("Second smallest is " + secondMin);
        System.out.println("Second largest is " + secondMax);

    }
    public static int optimalFindElement(int arr[] , int n ){
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;

        if (n == 0 || n == 1) {
            System.out.println(-1 + " " + -1);
            return -1;
        }
        for(int i = 0 ; i< n; i++){
            if(arr[0] < min){
                secondMin = min;
                min = arr[0];
            }
            else if(arr[i]< secondMin && arr[i] != min){
                secondMin = arr[i];
            }
        }
        return secondMin;
    }
    public static boolean isSorted(int []arr, int n){
        for(int i =0; i< n; i++) {
            if (arr[i] < arr[i+1]){
                return true;
            }
        }
        return false;
    }
    public static void reverse(int [] arr, int start , int end){
        int n = arr.length;
        while(start<end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start ++;
            end --;
        }
    }
    public static int[] rotate(int []arr, int k){
        int n = arr.length;
        if(n == 0 || n==1){
            return arr;
        }
        k = k%n;
        reverse(arr, 0, k-1);
        reverse(arr,k, n-1 );
        reverse(arr, 0 , n-1);
        return arr;
    }
    public static List<Integer> findUnion(int [] arr1, int [] arr2, int n , int m){
        List<Integer> union = new ArrayList<>();
        int i = 0 , j = 0;

        while (i<n && j<m){
            if(arr1[i]< arr2[j]){
                if(union.isEmpty() || union.get(union.size()-1) != arr1[i]){
                    union.add(arr1[i]);
                }
                i++;
            }
            else if(arr1[i]> arr2[j]){
                if(union.isEmpty() || union.get(union.size()-1) != arr2[j]){
                    union.add(arr2[j]);
                }
                j++;
            }
            else{
                if(union.isEmpty() || union.get(union.size()-1) != arr1[i]){
                    union.add(arr1[i]);
                }
                i++;
                j++;
            }
        }
        while(i<n){
            if(union.isEmpty() || union.get(union.size()-1) != arr1[i]){
                union.add(arr1[i]);
            }
            i++;
        }
        while(j<m){
            if(union.isEmpty() || union.get(union.size()-1) != arr2[j]){
                union.add(arr2[j]);
            }
            j++;
        }
        return union;
    }
    public static void main(String[] args) {

        // Driver code
        int n = 6;
        int[] arr = {1, 2, 4, 6, 7, 5};  // Array of elements
        findMaxMin(arr, n);
        System.out.println(optimalFindElement(arr, n));
        int [] arr2 = {1, 2, 3, 4, 5,6};
        System.out.println(isSorted(arr2, n));
        rotate(arr2, 2);
        for(int i= 0; i<arr2.length; i++)
        {
            System.out.print(arr2[i]+ " ");
        }
        int[] arr3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] arr4 = {2, 3, 4, 4, 5, 11, 12};
        List<Integer> result = findUnion(arr3, arr4, 10, 7);
        System.out.println(result);
//        System.out.println("Union of arr1 and arr2 is: ");
//        for (int val : result) System.out.print(val + " ");
    }
}
