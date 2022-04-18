package baseball.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;

public class BaseballGame {
    private final List<Integer> randoms;

    private BaseballGame(List<Integer> randoms) {
        this.randoms = randoms;
    }

    public static BaseballGame bootstrap(List<Integer> range) {
        List<Integer> nonDuplicatedList = new ArrayList<>();
        for (int i = 0; i < 3; i += 1) {
            Integer pick = Randoms.pickNumberInList(range);
            nonDuplicatedList.add(pick);
            range = range.stream().filter(item -> !Objects.equals(item, pick)).collect(Collectors.toList()); // 한번 선택된 값 제거
        }
        return new BaseballGame(nonDuplicatedList);
    }

    public int getAnswerCountByInputs(List<Integer> inputs) {
        AtomicInteger count = new AtomicInteger();
        this.randoms.forEach(random -> {
            if (inputs.stream().anyMatch(input -> input.equals(random))) {
                count.addAndGet(1);
            }
        });

        return count.get();
    }
}
