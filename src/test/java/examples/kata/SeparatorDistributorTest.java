package examples.kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SeparatorDistributorTest {

    @Test
    void givenNullInput_whenCalled_thenException() {
        assertThrows(IllegalArgumentException.class, () -> SeparatorDistributor.format(null));
    }

    @Test
    void givenEmptyInput_whenCalled_thenException() {
        assertThrows(IllegalArgumentException.class, () -> SeparatorDistributor.format(""));
    }

    @Test
    void givenInputWithOnlyLetter_whenCalled_thenException() {
        assertThrows(IllegalArgumentException.class, () -> SeparatorDistributor.format("_a_"));
    }

    @Test
    void givenInputWithoutLeadingSeparator_whenCalled_thenException() {
        assertThrows(IllegalArgumentException.class, () -> SeparatorDistributor.format("abcd_"));
    }

    @Test
    void givenInputWithoutFollowingSeparator_whenCalled_thenException() {
        assertThrows(IllegalArgumentException.class, () -> SeparatorDistributor.format("_abcd"));
    }

    @Test
    void givenLeadingAndFollowingSeparators_whenFormatted_thenSeparatorsAlternatedFromLeft() {
        String result = SeparatorDistributor.format("_abcabc_");

        assertEquals("a_b_cabc", result);
    }

    @Test
    void givenSeparatorsLessThanLetters_whenFormatted_thenSeparatorsAlternatedFromLeft() {
        String result = SeparatorDistributor.format("_abc__abc_");

        assertEquals("a_b_c_a_bc", result);
    }

    @Test
    void givenSeparatorsMoreThanLetters_whenFormatted_thenSeparatorsDistributedFromLeft() {
        String result = SeparatorDistributor.format("_abc_____abc_");

        assertEquals("a__b__c_a_b_c", result);
    }

    @Test
    void givenSeparatorsMuchMoreThanLetters_whenFormatted_thenSeparatorsDistributedFromLeft() {
        String result = SeparatorDistributor.format("_abc_________________________abc_");

        assertEquals("a______b______c_____a_____b_____c", result);
    }
}
