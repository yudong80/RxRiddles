package yudong80.rxriddles;

import io.reactivex.Observable;
import org.junit.Test;

public class Riddle2Test {
    @Test public void solve() {
        new Riddle2().solve(Observable.just(-1, 0, 5))
                .test()
                .assertResult(0, 1, 6);
    }
}
