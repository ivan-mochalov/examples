package examples.task;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParenthesisSequenceTest {

    private ParenthesisSequence target;

    @BeforeEach
    void setUp() {
        target = new ParenthesisSequence();
    }

    @Test
    void givenBalancedOrdered_whenExecuted_thenResultTrue() {
        final boolean balanced = target.isBalanced("{}()[]");

        assertTrue(balanced);
    }

    @Test
    void givenBalancedIncluded_whenExecuted_thenResultTrue() {
        final boolean balanced = target.isBalanced("{([]())}");

        assertTrue(balanced);
    }

    @Test
    void givenOddString_whenExecuted_thenResultFalse() {
        final boolean balanced = target.isBalanced("{[]");

        assertFalse(balanced);
    }

    @Test
    void givenNotBalanced_whenExecuted_thenResultFalse() {
        final boolean balanced = target.isBalanced("({[}])");

        assertFalse(balanced);
    }

    @Test
    void givenNull_whenExecuted_thenExceptionOccurs() {
        assertThrows(IllegalArgumentException.class, () -> target.isBalanced(null));
    }

    @Test
    void givenEmpty_whenExecuted_thenResultTrue() {
        final boolean balanced = target.isBalanced("");

        assertTrue(balanced);
    }
}