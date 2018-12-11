package yudong80.rxriddles;

import io.reactivex.observers.TestObserver;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.SingleSubject;
import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class Riddle16Test {
    @Test public void solve() {
        PublishSubject<String> subject = PublishSubject.create();

        SingleSubject<Integer> inner1 = SingleSubject.create();
        SingleSubject<Integer> inner2 = SingleSubject.create();

        TestObserver<Integer> o = new Riddle16().solve(subject, it -> {
            if (it == "1") {
                return inner1;
            } else {
                return inner2;
            }
        }).test().assertEmpty();

        subject.onNext("1");
        o.assertEmpty();
        assertThat(inner1.hasObservers()).isTrue();

        subject.onNext("2");
        assertThat(inner1.hasObservers()).isFalse();
        assertThat(inner2.hasObservers()).isTrue();

        inner2.onError(new RuntimeException());
        assertThat(subject.hasObservers()).isFalse();
        o.assertFailure(RuntimeException.class);
    }
}
