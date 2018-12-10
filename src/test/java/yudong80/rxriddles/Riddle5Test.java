package yudong80.rxriddles;

import io.reactivex.observers.TestObserver;
import io.reactivex.subjects.BehaviorSubject;
import org.junit.Test;

public class Riddle5Test {
    @Test public void solve() {
        BehaviorSubject<Integer> first = BehaviorSubject.createDefault(0);
        BehaviorSubject<Integer> second = BehaviorSubject.createDefault(0);

        TestObserver<Integer> o = new Riddle5().solve(first, second)
                .test()
                .assertValuesOnly(0);

        first.onNext(5);
        o.assertValuesOnly(0, 5);

        second.onNext(6);
        o.assertValuesOnly(0, 5, 11);

        first.onNext(-6);
        o.assertValuesOnly(0, 5, 11, 0);
    }
}
