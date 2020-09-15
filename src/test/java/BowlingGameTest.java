import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BowlingGameTest {

    BowlingGame bowlingGame;

    @BeforeEach
    void set_up() {
        bowlingGame = new BowlingGame();
    }

    @Test
    void should_return_0_given_all_throw_are_0() {
        int[] throwScores = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int score = bowlingGame.calculateScore(throwScores);
        assertEquals(0, score);
    }

    @Test
    void should_return_300_given_all_throw_are_strike() {
        int[] throwScores = new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        int score = bowlingGame.calculateScore(throwScores);
        assertEquals(300, score);
    }
    @Test
    void should_return_sum_given_no_strike_nor_spare() {
        int[] throwScores = new int[]{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
        int score = bowlingGame.calculateScore(throwScores);
        assertEquals(60, score);
    }

    @Test
    void should_return_spare_with_next_pins_given_spares_with_last_that_no_strike_nor_spare() {
        int[] throwScores = new int[]{1, 9, 2, 8, 3, 7, 4, 6, 5, 5, 6, 4, 7, 3, 8, 2, 9, 1, 3, 3};
        int score = bowlingGame.calculateScore(throwScores);
        assertEquals(143, score);
    }

    @Test
    void should_return_strike_with_next_two_pins_given_strikes_with_last_that_no_strike_nor_spare() {
        int[] throwScores = new int[]{10, 10, 10, 4, 6, 5, 5, 10, 7, 3, 8, 2, 9, 1, 3, 3};
        int score = bowlingGame.calculateScore(throwScores);
        assertEquals(185, score);
    }

    @Test
    void should_return_strike_with_next_two_pins_given_with_strike_last() {
        int[] throwScores = new int[]{10, 10, 10, 4, 6, 5, 5, 10, 7, 3, 8, 2, 9, 1, 10, 10, 10};
        int score = bowlingGame.calculateScore(throwScores);
        assertEquals(216, score);
    }

    @Test
    void should_return_spare_with_next_pins_given_with_spare_last() {
        int[] throwScores = new int[]{10, 10, 10, 4, 6, 5, 5, 10, 7, 3, 8, 2, 9, 1, 0, 10, 10};
        int score = bowlingGame.calculateScore(throwScores);
        assertEquals(196, score);
    }
}
