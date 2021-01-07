package examples.task;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParenthesisSequenceTest {

    private ParenthesisSequence checker;

    @BeforeEach
    public void setUp() {
        checker = new ParenthesisSequence();
    }

    @Test
    public void givenBalancedOrdered_whenExecuted_thenResultTrue() {
        final boolean balanced = checker.isBalanced("{}()[]");

        assertTrue(balanced);
    }

    @Test
    public void givenBalancedIncluded_whenExecuted_thenResultTrue() {
        final boolean balanced = checker.isBalanced("{([]())}");

        assertTrue(balanced);
    }

    @Test
    public void givenOddString_whenExecuted_thenResultFalse() {
        final boolean balanced = checker.isBalanced("{[]");

        assertFalse(balanced);
    }

    @Test
    public void givenNotBalanced_whenExecuted_thenResultFalse() {
        final boolean balanced = checker.isBalanced("({[}])");

        assertFalse(balanced);
    }

    @Test
    public void givenNull_whenExecuted_thenExceptionOccurs() {
        assertThrows(IllegalArgumentException.class, () -> checker.isBalanced(null));
    }

    @Test
    public void givenEmpty_whenExecuted_thenResultTrue() {
        final boolean balanced = checker.isBalanced("");

        assertTrue(balanced);
    }
}