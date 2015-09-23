package datastructures.sorting;

/**
 * Created by paulberesuita on 9/13/15.
 */
public class MergeSort {

    public static void main (String[] args) {

        int[] array = {10, 9, 1, 2, 3};

        mergesort(array);

        System.out.print("done");
    }

    public static void mergesort(int[] array) {

        int[] helper = new int[array.length];
        mergesort(array, helper, 0, array.length - 1);
    }

    public static void mergesort(int[] array, int[] helper, int low, int high) {

        if (low < high) {
            int middle = (low + high) / 2;
            mergesort(array, helper, low, middle);
            mergesort(array, helper, middle+1, high);
            merge(array, helper, low, middle, high);
        }
    }

    public static void merge(int[] array, int[] helper, int low, int middle, int high) {

        for (int i = low; i <= high; i++) {
            helper[i] = array[i];
        }

        int helperLeft = low;
        int helperRight = middle + 1;
        int current = low;

        while (helperLeft <= middle && helperRight <= high) {

            if (helper[helperLeft] <= helper[helperRight]) {

                array[current] = helper[helperLeft];
                helperLeft++;

            } else {

                array[current] = helper[helperRight];
                helperRight++;

            }

            current++;
        }

        int remaining = middle - helperLeft;
        for (int i = 0; i <= remaining; i++) {
            array[current + i] = helper[helperLeft + i];
        }

    }

    public static int biinarySearchIterative(int[] a, int x) {

        int low = 0;
        int high = a.length - 1;
        int mid;

        while (low <= high) {

            mid = (low + high) / 2;

            if (a[mid] < x) {
                low = mid + 1;
            } else if (a[mid] > x) {
                high = mid - 1;
            } else {
                return mid;
            }

        }

        return -1;

    }

    public static int binarySearchRecursive(int[] a, int x, int low, int high) {

//        if (low > high) {
//            return -1;
//        }
//
//        int mid = (low + high) / 2;
//        if (a[mid] < x) {
//            return binarySearchRecursive(a, x, mid+1, high);
//        } else if (a[mid] > x) {
//            return binarySearchRecursive(a, x, low, mid-1);
//        } else {
//            return mid;
//        }
//
//       Math.po
        return 0;

    }

}
