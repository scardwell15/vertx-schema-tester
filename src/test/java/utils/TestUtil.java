package utils;

import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.json.JsonObject;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import com.mycompany.vertxschematester.JsonValidationException;
import com.mycompany.vertxschematester.JsonValidator;
import static org.testng.Assert.fail;

public class TestUtil {
    /**
     * Waits for a CompletableFuture to finish. Will fail if the future times
     * out, or if an exception is returned by it.
     *
     * @param <R> Class of object
     * @param future future
     * @param time time
     * @param unit unit of time
     * @return the object that was given to the future
     */
    public static <R> R await(CompletableFuture<R> future, long time, TimeUnit unit) {
        try {
            return future.get(time, unit);
        } catch (TimeoutException ex) {
            fail("CompletableFuture timed out");
        } catch (Throwable th) {
            fail("CompletableFuture threw exception", th);
        }
        return null;
    }

    /**
     * Wraps a Vertx future. This method will force the future to run in sync
     * with the test, and timeout if it runs for more than 1 second.
     * Additionally, it will return the event that was completed.
     *
     * @param future future
     * @return the event that the future returns
     */
    public static <R> AsyncResult<R> waitForFuture(Future<R> future) {
        CompletableFuture<AsyncResult<R>> latchedFuture = new CompletableFuture<>();
        future.onComplete(event -> latchedFuture.complete((AsyncResult<R>) event));
        return await(latchedFuture, 1, TimeUnit.SECONDS);
    }

    /**
     * Asserts whether a schema is valid or invalid based on the invalid boolean
     * param
     *
     * @param validator
     * @param schema
     * @param validSchema
     */
    public static void assertSchema(JsonValidator validator, JsonObject schema, boolean validSchema) {
        try {
            validator.validate(schema);
            if(!validSchema) {
                fail("validation did not fail!");
            }
        } catch (JsonValidationException ex) {
            if(validSchema) {
                fail("validation did not succeed!", ex);
            }
        } catch (Throwable ex) {
            fail("failed to validate JSON!", ex);
        }
    }

}
