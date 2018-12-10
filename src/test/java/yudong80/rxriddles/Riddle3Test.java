package yudong80.rxriddles;

import io.reactivex.Observable;
import org.junit.Test;

public class Riddle3Test {
    @Test public void solve() {
        new Riddle3().solve(Observable.range(0,10))
                .test()
                .assertResult(0, 2, 4, 6, 8);
    }
}
