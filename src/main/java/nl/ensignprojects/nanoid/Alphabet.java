package nl.ensignprojects.nanoid;

import java.util.ArrayList;

/**
 * Alphabet contains the characters that will used to generate {@link NanoId}
 */
public class Alphabet {
    private final char[] alphabet;

    /**
     * Creates the {@link Alphabet} object
     *
     * @param alphabet char array containing the individual characters
     * @throws NanoIdIllegalInputException when char array is not properly defined
     */
    public Alphabet(char[] alphabet) {
        if (alphabet == null || alphabet.length == 0 || alphabet.length >= 256) {
            throw new NanoIdIllegalInputException("alphabet should be at least 1 and not greater than 255");
        }

        var characters = new ArrayList<Character>();
        for (Character c : alphabet) {
            characters.add(c);
        }
        var allDifferentChars = characters.stream().distinct().count();
        if (allDifferentChars != alphabet.length) {
            throw new NanoIdIllegalInputException("not all chars in alphabet are unique");
        }
        this.alphabet = alphabet;
    }

    /**
     * Resolves a character from alphabet
     *
     * @param randomByte a random byte
     * @return a char from the alphabet
     */
    public char resolveChar(byte randomByte) {
        var byteWithinAlphabetRange = randomByte & (alphabet.length - 1);
        return alphabet[byteWithinAlphabetRange];
    }

    /**
     * Creates a url safe alphabet
     *
     * @return {@link Alphabet} object
     */
    public static Alphabet urlSafe() {
        final char[] charArray = new char[]{'M', 'o', 'd', 'u', 'l', 'e', 'S', 'y', 'm', 'b', 'h', 'a', 's', 'O', 'w', 'n', 'P', 'r', '-', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'N', 'R', 'V', 'f', 'g', 'c', 't', 'i', 'U', 'v', 'z', '_', 'K', 'q', 'Y', 'T', 'J', 'k', 'L', 'x', 'p', 'Z', 'X', 'I', 'j', 'Q', 'W'};
        return new Alphabet(charArray);
    }
}
