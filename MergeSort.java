public class MergeSort {
    public static void mergeSort(int[] input){
        sort(input, 0, input.length -1);
    }

    public static void sort(int[] input, int start, int end){
        if(end > start) {
            sort(input, start, (end - start) / 2 + start);
            sort(input, (end - start) / 2 + start + 1, end);
            merge(input, start, (end - start) / 2 + start , end);
        }
    }

    public static void merge(int[] input, int left, int right, int end){
        int[] clone = input.clone();
        int i = left, counter = left;
        int j = right + 1;
        // compare the two sides and merge them back into one array.
        while (i <= right && j <= end)
            input[counter++] = clone[i] <= clone[j] ? clone[i++] : clone[j++];
        // add back the leftover in the front array.
        while(i <= right) input[counter++] = clone[i++];
    }

    public static void main(String[] args){
        int[] input = {1,2,7,3,4,2,7,0,1};
        mergeSort(input);
        for(int a: input)
            System.out.print(a);
    }
}