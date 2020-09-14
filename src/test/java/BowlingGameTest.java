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
    void should_return_0_when_all_throw_are_0() {
        int[] throwScores = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int score = bowlingGame.calculateScore(throwScores);
        assertEquals(0, score);
    }
}
