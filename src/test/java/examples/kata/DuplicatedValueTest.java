package examples.kata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DuplicatedValueTest {

    private DuplicatedValue target;

    @BeforeEach
    void setUp() {
        target = new DuplicatedValue();
    }

    @Test
    void givenSequenceWithDuplicate_whenMethodExecuted_thenReturnsDuplicatedValue() {
        final int[] sequence = new int[]{1, 2, 3, 4, 5, 3};
        final int value = 3;

        int result = target.findDuplicatedValue(sequence);
        assertEquals(value, result);
    }

    @Test
    void givenSequenceWithDuplicates_whenMethodExecuted_thenReturnsFirstDuplicatedValue() {
        final int[] sequence = new int[]{1, 2, 3, 4, 5, 3, 5};
        final int value = 3;

        int result = target.findDuplicatedValue(sequence);
        assertEquals(value, result);
    }

    @Test
    void givenSequenceWithoutDuplicates_whenMethodExecuted_thenThrowsException() {
        final int[] sequence = new int[]{1, 2, 3, 4, 5};

        assertThrows(IllegalArgumentException.class, () -> target.findDuplicatedValue(sequence));
    }

}