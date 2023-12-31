package algoVersuch1;
import java.util.Arrays;

public class AlgoVersuch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char[] array = {'a', 'z','g','9','o', 'l','j', 'w', '1'};
        System.out.println("Zu sortierendes Array: " + Arrays.toString(array));
        sortiereMitMergeSort(array, 0, array.length - 1);
        System.out.println("Sortiertes Array: " + Arrays.toString(array));
	}
	
	public static void sortiereMitMergeSort(char[] array, int begin, int end) {
        if (begin < end) {
            int middle = (begin + end) / 2;
            sortiereMitMergeSort(array, begin, middle);
            sortiereMitMergeSort(array, middle + 1, end);
            merge(array, begin, middle, end);
        }
    }
	
	
    public static void merge(char[] array, int begin, int middle, int end) {
        char[] tempArray = Arrays.copyOfRange(array, begin, end + 1);//
        int i = begin;
        int j = middle + 1;
        int k = begin;

        System.out.println("Zu mergender Teil: " + Arrays.toString(tempArray));

       while (i <= middle && j <= end) {
            if (tempArray[i - begin] >= tempArray[j - begin]) {
                array[k] = tempArray[i - begin];
                i++;
            } else {
                array[k] = tempArray[j - begin];
                j++;
            }
            k++;
        }

        while (i <= middle) {
            array[k] = tempArray[i - begin];
            i++;
            k++;
        }
        
        System.out.println("Gemergter Teil: " + Arrays.toString(Arrays.copyOfRange(array, begin, end + 1)));
    }

}
