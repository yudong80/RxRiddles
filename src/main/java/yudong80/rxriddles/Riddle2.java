package yudong80.rxriddles;

import io.reactivex.Observable;

public class Riddle2 {
    public Observable<Integer> solve(Observable<Integer> source) {
        return source.map(v -> v+1);
    }
}
