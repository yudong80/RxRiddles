package yudong80.rxriddles;

import io.reactivex.Observable;
import org.junit.Test;

public class Riddle13Test {
    @Test public void solve() {
        new Riddle13().solve(Observable.just(1, 2, 1, 1, 4, 4, 4, 5, 4))
                .test()
                .assertResult(1, 2, 1, 4, 5, 4);
    }
}
