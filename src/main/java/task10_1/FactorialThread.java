package task10_1;

import java.math.BigInteger;

public class FactorialThread extends Thread {
  private final int number;

  public FactorialThread(int number) {
    this.number = number;
  }

  @Override
  public void run() {
    BigInteger factorial = FactorialCalculator.calculate(number);

    System.out.println("Число: " + number + ", Факториал: " + factorial);
  }
}
