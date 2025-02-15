import java.util.Random;
import java.util.Scanner;

public class QuickSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        System.out.print("Enter number of array: ");
        int n = scanner.nextInt();
        
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(10); 
        }
        
        System.out.print("Unsorted array: ");
        printArray(array);
        
        quickSort(array, 0, n - 1);
        
        System.out.print("Sorted array: ");
        printArray(array);
        
        scanner.close();
    }
    
    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(arr, left, right);
            quickSort(arr, left, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, right);
        }
    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left - 1;
        
        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, right);
        return i + 1;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}
