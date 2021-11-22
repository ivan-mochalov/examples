package examples.kata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SortedArrayWithSquaredValuesTest {

    private SortedArrayWithSquaredValues target;

    @BeforeEach
    void setUp() {
        target = new SortedArrayWithSquaredValues();
    }

    @Test
    void givenSortedArray_whenSquareUpExecuted_thenArrayValuesBecomesSquaredAndSortingStillPresent() {
        int[] values = new int[]{-5, -3, 1, 2, 4, 6};

        int[] result = target.squareUp(values);

        System.out.println(Arrays.toString(result));

        assertEquals(1, result[0]);
        assertEquals(36, result[5]);
    }
}
