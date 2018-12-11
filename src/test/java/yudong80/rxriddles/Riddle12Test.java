package yudong80.rxriddles;

import io.reactivex.Observable;
import org.junit.Test;

public class Riddle12Test {
    @Test public void solve() {
        new Riddle12().solve(Observable.create(it -> {
            it.onNext(1);
            it.onNext(2);
            it.onError(new RuntimeException());
        })).test()
           .assertResult(1, 2, 5);
    }
}
