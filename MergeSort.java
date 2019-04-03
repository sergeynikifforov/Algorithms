import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(int[] inputArray){
        int arrayLenght = inputArray.length;
        if(arrayLenght < 2){
            return;
        }
        int mid = arrayLenght/2;
        int[] left = new int[mid];
        int[] right = new int[arrayLenght - mid];

        for(int i = 0; i < mid; i++){
            left[i] = inputArray[i];
        }

        for(int i = mid; i < arrayLenght; i++){
            right[i-mid] = inputArray[i];
        }
        mergeSort(right);
        mergeSort(left);

        merge(inputArray,right,left);
    }
    public static void merge(int[] inputArray,int[] leftArray, int[] rightArray){
        int i = 0, j = 0, k = 0;
        int left = leftArray.length;
        int right = rightArray.length;
        while (i < left && j < right) {
            if (leftArray[i] <= rightArray[j]) {
                inputArray[k++] = leftArray[i++];
            }
            else {
                inputArray[k++] = rightArray[j++];
            }
        }
        while (i < left) {
            inputArray[k++] = leftArray[i++];
        }
        while (j < right) {
            inputArray[k++] = rightArray[j++];
        }
    }
    public static void main(String args[]) {
        int[] newArray = new int[] {3,-1,9,10,2};
        mergeSort(newArray);
        System.out.println(Arrays.toString(newArray));
    }
}
