package Homeworks.Homework_4.HammingDistance.src.hamming;

public class HammingDist {
    public static int getDistance(byte a, byte b) {
        // because bytes are signed => using the Byte.toUnsignedInt() method
        // to prevent problems
        // then doing an XOR operation to see the number of numbers that differ (0 if they are the same)
        int aU = Byte.toUnsignedInt(a);
        int bU = Byte.toUnsignedInt(b);
        int diff = aU ^ bU;

        int res = 0;

        for(int i = 0; i < 8; i++) {
            // iterate over all bits
            int mask = diff >> i; // so as to extract the rightmost bit
            // at each iteration and check if it is a 1 -> if it is => add to the count
            // because that means that the numbers were in fact different
            res += (mask & 1);
        }

        return res;
    }

    public static String toBinary(byte num) {
        int val = Byte.toUnsignedInt(num);
        StringBuilder sb = new StringBuilder(8); // creating a new 8-char string
        int mask = 1 << 7; // looking at the leftmost bit
        for(int i = 0; i < 8; i++) {
            sb.append((val & mask) == 0 ? "0" : "1");
            val <<= 1; // move to the next bit
        }
        return sb.toString();
    }
}
