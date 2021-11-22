package examples.kata;

import org.junit.jupiter.api.Test;

import static examples.kata.StringZipper.zipString;
import static org.junit.jupiter.api.Assertions.*;

class StringZipperTest {

    public static final String EMPTY_STRING = "";

    @Test
    void givenNullInput_whenZipString_thenExceptionOccurs() {
        assertThrows(IllegalArgumentException.class, () -> zipString(null));
    }

    @Test
    void givenEmptyInput_whenZipString_thenExceptionOccurs() {
        assertThrows(IllegalArgumentException.class, () -> zipString(EMPTY_STRING));
    }

    @Test
    void givenOneLetterString_whenZipString_thenStringReturnsBack() {
        String input = "A";

        String result = zipString(input);

        assertEquals(input, result);
    }

    @Test
    void givenStringWithUniqueLetters_whenZipString_thenReturnStringBack() {
        String input = "ABCDEF";

        String result = zipString(input);

        assertEquals(input, result);
    }

    @Test
    void givenStringWithNumberOfTheSameLetters_whenZipString_thenReturnCorrectValue() {
        String input = "AAAAAAAAAA";
        String expected = "A10";

        String result = zipString(input);

        assertEquals(expected, result);
    }

    @Test
    void givenStringWithManyDifferentLetters_whenZipString_thenReturnCorrectValue() {
        String input = "AABBBCDDDDEFGGGGGGGGHIJJKKLMNOPQQQQQRRRRRSSSSTTTTUUUUVWXYZZZ";
        String expected = "A2B3CD4EFG8HIJ2K2LMNOPQ5R5S4T4U4VWXYZ3";

        String result = zipString(input);

        assertEquals(expected, result);
    }
}
