package com.algo.exercise.array;

public class JumpGameZeroValueIndex {
    public static void main(String[] args) {
        System.out.println(canReachZeroValueIndex(new int[] {4, 2, 3, 0, 3, 1, 2}, 3));
        System.out.println(canReachZeroValueIndex(new int[] {3, 0, 2, 1, 2}, 2));

    }

    private static boolean canReachZeroValueIndex(int [] arr, int start) {
        if (start >= 0 && start < arr.length && arr[start] >=0) {
            if (arr[start] == 0)
                return true;
            arr[start] = -arr[start];
            return canReachZeroValueIndex(arr, start + arr[start])
                    || canReachZeroValueIndex(arr, start - arr[start]);
        }
        return false;
    }
}
