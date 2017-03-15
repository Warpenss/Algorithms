public class Main {
    public static void main(String[] args) {
        int[] array = createArray(10);
        mergeSort(array);
        for (int i : array)
            System.out.println(i);
    }

    //Method for creating an array

    public static int[] createArray(int number) {
        int[] array = new int[number];
        for (int i = 0; i < number; i++)
            array[i] = (int) (Math.random() * number);
        return array;
    }

    //Custom sort
    public static int[] sort(int[] array) {

        return array;
    }

    //List of implementation of different sorting algorithms:
    // 1. Insertion Sort
    // Complexity: B Ω(n)	A Θ(n^2)	W O(n^2)	M O(1)    Stable
    // Pros:
    //  +Efficient for sorting of small data
    //  +Efficient for data that are almost sorted
    //  +In-place sorting as only constant amount of additional memory space is required
    //  +Stable sorting algorithm, since it does not change the relative order of elements with equal keys
    // Cons
    //  -Less efficient for sorting of large data

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

    // 2. Selection Sort
    // Complexity: B Ω(n^2)	A Θ(n^2)	W O(n^2)	M O(1) Unstable
    // Pros
    //  +Easy to implement
    // Cons
    //  +Is no faster on a partially sorted array

    static int[] selectionSort( int[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < array.length; j++) {
                if ( array[j] < array[index]) {
                    index = j;
                }
            }
            int temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
        return array;
    }

    //3. Bubble Sort
    //Complexity: B Ω(n)	A Θ(n^2)	W O(n^2)	M O(1) Stable
    // Pros:
    //  +Efficient for sorting of small data
    //  +Efficient for data that are almost sorted
    //  +In-place sorting as only constant amount of additional memory space is required
    //  +Stable sorting algorithm, since it does not change the relative order of elements with equal keys
    // Cons
    //  -Less efficient for sorting of large data

    static int[] bubbleSort(int[] array) {
        int i;
        int j;
        int temp;

        for (i = 0; i < array.length - 1; i++) {
            for (j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }

    static int[] bubbleSortFlag(int[] array) {
        boolean swapped = true;
        int j = 0;
        int tmp;
        while (swapped) {
            swapped = false;
            j++;
            for (int i = 0; i < array.length - j; i++) {
                if (array[i] > array[i + 1]) {
                    tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                    swapped = true;
                }
            }
        }
        return array;
    }


    // 4. Quick Sort
    // Complexity: B Ω(nlogn)	A Θ(nlogn)	W O(n^2)	M O(n)    Unstable
    // Pros:
    //  +Fastest in almost all situations
    // Cons:
    //  -As slow as bubble sort in the worst case
    //

    static int partition(int arr[], int left, int right)
    {
        int i = left, j = right;
        int tmp;
        int pivot = arr[left + (right - left) / 2];

        while (i <= j) {
            while (arr[i] < pivot)
                i++;
            while (arr[j] > pivot)
                j--;
            if (i <= j) {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        };

        return i;
    }

    static void quickSort(int arr[], int left, int right) {
        int index = partition(arr, left, right);
        if (left < index - 1)
            quickSort(arr, left, index - 1);
        if (index < right)
            quickSort(arr, index, right);
    }


    // 5. Merge Sort
    // Complexity: B Ω(nlong)	A Θ(nlong)	W O(nlong)	M O(n)    Stable
    // Pros:
    //  + Guaranteed to be O(n.log n) or even O(n) with LinkedList
    //  + Stable
    // Cons:
    //  -Not as fast as Quick sort on average
    //  -Requires as much memory as the original array
    //

    public static int[] mergeSort(int[] list) {
        if (list.length <= 1) {
            return list;
        }

        // Split the array in half
        int[] first = new int[list.length / 2];
        int[] second = new int[list.length - first.length];
        System.arraycopy(list, 0, first, 0, first.length);
        System.arraycopy(list, first.length, second, 0, second.length);

        // Sort each half
        mergeSort(first);
        mergeSort(second);

        // Merge the halves together, overwriting the original array
        merge(first, second, list);
        return list;
    }

    private static void merge(int[] first, int[] second, int[] result) {
        // Merge both halves into the result array
        // Next element to consider in the first array
        int iFirst = 0;
        // Next element to consider in the second array
        int iSecond = 0;

        // Next open position in the result
        int j = 0;
        // As long as neither iFirst nor iSecond is past the end, move the
        // smaller element into the result.
        while (iFirst < first.length && iSecond < second.length) {
            if (first[iFirst] < second[iSecond]) {
                result[j] = first[iFirst];
                iFirst++;
            } else {
                result[j] = second[iSecond];
                iSecond++;
            }
            j++;
        }
        // copy what's left
        System.arraycopy(first, iFirst, result, j, first.length - iFirst);
        System.arraycopy(second, iSecond, result, j, second.length - iSecond);
    }
}