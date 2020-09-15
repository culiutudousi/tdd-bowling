import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BowlingGame {

    public int calculateScore(int[] throwScores) {
        List<Integer> throwScoresList = Arrays.stream(throwScores).boxed().collect(Collectors.toList());
        List<List<Integer>> frames = splitScoresIntoFrames(throwScoresList);
        return calculateScoreOfFrames(frames).intValue();
    }

    private Integer calculateScoreOfFrames(List<List<Integer>> frames) {
        Integer score = 0;
        lengthenFramesTo(frames, 12);
        for (int i = 0; i < 10; i++) {
            score += calculateScoreOfFrame(frames.get(i), frames.get(i + 1), frames.get(i + 2));
        }
        return score;
    }

    private Integer getSumOfFirstPins(List<Integer> frame, List<Integer> nextFrame, Integer pinsNumber) {
        return Stream.concat(frame.stream(), nextFrame.stream())
                .limit(pinsNumber)
                .reduce(0, Integer::sum);
    }

    private void lengthenFramesTo(List<List<Integer>> frames, Integer number) {
        if (frames.size() < number) {
            int numberOfEmptyToAdd = number - frames.size();
            for (int i = 0; i < numberOfEmptyToAdd; i++) {
                frames.add(Arrays.asList(0));
            }
        }
    }

    private Integer calculateScoreOfFrame(List<Integer> frame, List<Integer> nextFrame, List<Integer> frameAfterNext) {
        Integer score = calculatePinOfFrame(frame);
        if (isStrike(frame)) {
            return score + getSumOfFirstPins(nextFrame, frameAfterNext, 2);
        }
        if (isSpare(frame)) {
            return score + getSumOfFirstPins(nextFrame, frameAfterNext, 1);
        }
        return score;
    }

    private Boolean isStrike(List<Integer> frame) {
        return frame.get(0) == 10;
    }

    private Boolean isSpare(List<Integer> frame) {
        return frame.get(0) + frame.get(1) == 10;
    }

    private Integer calculatePinOfFrame(List<Integer> frame) {
        return frame.stream().reduce(0, Integer::sum);
    }

    private List<List<Integer>> splitScoresIntoFrames(List<Integer> scores) {
        List<List<Integer>> frames = new ArrayList<>();
        List<Integer> frame = new ArrayList<>();
        for (Integer score : scores) {
            frame.add(score);
            if (doesFrameFinish(frame)) {
                frames.add(frame.stream().collect(Collectors.toList()));
                frame.clear();
            }
        }
        return frames;
    }

    private Boolean doesFrameFinish(List<Integer> frame) {
        if (isStrike(frame) || frame.size() == 2) {
            return true;
        }
        return false;
    }
}
