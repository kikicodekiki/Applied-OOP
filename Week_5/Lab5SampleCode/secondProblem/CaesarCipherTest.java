package Week_5.Lab5SampleCode.secondProblem;

public class CaesarCipherTest {
    public static void main(String[] args) {
        CaesarCipher test = new CaesarCipher(3);

        System.out.printf("Encrypted text: %s",test.encrypt("HELLO"));
        System.out.printf("%nDecrypted text: %s" ,test.decrypt(test.encrypt("HELLO")));

    }
}
