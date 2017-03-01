public class Main {
    public static void main(String[] args) {

    }

    //Method for creating an array

    public static int[] createArray(int number) {
        int[] array = new int[number];
        for (int i = 0; i < number; i++)
            array[i] = (int) (Math.random() * number);
        return array;
    }

    //List of implementation of different sorting algorithms:
    // 1. Insertion Sort
    // Complexity: B Ω(n)	A Θ(n^2)	W O(n^2)	M O(1)
    // Pros:
    //  Efficient for sorting of small data
    //  Efficient for data that are almost sorted
    //  In-place sorting as only constant amount of additional memory space is required
    //  Stable sorting algorithm, since it does not change the relative order of elements with equal keys
    //
    // Cons
    //  Less efficient for sorting of large data

    public static int[] insertionSort(int[] array){
        int temp;
        for (int i = 1; i < array.length; i++) {
            for(int j = i ; j > 0 ; j--){
                if(array[j] < array[j - 1]){
                    temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
        return array;
    }

    public static int[] selectionSort(int[] array){

        for (int i = 0; i < array.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < array.length; j++)
                if (array[j] < array[index])
                    index = j;

            int smallerNumber = array[index];
            array[index] = array[i];
            array[i] = smallerNumber;
        }
        return array;
    }
}
