package yudong80.rxriddles;

import io.reactivex.Single;

public class Riddle14 {
    public Single<Object> solve(Single<Object> source) {
        return source.retry(2);
    }
}
