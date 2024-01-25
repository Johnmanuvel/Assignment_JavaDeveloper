package main.java;

public class ArraySorting {
    public static void sortArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            System.out.println("Array is null or empty.");
            return;
        }

        int low = 0;
        int high = nums.length - 1;
        int mid = 0;

        while (mid <= high) {
            switch (nums[mid]) {
                case 0:
                    swap(nums, low, mid);
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(nums, mid, high);
                    high--;
                    break;
                default:
                    System.out.println("Invalid element in the array.");
                    return;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] inputArray = {0, 1, 2, 1, 2, 0, 2, 0, 1};
        System.out.println("Input Array:");
        printArray(inputArray);
        sortArray(inputArray);
        System.out.println("Sorted Array:");
        printArray(inputArray);
    }
}
