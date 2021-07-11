package nl.ensignprojects.nanoid;

/**
 * An exception that should be thrown if an illegal parameter has been used
 */
public class NanoIdIllegalInputException extends RuntimeException {

    /**
     * Constructs a new runtime exception with the specified detail message.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public NanoIdIllegalInputException(String message) {
        super(message);
    }
}
