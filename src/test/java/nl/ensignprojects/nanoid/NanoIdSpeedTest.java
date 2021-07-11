package nl.ensignprojects.nanoid;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.security.SecureRandom;

import static nl.ensignprojects.nanoid.TestHelper.NUMBER_OF_REPETITIONS;
import static nl.ensignprojects.nanoid.TestHelper.runTest;

class NanoIdSpeedTest {

    @RepeatedTest(NUMBER_OF_REPETITIONS)
    @DisplayName("NanoId implementation")
    void testImplementationsMy() {
        new SecureRandom();
        runTest(i -> NanoId.randomNanoId());
    }

}
