package task10_1;

import java.math.BigInteger;

public class FactorialCalculator {
  public static BigInteger calculate(int number) {
    if (number < 0) {
      throw new IllegalArgumentException("Факториал отрицательного числа не определен: " + number);
    }

    BigInteger result = BigInteger.ONE;
    for (int i = 2; i <= number; i++) {
      result = result.multiply(BigInteger.valueOf(i));
    }
    return result;
  }
}