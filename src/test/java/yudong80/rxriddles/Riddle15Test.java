package yudong80.rxriddles;

import io.reactivex.Observable;
import io.reactivex.observers.TestObserver;
import org.junit.Rule;
import org.junit.Test;
import yudong80.rxriddles.tools.RxRule;

import java.util.concurrent.atomic.AtomicInteger;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.assertj.core.api.Java6Assertions.assertThat;

public class Riddle15Test {
    @Rule public RxRule rxRule = new RxRule();

    @Test public void solve() {
        AtomicInteger subscribeCounter = new AtomicInteger();

        Observable<Integer> first = Observable.timer(1, SECONDS)
                .doOnSubscribe(ig -> subscribeCounter.incrementAndGet())
                .map(ig -> 1);

        Observable<Integer> second = Observable.just(5)
                .doOnSubscribe(ig -> subscribeCounter.incrementAndGet());

        TestObserver<Integer> o = new Riddle15().solve(first, second)
                .test()
                .assertEmpty();

        assertThat(subscribeCounter.get()).isEqualTo(2);

        rxRule.advanceTimeBy(1, SECONDS);
        o.assertResult(1, 5);
    }
}
