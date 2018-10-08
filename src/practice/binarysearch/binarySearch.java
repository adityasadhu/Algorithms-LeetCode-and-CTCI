package practice.binarysearch;

public class binarySearch {

    static public int answer(int[] array, int target) {
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (array[mid] == target)
                return mid;
            else if (array[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

    public int answerRecursive(int[] array, int target) {
        int start = 0;
        int end = array.length - 1;
        return binarySearchRecursive(array, target, start, end);

    }

    public int binarySearchRecursive(int[] array, int target, int start, int end) {

        if (start > end)
            return -1;

        int mid = (start + end) / 2;

        if (array[mid] == target) {
            return mid;
        } else if (array[mid] < target) {
            return binarySearchRecursive(array, target, mid + 1, end);
        } else {
            return binarySearchRecursive(array, target, start, mid - 1);
        }

    }


    public static void main(String[] args) {

        int answer = answer(new int[]{1, 2, 3, 4, 5, 6}, 5);
        System.out.println(answer);

        binarySearch binarySearch = new binarySearch();
        int answerRecursive = binarySearch.answerRecursive(new int[]{1, 2, 3, 4, 5, 6}, 5);
        System.out.println(answerRecursive);


    }
}
