package yudong80.rxriddles;

import io.reactivex.Observable;

public class Riddle7 {
    public Observable<Integer> solve(Observable<Integer> source) {
        return source.distinct();
    }
}
