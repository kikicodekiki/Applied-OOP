package Week_10.week10_6.com.geometry.utils.src.com.geometry.utils;

public class SelectionSort {
    public static void sortArray(Comparable[] arr) {
        if(arr == null || arr.length == 0) {
            return;
        }
        Comparable temp;
        int index;
        for (int i = 0; i < arr.length; i++) {
            index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[index].compareTo(arr[j]) > 0) {
                    index = j;
                }
            }
            if(index != i) {
                //swap
                temp = arr[index];
                arr[index] = arr[i];
                arr[i] = temp;
            }
        }
    }
}
