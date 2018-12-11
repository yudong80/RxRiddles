package yudong80.rxriddles;

import io.reactivex.Observable;

import java.util.Arrays;

public class Riddle15 {
    public Observable<Integer> solve(Observable<Integer> first, Observable<Integer> second) {
        return Observable.concatEager(Arrays.asList(first, second));
    }
}
