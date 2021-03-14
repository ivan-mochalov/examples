package examples.task;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class BinarySearchWithShift {

    public static int search(int[] array, int value) {
        validateArray(array);

        int lo = 0;
        int hi = array.length - 1;

        if (array[lo] > array[hi]) {
            if (array[lo] < value) {
                hi = searchShift(array) - 1;
            } else {
                lo = searchShift(array);
            }

        }

        return binarySearch(array, value, lo, hi);
    }

    private static void validateArray(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Wrong input array!");
        }
    }

    private static int binarySearch(int[] array, int value, int lo, int hi) {
        log.debug("Input: {}, [{}], [{}], [{}]", Arrays.toString(array), value, lo, hi);

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (value < array[mid]) {
                hi = mid - 1;
            } else if (value > array[mid]) {
                lo = mid + 1;
            } else {
                log.debug("Output: {}", mid);

                return mid;
            }
        }

        throw new IllegalArgumentException("Cannot find the value!");
    }

    private static int searchShift(int[] array) {
        log.debug("Input: {}", Arrays.toString(array));

        int lo = 0;
        int hi = array.length - 1;
        int mid = array.length / 2;

        while (array[mid] > array[mid - 1]) {
            mid = lo + (hi - lo) / 2;

            if (array[mid] > array[lo]) {
                lo = mid;
            } else if (array[hi] > array[mid]) {
                hi = mid;
            }
        }

        log.debug("Output: {}", mid);

        return mid;
    }
}
