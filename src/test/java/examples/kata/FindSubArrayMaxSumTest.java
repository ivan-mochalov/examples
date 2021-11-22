package examples.kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindSubArrayMaxSumTest {

    @Test
    void givenArrayWithPositiveValues_whenFindMaxSum_thenReturnMaxSum() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        int expected_result = 45;

        int result = FindSubArrayMaxSum.findSubArrayMaxSum(array);

        assertEquals(expected_result, result);
    }

    @Test
    void givenArrayWithPositiveAndNegative_whenFindMaxSum_thenReturnMaxSum() {
        int[] array = {1, -2, 3, -4, 5, -6, 7, -8, 9, 0};
        int expected_result = 25;

        int result = FindSubArrayMaxSum.findSubArrayMaxSum(array);

        assertEquals(expected_result, result);
    }

    @Test
    void givenArrayWithOnePositiveAndManyNegativeValues_whenFindMaxSum_thenReturnPositiveValue() {
        int[] array = {-1, -2, -3, -4, -5, -6, -7, -8, 9, 0};
        int expected_result = 9;

        int result = FindSubArrayMaxSum.findSubArrayMaxSum(array);

        assertEquals(expected_result, result);
    }

    @Test
    void givenArrayWithNegativeValues_whenFindMaxSum_thenReturnMaxNegativeValue() {
        int[] array = {-1, -2, -3, -4, -5, -6, -7, -8, -9};
        int expected_result = -1;

        int result = FindSubArrayMaxSum.findSubArrayMaxSum(array);

        assertEquals(expected_result, result);
    }
}
