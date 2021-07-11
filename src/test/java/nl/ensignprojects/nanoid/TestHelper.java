package nl.ensignprojects.nanoid;

import java.time.Duration;
import java.time.Instant;
import java.util.function.Function;
import java.util.stream.IntStream;

public interface TestHelper {
    int NUMBER_OF_REPETITIONS = 100;
    int NUMBER_OF_ITERATIONS = 30_000;
    double NUMBER_OF_NANOS_IN_SECOND = 1_000_000_000.0;

    static void runTest(Function<Integer, String> algorithm) {
        var start = Instant.now();
        IntStream.range(0, NUMBER_OF_ITERATIONS)
                .forEach(algorithm::apply);
        var end = Instant.now();

        var duration = Duration.between(start, end);
        var durationInSec = duration.toNanos() / NUMBER_OF_NANOS_IN_SECOND;
        var opsPerSecond = Math.floor(NUMBER_OF_ITERATIONS / durationInSec);
        System.out.println(opsPerSecond);
    }
}
