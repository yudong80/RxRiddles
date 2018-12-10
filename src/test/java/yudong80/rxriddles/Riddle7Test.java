package yudong80.rxriddles;

import io.reactivex.Observable;
import org.junit.Test;

public class Riddle7Test {
    @Test public void solve() {
        new Riddle7().solve(Observable.just(1,2,3,1,2,4,4,5,4))
                .test()
                .assertResult(1,2,3,4,5);
    }
}
