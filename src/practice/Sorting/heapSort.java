package practice.Sorting;

import java.util.Arrays;
import java.util.stream.Collectors;

public class heapSort {

    public void heapify(int[] array, int heapSize, int index) {
        int leftChild = (2 * index) + 1;
        int rightChild = (2 * index) + 2;

        int maximum = index;

        if (leftChild < heapSize && array[maximum] < array[leftChild])
            maximum = leftChild;

        if (rightChild < heapSize && array[maximum] < array[rightChild])
            maximum = rightChild;

        if (maximum != index) {
            swap(array, maximum, index);
            heapify(array, heapSize, maximum);
        }
    }

    private void swap(int[] array, int a, int b) {

        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;

    }

    public int[] sort(int[] array) {
        int length = array.length;

        for (int i = length - 1; i >= 0; i--) {
            heapify(array, length, i);
        }

        for (int i = length - 1; i >= 0; i--) {
            swap(array, 0, i);
            heapify(array, i, 0);
        }

        return array;
    }


    public static void main(String[] args) {

        heapSort heapSort = new heapSort();
        System.out.println(Arrays.stream(heapSort.sort(new int[]{3, 4, 1, 45, 5})).boxed().collect(Collectors.toList()));

    }
}
