package Practice.Sorting;

import java.util.Arrays;
import java.util.stream.Collectors;

public class QuickSort {


    public int[] sort(int[] array, int start, int end) {

        if (start < end) {
            int pivot = partition(array, start, end);
            sort(array, start, pivot - 1);
            sort(array, pivot + 1, end);
        }
        return array;
    }

    private int partition(int[] array, int start, int end) {

        int i = start - 1;
        int pivot = array[end];

        for (int j = start; j < end; j++) {

            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, end);
        return i + 1;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        System.out.println(Arrays.stream(quickSort.sort(new int[]{2, 3, 4, 1, 2, 6}, 0, 5)).boxed().collect(Collectors.toList()));
    }
}
