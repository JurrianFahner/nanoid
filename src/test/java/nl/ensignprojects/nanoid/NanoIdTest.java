package nl.ensignprojects.nanoid;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NanoIdTest {

    @Test
    @DisplayName("Two separate generated NanoIds are different")
    void twoStringsGeneratedMustBeDifferent() {
        var first = NanoId.randomNanoId();
        var second = NanoId.randomNanoId();

        assertThat(first).isNotEqualTo(second);
    }

    @Test
    @DisplayName("length can be set")
    void lengthCanBeChanged() {
        var aNanoIdOfLength3 = NanoId.randomNanoId(3);
        var aNanoIdOfLength22 = NanoId.randomNanoId(22);

        assertThat(aNanoIdOfLength3).hasSize(3);
        assertThat(aNanoIdOfLength22).hasSize(22);
    }

    @Test
    @DisplayName("Change all defaults and make the outcome fixed")
    void changeAllDefaults() {

        int size = 22;
        var alphabet = new Alphabet("abcdef".toCharArray());

        Function<Integer, byte[]> notRandomGenerator = byteArraySize -> {
            var bytes = new byte[byteArraySize];
            for (int i = 0; i < bytes.length; i++) {
                bytes[i] = Integer.valueOf(i % 6).byteValue();
            }
            return bytes;
        };

        var result1 = NanoId.randomNanoId(22, alphabet, notRandomGenerator);

        assertThat(result1).isEqualTo("ababefababefababefabab");
    }

    @Test
    @DisplayName("negative size should give exception")
    void negativeSizeShouldGiveException() {
        assertThrows(NanoIdIllegalInputException.class, () -> NanoId.randomNanoId(-3));
    }

    @Test
    @DisplayName("alphabet not provided gives exception")
    void alphabetNotProvidedGivesException() {
        assertThrows(NanoIdIllegalInputException.class, () -> NanoId.randomNanoId(3, null));
    }

    @Test
    @DisplayName("missing random generator gives exception")
    void generatorIsMissing() {
        assertThrows(RandomGeneratorMissingException.class, () -> NanoId.randomNanoId(123, null, null));
    }
}