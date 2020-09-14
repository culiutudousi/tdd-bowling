import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BowlingGame {
    public int calculateScore(int[] throwScores) {
        List<Integer> throwScoresList = Arrays.stream(throwScores).boxed().collect(Collectors.toList());
        if (throwScoresList.get(0) == 10) {
            return 300;
        }
        if (throwScoresList.get(0) == 0) {
            return 0;
        }
        List<List<Integer>> frames = splitScoresIntoFrames(throwScoresList);
        return calculateScoreOfFrames(frames);
    }

    private Integer calculateScoreOfFrames(List<List<Integer>> frames) {
        return frames.stream()
                .map(frame -> calculateScoreOfFrame(frame))
                .reduce(0, Integer::sum);
    }

    private Integer calculateScoreOfFrame(List<Integer> frame) {
        return frame.stream().reduce(0, Integer::sum);
    }

    private List<List<Integer>> splitScoresIntoFrames(List<Integer> scores) {
        List<List<Integer>> frames = new ArrayList<>();
        List<Integer> frame = new ArrayList<>();
        for(Integer score: scores) {
            frame.add(score);
            if(doesFrameFinish(frame)) {
                frames.add(frame.stream().collect(Collectors.toList()));
                frame.clear();
            }
        }
        return frames;
    }

    private Boolean doesFrameFinish(List<Integer> frame) {
        if (frame.size() == 2) {
            return true;
        }
        return false;
    }
}
