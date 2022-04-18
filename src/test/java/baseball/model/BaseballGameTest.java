package baseball.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballGameTest {
    private static final List<Integer> numberList = Arrays.asList(1,2,3,4,5,6,7,8,9);

    @Test
    @DisplayName("야구 게임 객체가 잘 생성될까")
    public void boostrapTest() {
        BaseballGame game = BaseballGame.bootstrap(numberList);

        assertNotNull(game);
    }

    @Test
    @DisplayName("정답 갯수 가져와보기")
    public void playTest() {
        BaseballGame game = BaseballGame.bootstrap(numberList);

        int count = game.getAnswerCountByInputs(Arrays.asList(4,2,3));

        assertTrue(count >= 0);
        assertTrue(count < 3);
    }
}