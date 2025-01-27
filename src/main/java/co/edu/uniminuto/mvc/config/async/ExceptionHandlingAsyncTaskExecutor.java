package co.edu.uniminuto.mvc.config.async;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.task.AsyncTaskExecutor;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/**
 * Exception handling asynchronous task executor.
 */
@Slf4j
@RequiredArgsConstructor
public class ExceptionHandlingAsyncTaskExecutor implements AsyncTaskExecutor, InitializingBean, DisposableBean {

    /**
     * Task executor.
     */
    private final AsyncTaskExecutor executor;

    @Override
    public void destroy() throws Exception {
        if (executor instanceof DisposableBean) {
            DisposableBean bean = (DisposableBean) executor;
            bean.destroy();
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (executor instanceof InitializingBean) {
            InitializingBean bean = (InitializingBean) executor;
            bean.afterPropertiesSet();
        }
    }

    @Override
    public void execute(Runnable runnable, long startTimeout) {
        executor.execute(createWrappedRunnable(runnable), startTimeout);
    }

    @Override
    public Future<?> submit(Runnable runnable) {
        return executor.submit(createWrappedRunnable(runnable));
    }

    @Override
    public <T> Future<T> submit(Callable<T> callable) {
        return executor.submit(createCallable(callable));
    }

    @Override
    public void execute(Runnable runnable) {
        executor.execute(createWrappedRunnable(runnable));
    }

    /**
     * Creates a {@link Callable} instance from the defined {@link Callable} instance.
     *
     * @param callable the {@link Callable} task instance.
     * @param <T>      the type for {@link Callable}.
     * @return Callable of {@code T}.
     */
    private <T> Callable<T> createCallable(final Callable<T> callable) {
        return () -> {
            try {
                return callable.call();
            } catch (Exception e) {
                handle(e);
                throw e;
            }
        };
    }

    /**
     * Creates a {@link Runnable} instance for wrapped runnable task instance.
     *
     * @param runnable the {@link Runnable} task instance.
     * @return A runnable object for defined task.
     */
    private Runnable createWrappedRunnable(final Runnable runnable) {
        return () -> {
            try {
                runnable.run();
            } catch (Exception e) {
                handle(e);
            }
        };
    }

    /**
     * Handles the asynchronous exceptions and to register the trace in the log.
     *
     * @param e the exception to log.
     */
    protected void handle(Exception e) {
        log.error("Caught async exception", e);
    }

}
