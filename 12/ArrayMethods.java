import java.util.*;

public class ArrayMethods {
    public static void main(String[] args) {
        int[] arr = {49, 1, 3, 200, 2, 4, 70, 5};
        int[] withDups = {1, 3, 2, 3, 5, 1, 4, 2};
        int[] arr2 = {3, 5, 7, 9, 1};
        int[] mixed = {-5, 3, -2, 8, -1, 4};

        System.out.println("Original:          " + Arrays.toString(arr));
        System.out.println("Sorted descending: " + Arrays.toString(sortDescending(arr)));

        System.out.println("\nWith duplicates:   " + Arrays.toString(withDups));
        System.out.println("No duplicates:     " + Arrays.toString(removeDuplicates(withDups)));

        System.out.println("\nArray 1: " + Arrays.toString(arr));
        System.out.println("Array 2: " + Arrays.toString(arr2));
        System.out.println("Common:  " + Arrays.toString(findCommon(arr, arr2)));

        System.out.println("\nMixed: " + Arrays.toString(mixed));
        System.out.println("Closest to zero: " + Arrays.toString(closestToZero(mixed)));

        System.out.println("\nArray: " + Arrays.toString(arr));
        System.out.println("Longest consecutive: " + Arrays.toString(longestConsecutive(arr)));
    }

    // sort in descending order
    static int[] sortDescending(int[] arr) {
        int[] result = arr.clone();
        Arrays.sort(result);
        for (int i = 0, j = result.length - 1; i < j; i++, j--) {
            int temp = result[i];
            result[i] = result[j];
            result[j] = temp;
        }
        return result;
    }

    // remove all duplicate values
    static int[] removeDuplicates(int[] arr) {
        Set<Integer> seen = new LinkedHashSet<>();
        for (int n : arr) seen.add(n);
        int[] result = new int[seen.size()];
        int i = 0;
        for (int n : seen) result[i++] = n;
        return result;
    }

    // find elements present in both arrays
    static int[] findCommon(int[] a, int[] b) {
        Set<Integer> setA = new HashSet<>();
        for (int n : a) setA.add(n);
        List<Integer> common = new ArrayList<>();
        for (int n : b) {
            if (setA.contains(n)) common.add(n);
        }
        return common.stream().mapToInt(Integer::intValue).toArray();
    }

    // find two elements whose sum is closest to zero
    static int[] closestToZero(int[] arr) {
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        int left = 0;
        int right = sorted.length - 1;
        int minSum = Integer.MAX_VALUE;
        int[] result = new int[2];
        while (left < right) {
            int sum = sorted[left] + sorted[right];
            if (Math.abs(sum) < Math.abs(minSum)) {
                minSum = sum;
                result[0] = sorted[left];
                result[1] = sorted[right];
            }
            if (sum < 0) left++;
            else if (sum > 0) right--;
            else break;
        }
        return result;
    }

    // find longest consecutive sequence in unsorted array
    static int[] longestConsecutive(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int n : arr) set.add(n);
        int bestStart = arr[0];
        int bestLen = 0;
        for (int n : set) {
            if (!set.contains(n - 1)) {
                int current = n;
                int len = 1;
                while (set.contains(current + 1)) {
                    current++;
                    len++;
                }
                if (len > bestLen) {
                    bestLen = len;
                    bestStart = n;
                }
            }
        }
        int[] result = new int[bestLen];
        for (int i = 0; i < bestLen; i++) result[i] = bestStart + i;
        return result;
    }
}
