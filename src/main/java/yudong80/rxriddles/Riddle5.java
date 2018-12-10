package yudong80.rxriddles;

import io.reactivex.Observable;

public class Riddle5 {
    public Observable<Integer> solve(Observable<Integer> first,
                                     Observable<Integer> second) {
        return Observable.combineLatest(
                first,
                second,
                (v1, v2) -> v1 + v2);
    }
}
