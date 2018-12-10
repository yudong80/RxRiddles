package yudong80.rxriddles;

import org.junit.Test;

public class Riddle1Test {
    @Test public void solve() {
        new Riddle1().solve(5)
                .test()
                .assertResult(5);
    }
}
