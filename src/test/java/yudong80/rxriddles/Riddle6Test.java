package yudong80.rxriddles;

import io.reactivex.Single;
import io.reactivex.observers.TestObserver;
import javafx.util.Pair;
import org.junit.Rule;
import org.junit.Test;
import yudong80.rxriddles.tools.RxRule;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class Riddle6Test {
    @Rule public RxRule rxRule = new RxRule();

    @Test public void solve() {
        AtomicInteger subscribeCounter = new AtomicInteger();

        Single<Integer> first = Single.timer(5, TimeUnit.SECONDS, rxRule)
                .map(v -> 10)
                .doOnSubscribe( v-> subscribeCounter.incrementAndGet());

        Single<Integer> second = Single.just(5)
                .doOnSubscribe( v-> subscribeCounter.incrementAndGet());

        TestObserver<Pair<Integer, Integer>> o = new Riddle6().solve(first, second)
                .test()
                .assertEmpty();

        assertThat(subscribeCounter.get()).isEqualTo(2);

        rxRule.advanceTimeBy(4, TimeUnit.SECONDS);
        o.assertEmpty();

        rxRule.advanceTimeBy(1, TimeUnit.SECONDS);
        o.assertResult(new Pair(10, 5));
    }
}
