import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class QuickSortBinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Enter number of array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(10);
        }

        System.out.println("Unsorted array: " + Arrays.toString(arr));
        
        quickSort(arr, 0, n - 1);
        System.out.println("Sorted array: " + Arrays.toString(arr));
        
        System.out.print("Enter search value: ");
        int target = scanner.nextInt();
        
        int index = binarySearch(arr, target);
        if (index != -1) {
            System.out.println("Found " + target + " at index: " + index);
        } else {
            System.out.println(target + " not found in the array.");
        }

        scanner.close();
    }
    
    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }
    
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }
    
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    private static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
