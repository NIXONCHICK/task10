package task10_1;

import java.math.BigInteger;
import java.util.List;

public class FactorialThread extends Thread {
  private final List<Integer> numbers;

  public FactorialThread(List<Integer> numbers) {
    this.numbers = numbers;
  }

  @Override
  public void run() {
    for (int number : numbers) {
      try {
        BigInteger factorial = FactorialCalculator.calculate(number);
        System.out.println("Число: " + number + ", Факториал: " + factorial);
      } catch (IllegalArgumentException e) {
        System.err.println("Ошибка вычисления факториала: " + e.getMessage());
      }
    }
  }
}