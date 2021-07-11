package nl.ensignprojects.nanoid;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class AlphabetTest {

    @Test
    @DisplayName("attempt to create an alphabet with repeating characters")
    void alphabetMustConsistWithUniqueChars() {
        assertThrows(NanoIdIllegalInputException.class, () -> new Alphabet("abacafaeajadavazea".toCharArray()));
    }

    @Test
    @DisplayName("attempt to create an alphabet from null")
    void alphabetCreationFromNull() {
        assertThrows(NanoIdIllegalInputException.class, () -> new Alphabet(null));
    }

    @Test
    @DisplayName("attemtp to create an alphabet from 0 chars")
    void alphabetZeroCharsGivesException() {
        assertThrows(NanoIdIllegalInputException.class, () -> new Alphabet(new char[]{}));
    }

    @Test
    @DisplayName("attenpt to create an alphabet from more than 255 chars")
    void alphabetIsTooBigGivesException() {
        char[] alphabet = "1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111".toCharArray();
        assertThrows(NanoIdIllegalInputException.class, () -> new Alphabet(alphabet));
    }
}