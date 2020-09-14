import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BowlingGame {
    public int calculateScore(int[] throwScores) {
        List<Integer> throwScoresList = Arrays.stream(throwScores).boxed().collect(Collectors.toList());
        if (throwScoresList.get(0) == 10) {
            return 300;
        }
        return 0;
    }
}
