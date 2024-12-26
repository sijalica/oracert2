package part2exceptions;

/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 2: Exception Handling and Assertions
Topic:  Using assertions
*/

public class AssertionExample {

    static {
        boolean startupAllowed = false;

        // startupAllowed will be true ONLY if assertions are enabled
        // otherwise statement is simply ignored.
        assert startupAllowed = true;

        // The following statement prevents the class from loading...
        if (!startupAllowed)
            throw new RuntimeException("Assertions must be enabled!!!");
    }


    public static void main(String[] args) {
        byte s2;

        // Value below exceeds Byte Max Value
        short maxValue = Byte.MAX_VALUE + 1;

        //  assert that value is within the proper range for byte
        assert maxValue >= Byte.MIN_VALUE && maxValue <= Byte.MAX_VALUE;

        // Casting short to a byte could lead to undetected overflow..
        s2 = (byte) maxValue;

        // Printing short value prints the 'actual expected value'
        System.out.println("Short value = " + maxValue);

        // Printing byte value shows maximum value overflowed.
        System.out.println("Byte value = " + s2);

    }
}