package examples.task;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BinarySearchWithShiftTest {

    @Test
    void givenArrayWithoutShift_whenSearchValue_thenValueFound() {
        int[] array = new int[]{1, 2, 4, 6, 8, 10, 14, 16, 24, 45, 78, 89};
        int value = 8;
        int expectedValuePosition = 4;

        int valuePosition = BinarySearchWithShift.search(array, value);

        assertEquals(valuePosition, expectedValuePosition);
    }

    @Test
    void givenValueNotPresented_whenSearchValue_thenExceptionOccurred() {
        int[] array = new int[]{1, 2, 4, 6, 8, 10, 14, 16, 24, 45, 78, 89};
        int value = 99;

        assertThrows(IllegalArgumentException.class, () -> BinarySearchWithShift.search(array, value));
    }

    @Test
    void givenShiftOnTheRightValueOnTheRight_whenSearchValue_thenReturnsValue() {
        int[] array = new int[]{6, 8, 10, 14, 16, 24, 45, 78, 89, 1, 2, 4};
        int value = 2;
        int expectedValuePosition = 10;

        int valuePosition = BinarySearchWithShift.search(array, value);

        assertEquals(valuePosition, expectedValuePosition);
    }

    @Test
    void givenShiftOnTheRightValueOnTheLeft_whenSearchValue_thenReturnsValue() {
        int[] array = new int[]{6, 8, 10, 14, 16, 24, 45, 78, 89, 1, 2, 4};
        int value = 16;
        int expectedValuePosition = 4;

        int valuePosition = BinarySearchWithShift.search(array, value);

        assertEquals(valuePosition, expectedValuePosition);
    }

    @Test
    void givenShiftOnTheLeftValueOnTheLeft_whenSearchValue_thenReturnsValue() {
        int[] array = new int[]{24, 45, 78, 89, 1, 2, 4, 6, 8, 10, 14, 16};
        int value = 45;
        int expectedValuePosition = 1;

        int valuePosition = BinarySearchWithShift.search(array, value);

        assertEquals(valuePosition, expectedValuePosition);
    }

    @Test
    void givenShiftOnTheLeftValueOnTheRight_whenSearchValue_thenReturnsValue() {
        int[] array = new int[]{24, 45, 78, 89, 1, 2, 4, 6, 8, 10, 14, 16};
        int value = 8;
        int expectedValuePosition = 8;

        int valuePosition = BinarySearchWithShift.search(array, value);

        assertEquals(valuePosition, expectedValuePosition);
    }

    @Test
    void givenShiftOnTheMiddleValueOnTheRight_whenSearchValue_thenReturnsValue() {
        int[] array = new int[]{16, 24, 45, 78, 89, 92, 1, 2, 4, 6, 8, 10, 14};
        int value = 2;
        int expectedValuePosition = 7;

        int valuePosition = BinarySearchWithShift.search(array, value);

        assertEquals(valuePosition, expectedValuePosition);
    }

    @Test
    void givenShiftOnTheMiddleValueOnTheLeft_whenSearchValue_thenReturnsValue() {
        int[] array = new int[]{16, 24, 45, 78, 89, 92, 1, 2, 4, 6, 8, 10, 14};
        int value = 92;
        int expectedValuePosition = 5;

        int valuePosition = BinarySearchWithShift.search(array, value);

        assertEquals(valuePosition, expectedValuePosition);
    }

    @Test
    void givenShiftOnTheMiddleValueOnTheMiddle_whenSearchValue_thenReturnsValue() {
        int[] array = new int[]{16, 24, 45, 78, 89, 92, 1, 2, 4, 6, 8, 10, 14};
        int value = 1;
        int expectedValuePosition = 6;

        int valuePosition = BinarySearchWithShift.search(array, value);

        assertEquals(valuePosition, expectedValuePosition);
    }

    @Test
    void givenNullArray_whenSearchValue_thenExceptionOccurred() {
        assertThrows(IllegalArgumentException.class, () -> BinarySearchWithShift.search(null, 0));
    }

    @Test
    void givenEmptyArray_whenSearchValue_thenExceptionOccurred() {
        assertThrows(IllegalArgumentException.class, () -> BinarySearchWithShift.search(new int[0], 0));
    }
}