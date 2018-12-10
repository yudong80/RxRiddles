package yudong80.rxriddles;

import io.reactivex.Observable;

public class Riddle1 {
    public Observable<Integer> solve(int value) {
        return Observable.just(value);
    }
}
