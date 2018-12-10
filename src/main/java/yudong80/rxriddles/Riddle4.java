package yudong80.rxriddles;

import io.reactivex.Observable;

public class Riddle4 {
    public Observable<Boolean> solve(Observable<Object> source) {
        return source.scan(false, (v1, v2) -> !v1);
    }
}
