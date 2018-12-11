package yudong80.rxriddles;

import io.reactivex.Observable;

public class Riddle13 {
    public Observable<Integer> solve(Observable<Integer> source) {
        return source.distinctUntilChanged();
    }
}
