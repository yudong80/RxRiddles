package yudong80.rxriddles;

import io.reactivex.observers.TestObserver;
import io.reactivex.subjects.PublishSubject;
import org.junit.Test;

public class Riddle4Test {
    @Test public void solve() {
        PublishSubject<Object> subject = PublishSubject.create();

        TestObserver<Boolean> o = new Riddle4().solve(subject)
                .test()
                .assertValuesOnly(false);

        subject.onNext(new Object());
        o.assertValuesOnly(false, true);

        subject.onNext(new Object());
        o.assertValuesOnly(false, true, false);

        subject.onNext(new Object());
        o.assertValuesOnly(false, true, false, true);
    }
}
