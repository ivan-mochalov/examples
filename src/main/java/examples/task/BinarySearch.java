package examples.task;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class BinarySearch {

    public static int searchValueInShiftedArray(int[] array, int value) {
        validateArray(array);

        int lo = 0;
        int hi = array.length - 1;

        if (array[hi] > value) {
            lo = findShiftIndex(array, lo, hi);
        } else if (array[hi] < value) {
            hi = findShiftIndex(array, lo, hi) - 1;
        } else {
            return hi;
        }

        return findValueIndex(array, value, lo, hi);
    }

    private static void validateArray(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Wrong input array!");
        }
    }

    private static int findShiftIndex(int[] array, int lo, int hi) {
        log.debug("Input: array:{}, lo: {}, hi:{}", Arrays.toString(array), lo, hi);

        int mid = hi / 2;

        if (array[lo] < array[hi]) {
            mid = lo;
        } else {
            while (array[mid] > array[mid - 1]) {
                mid = (hi - lo) / 2 + lo;

                if (array[mid] > array[lo]) {
                    lo = mid;
                } else if (array[mid] < array[hi]) {
                    hi = mid;
                }
            }
        }

        log.debug("Output: {}", mid);

        return mid;
    }

    private static int findValueIndex(int[] array, int value, int lo, int hi) {
        log.debug("Input values: array: {}, value: {}, lo: {}, hi: {}", array, value, lo, hi);

        while (lo <= hi) {
            int mid = (hi - lo) / 2 + lo;

            if (array[mid] > value) {
                hi = mid - 1;
            } else if (array[mid] < value) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }

        throw new IllegalArgumentException(
                String.format("Cannot find the value [%s] in array %s", value, Arrays.toString(array)));
    }
}