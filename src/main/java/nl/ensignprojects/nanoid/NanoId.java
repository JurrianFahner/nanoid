package nl.ensignprojects.nanoid;

import java.security.SecureRandom;
import java.util.function.Function;

/**
 * Class capable to generate {@link NanoId}
 */
public class NanoId {
    private static final SecureRandom RANDOM_GENERATOR = new SecureRandom();
    private static final Alphabet URL_ALPHABET = Alphabet.urlSafe();
    private static final Function<Integer, byte[]> DEFAULT_RANDOM_GENERATOR = byteNumber -> {
        var randomBytes = new byte[byteNumber];
        RANDOM_GENERATOR.nextBytes(randomBytes);
        return randomBytes;
    };

    /**
     * Generates nanoid with defaults
     *
     * @return {@link String} representation of a {@link NanoId}
     */
    public static String randomNanoId() {
        return randomNanoId(21);
    }

    /**
     * Generates nanoid
     *
     * @param size length of the nanoid to return
     * @return {@link String} representation of a {@link NanoId}
     */
    public static String randomNanoId(int size) {
        return randomNanoId(size, URL_ALPHABET);
    }

    /**
     * Generates nanoid
     *
     * @param size     length of the nanoid to return
     * @param alphabet an alphabet to choose the letters from
     * @return {@link String} representation of a {@link NanoId}
     */
    public static String randomNanoId(int size, Alphabet alphabet) {
        return randomNanoId(size, alphabet, DEFAULT_RANDOM_GENERATOR);
    }

    /**
     * Generates nanoid
     *
     * @param size                 length of the nanoid to return
     * @param alphabet             an alphabet to choose the letters from
     * @param randomBytesGenerator specifies a generator to generate random bytes
     * @return {@link String} representation of a {@link NanoId}
     * @throws NanoIdIllegalInputException     when size is lower than 0 or alphabet is not provided
     * @throws RandomGeneratorMissingException when random generator has not been provided.
     */
    public static String randomNanoId(int size, Alphabet alphabet, Function<Integer, byte[]> randomBytesGenerator) {

        if (randomBytesGenerator == null) {
            throw new RandomGeneratorMissingException();
        }

        if (alphabet == null) {
            throw new NanoIdIllegalInputException("alphabet not provided");
        }

        if (size < 0) {
            throw new NanoIdIllegalInputException("size must be greater than 0");
        }

        var randomBytes = randomBytesGenerator.apply(size);

        var builder = new StringBuilder(size);

        for (byte randomByte : randomBytes) {
            var aChar = alphabet.resolveChar(randomByte);
            builder.append(aChar);
        }

        return builder.toString();
    }

}
