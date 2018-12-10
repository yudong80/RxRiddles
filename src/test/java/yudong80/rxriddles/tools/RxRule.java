package yudong80.rxriddles.tools;

import io.reactivex.Scheduler;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.TestScheduler;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import java.util.concurrent.TimeUnit;

public class RxRule extends Scheduler implements TestRule {

    private TestScheduler testScheduler = new TestScheduler();

    @Override
    public Statement apply(Statement base, Description description) {
        // Override all of the default schedulers so we can use our testScheduler when testing.
        RxJavaPlugins.setComputationSchedulerHandler ( v -> testScheduler );
        RxJavaPlugins.setIoSchedulerHandler ( v -> testScheduler );
        RxJavaPlugins.setSingleSchedulerHandler ( v -> testScheduler );
        RxJavaPlugins.setNewThreadSchedulerHandler ( v -> testScheduler );
        return base;
    }

    @Override
    public Worker createWorker() {
        return testScheduler.createWorker();
    }

    public void advanceTimeBy(long delayTime, TimeUnit unit) {
        testScheduler.advanceTimeBy(delayTime, unit);
    }

    public void triggerAction() {
        testScheduler.triggerActions();
    }
}
