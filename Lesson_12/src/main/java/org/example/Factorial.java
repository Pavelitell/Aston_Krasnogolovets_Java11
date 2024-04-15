package org.example;

public class Factorial {
    int calls;
    public int getCalls() {
        return calls;
    }

    public long getFactorial(int number) {
        calls++;
        if (number < 0)
            throw new IllegalArgumentException();
        long result = 1;
        if (number > 1) {
            for (int i = 1; i <= number; i++)
                result = result * i;
        }
        return result;
    }
}
