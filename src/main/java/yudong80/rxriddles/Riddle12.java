package yudong80.rxriddles;

import io.reactivex.Observable;

public class Riddle12 {
    public Observable<Integer> solve(Observable<Integer> source) {
        return source.onErrorReturnItem(5);
    }
}
