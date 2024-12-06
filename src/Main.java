import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = {10, 20, 30, 40, 50, 20, 30};


        System.out.println("Average: " + ArrayUtils.calculateAverage(array));
        System.out.println("Contains 30: " + ArrayUtils.containsValue(array, 30));
        System.out.println("Index of 40: " + ArrayUtils.findIndex(array, 40));
        System.out.println("Remove 20: " + Arrays.toString(ArrayUtils.removeElement(array, 20)));
        System.out.println("Min & Max: " + Arrays.toString(ArrayUtils.findMinMax(array)));
        System.out.println("Reversed: " + Arrays.toString(ArrayUtils.reverseArray(array)));
        System.out.println("Duplicates: " + ArrayUtils.findDuplicates(array));
        System.out.println("Common Elements: " + ArrayUtils.findCommonElements(new String[]{"apple", "banana"}, new String[]{"banana", "cherry"}));
        try {
            System.out.println("Second Largest: " + ArrayUtils.findNthLargest(array, 2));
            System.out.println("Second Smallest: " + ArrayUtils.findNthSmallest(array, 2));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Even/Odd: " + Arrays.toString(ArrayUtils.separateEvenOdd(array)));
    }
}
