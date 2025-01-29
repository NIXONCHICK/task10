package task10_1;

import java.io.IOException;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    String filePath = "src/main/resources/numbers.txt";

    try {
      List<Integer> numbers = FileReaderUtil.readNumbersFromFile(filePath);

      for (int number : numbers) {
        FactorialThread thread = new FactorialThread(number);
        thread.start();
      }

    } catch (IOException e) {
      System.err.println("Ошибка чтения файла: " + e.getMessage());
    }
  }
}
