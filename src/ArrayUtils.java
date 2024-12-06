import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayUtils {

    // 1. Calculate average value of array
    public static double calculateAverage(int[] arr) {
        return Arrays.stream(arr).average().orElse(0);
    }

    // 2. Test if an array contains a specific value
    public static boolean containsValue(int[] arr, int value) {
        return Arrays.stream(arr).anyMatch(num -> num == value);
    }

    // 3. Find the index of an array element
    public static int findIndex(int[] arr, int value) {
        return IntStream.range(0, arr.length).filter(i -> arr[i] == value).findFirst().orElse(-1);
    }

    // 4. Remove a specific element from an array
    public static int[] removeElement(int[] arr, int value) {
        return Arrays.stream(arr).filter(num -> num != value).toArray();
    }

    // 5. Find maximum and minimum value of an array
    public static int[] findMinMax(int[] arr) {
        return new int[]{Arrays.stream(arr).min().orElse(0), Arrays.stream(arr).max().orElse(0)};
    }

    // 6. Reverse an array
    public static int[] reverseArray(int[] arr) {
        return IntStream.range(0, arr.length).map(i -> arr[arr.length - 1 - i]).toArray();
    }

    // 7. Find duplicate values in an integer array
    public static Set<Integer> findDuplicates(int[] arr) {
        Set<Integer> duplicates = new HashSet<>();
        Set<Integer> seen = new HashSet<>();
        for (int num : arr) {
            if (!seen.add(num)) {
                duplicates.add(num);
            }
        }
        return duplicates;
    }

    // 8. Find duplicate values in a string array
    public static Set<String> findDuplicates(String[] arr) {
        Set<String> duplicates = new HashSet<>();
        Set<String> seen = new HashSet<>();
        for (String str : arr) {
            if (!seen.add(str)) {
                duplicates.add(str);
            }
        }
        return duplicates;
    }

    // 9. Find common elements between two string arrays
    public static Set<String> findCommonElements(String[] arr1, String[] arr2) {
        Set<String> set1 = new HashSet<>(Arrays.asList(arr1));
        set1.retainAll(Arrays.asList(arr2));
        return set1;
    }

    // 10. Remove duplicate elements from an array
    public static int[] removeDuplicates(int[] arr) {
        return Arrays.stream(arr).distinct().toArray();
    }

    // 11 & 12. Find second largest and second smallest element
    public static int findNthLargest(int[] arr, int n) {
        int[] distinctArr = Arrays.stream(arr).distinct().sorted().toArray();
        int len = distinctArr.length;

        if (n > len) {
            throw new IllegalArgumentException("n is larger than the number of distinct elements in the array.");
        }
        return distinctArr[len - n];
    }

    public static int findNthSmallest(int[] arr, int n) {
        int[] distinctArr = Arrays.stream(arr).distinct().sorted().toArray();
        if (n > distinctArr.length) {
            throw new IllegalArgumentException("n is larger than the number of distinct elements in the array.");
        }
        return distinctArr[n - 1];
    }

    // 13. Separate even and odd numbers
    public static int[] separateEvenOdd(int[] arr) {
        List<Integer> evens = Arrays.stream(arr).filter(num -> num % 2 == 0).boxed().collect(Collectors.toList());
        List<Integer> odds = Arrays.stream(arr).filter(num -> num % 2 != 0).boxed().collect(Collectors.toList());
        evens.addAll(odds);
        return evens.stream().mapToInt(i -> i).toArray();
    }

    // 14 & 15. Find k largest and k smallest elements
    public static int[] findKLargest(int[] arr, int k) {
        return Arrays.stream(arr).boxed().sorted(Collections.reverseOrder()).mapToInt(i -> i).limit(k).toArray();
    }

    public static int[] findKSmallest(int[] arr, int k) {
        return Arrays.stream(arr).sorted().limit(k).toArray();
    }

    // 16 & 17. Swap two or three elements with temp variable
    public static void swapTwo(int[] nums) {
        int temp = nums[0];
        nums[0] = nums[1];
        nums[1] = temp;
    }

    public static void swapThree(int[] nums) {
        int temp = nums[0];
        nums[0] = nums[1];
        nums[1] = nums[2];
        nums[2] = temp;
    }

    // 18. Copy array
    public static int[] copyArray(int[] arr) {
        return Arrays.copyOf(arr, arr.length);
    }

    // 19. Find frequency of each element
    public static Map<Integer, Integer> findFrequency(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        return freq;
    }

    // 20–25. Reverse, even/odd positions, sum, and sort array
    public static int[] reverse(int[] arr) {
        return reverseArray(arr);
    }

    public static int[] elementsAtEvenPositions(int[] arr) {
        return IntStream.range(0, arr.length).filter(i -> i % 2 == 0).map(i -> arr[i]).toArray();
    }

    public static int[] elementsAtOddPositions(int[] arr) {
        return IntStream.range(0, arr.length).filter(i -> i % 2 != 0).map(i -> arr[i]).toArray();
    }

    public static int sumOfElements(int[] arr) {
        return Arrays.stream(arr).sum();
    }

    public static int[] sortAscending(int[] arr) {
        return Arrays.stream(arr).sorted().toArray();
    }

    public static int[] sortDescending(int[] arr) {
        return Arrays.stream(arr).boxed().sorted(Collections.reverseOrder()).mapToInt(i -> i).toArray();
    }
}
