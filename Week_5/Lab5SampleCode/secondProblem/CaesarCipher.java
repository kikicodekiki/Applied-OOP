package Week_5.Lab5SampleCode.secondProblem;

public class CaesarCipher {
    private int shiftLength;
    private final char CAPITAL_LETTER_A = 'A';

    public CaesarCipher(int shiftLength) {
        setShiftLength(shiftLength);
    }

    public int getShiftLength() {
        return shiftLength;
    }

    public void setShiftLength(int shiftLength) {
        // setting the default value to 3
        this.shiftLength = shiftLength > 0 ? shiftLength % 26 : 3;
    }

    public String encrypt(String plainText) {
        char[] symbols = plainText.toCharArray(); // converting the string to a simple char array

        for (int i = 0; i < symbols.length; i++) {
            symbols[i] = (char)( (symbols[i] + shiftLength - CAPITAL_LETTER_A) % 26 + CAPITAL_LETTER_A);
        }

        return new String(symbols);
    }

    public String decrypt(String cipherText) {
        char[] symbols = cipherText.toCharArray();

        for (int i = 0; i < symbols.length; i++) {
            symbols[i] = (char)( (symbols[i] - shiftLength + 26 - CAPITAL_LETTER_A) % 26 + CAPITAL_LETTER_A);
        }

        return new String(symbols);
    }
}
