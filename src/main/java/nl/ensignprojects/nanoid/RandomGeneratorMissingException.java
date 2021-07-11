package nl.ensignprojects.nanoid;

/**
 * An {@link RuntimeException} that will be thrown when no random generator has been specified
 */
public class RandomGeneratorMissingException extends RuntimeException {
    /**
     * Constructor
     */
    public RandomGeneratorMissingException() {
        super("no random generator specified");
    }
}
