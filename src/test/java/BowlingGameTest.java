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
}
