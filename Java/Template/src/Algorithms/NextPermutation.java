package Algorithms;

import com.sun.source.tree.AssertTree;

import java.util.Arrays;

public class NextPermutation {

    public static void swap(int [] arr, int i , int j){

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public  void reverse(int [] arr, int pivot){

        //reverse the values after the index pivot
        int  n = arr.length;
        int i = pivot, j = n-1;
        while(i<j && i<n && j>= pivot){
            swap(arr, i, j);
        }
    }

    public  static void nextPermutation(int []arr){

        //algorithm
//        int [] ans = Arrays.copyOf(arr, arr.length);
        int n = arr.length;
        int pivot = -1;

        for(int i =  n-2; i>=0; i-- ){

            if(arr[i]< arr[i+1]){

                pivot = i;
                int j = n - 1;
                while(j > i){
                    if(arr[j] > arr[i]){
                        swap(arr, i , j);
                        break;
                    }
                }
                break;
            }
        }




        //3 2 1 5 4
        //1 2 3 4 5



    }

    public String nextPermutation(String s){


        return s;
    }

    public static void main(String[] args) {


        int arr [] = {1, 2, 3, 4, 5};
        nextPermutation(arr);
        if(!Arrays.equals(arr, new int[]{1,2,3,5,4})){

            throw new AssertionError("Test failed");
        }
        else {
            System.out.println("Test passed");
        }
    }
}
