package yudong80.rxriddles;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Function;

public class Riddle16 {
    public Observable<Integer> solve(Observable<String> first, Function<String, Single<Integer>> function) {
        return first.switchMapSingle(function);
    }
}
