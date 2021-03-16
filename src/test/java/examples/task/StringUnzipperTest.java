package examples.task;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StringUnzipperTest {

    @Test
    void givenValidInput_whenCalled_thenReturnCorrectResult() {
        String result = StringUnzipper.unzip("3[xyz]4[xy]z");

        assertEquals("xyzxyzxyzxyxyxyxyz", result);
    }

    @Test
    void givenValidInputWithRepeatedNumbers_whenCalled_thenReturnCorrectResult() {
        String result = StringUnzipper.unzip("2[3[x]y]");

        assertEquals("xxxyxxxy", result);
    }

    @Test
    void givenNullInput_whenCalled_thenExceptionOccurred() {
        assertThrows(IllegalArgumentException.class, () -> StringUnzipper.unzip(null));
    }

    @Test
    void givenBlankInput_whenCalled_thenExceptionOccurred() {
        assertThrows(IllegalArgumentException.class, () -> StringUnzipper.unzip(""));
    }

    @Test
    void givenInvalidInput_whenCalled_thenExceptionOccurred() {
        assertThrows(IllegalArgumentException.class, () -> StringUnzipper.unzip("!23"));
    }

    @Test
    void givenDigitAtTheEndInput_whenCalled_thenExceptionOccurred() {
        assertThrows(IllegalArgumentException.class, () -> StringUnzipper.unzip("2[3[x]y]4"));
    }
}
