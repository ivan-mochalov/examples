package examples.task;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FindSumInArrayTest {

    private FindSumInArray target;

    @BeforeEach
    void setUp() {
        target = new FindSumInArray();
    }

    @Test
    void givenSequenceWithSum_whenMethodExecuted_thenReturnsValuesPosition() {
        final int value = 9;
        final int[] sequence = new int[]{2, 7, 15, 9};

        int[] numbersPosition = target.findNumbersPosition(value, sequence);
        assertEquals(0, numbersPosition[0]);
        assertEquals(1, numbersPosition[1]);
    }

    @Test
    void givenSequenceWithMoreThanOneCombination_whenMethodExecuted_thenReturnsFirstCombinationPositions() {
        final int value = 19;
        final int[] sequence = new int[]{1, 4, 5, 7, 11, 15, 8};

        int[] numbersPosition = target.findNumbersPosition(value, sequence);
        assertEquals(1, numbersPosition[0]);
        assertEquals(5, numbersPosition[1]);
    }

    @Test
    void givenSequenceWithoutSumCombination_whenMethodExecuted_thenThrowsException() {
        final int value = 190;
        final int[] sequence = new int[]{1, 4, 5, 7, 11, 15, 8};

        assertThrows(IllegalStateException.class, () -> target.findNumbersPosition(value, sequence));
    }
}