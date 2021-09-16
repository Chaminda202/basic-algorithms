package com.algo.exercise.array;

public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(binarySearchAlgo(new int[] {1, 2, 3, 4, 8, 12, 15}, 12));
    }

    private static int binarySearchAlgo(int [] arr, int target) {
        int left = 0, mid = 0, right = arr.length -1;
        while (left <= right) {
            mid = (left + right)/2;
            if (target == arr[mid]) {
                return mid;
            } else if (target < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
