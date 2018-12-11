package yudong80.rxriddles;

import io.reactivex.Single;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class Riddle14Test {
    private Object unit = new Object();

    @Test public void success() {
        new Riddle14().solve(Single.just(unit))
                .test()
                .assertResult(unit);
    }

    @Test public void retriesOnlyThreeTimes() {
        AtomicInteger subscribeCounter = new AtomicInteger(0);
        new Riddle14().solve(Single.fromCallable(() -> {
            subscribeCounter.getAndIncrement();
            throw new UnsupportedOperationException();
        }))
                .test()
                .assertFailure(UnsupportedOperationException.class);

        assertThat(subscribeCounter.get()).isEqualTo(3);
    }

    @Test public void valueAtSecond() {
        AtomicInteger subscribeCounter = new AtomicInteger(0);
        new Riddle14().solve(Single.fromCallable(() -> {
            if (subscribeCounter.getAndIncrement() == 1) {
                return unit;
            } else {
                throw new UnsupportedOperationException();
            }
        })).test()
           .assertResult(unit);

        assertThat(subscribeCounter.get()).isEqualTo(2);
    }
}
