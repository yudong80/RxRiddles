package yudong80.rxriddles;

import io.reactivex.Single;
import javafx.util.Pair;

public class Riddle6 {
    public Single<Pair<Integer, Integer>> solve(Single<Integer> first,
                                                Single<Integer> second) {
        return Single.zip(first, second, (v1, v2) -> new Pair(v1, v2));
    }
}
