package yudong80.rxriddles;

import io.reactivex.Observable;

public class Riddle3 {
    public Observable<Integer> solve(Observable<Integer> source) {
        return source.filter( v -> v % 2 == 0);
    }
}
