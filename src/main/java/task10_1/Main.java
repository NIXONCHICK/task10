package task10_1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
  private static final int MAX_THREADS = 3;

  public static void main(String[] args) {
    String filePath = "src/main/resources/numbers.txt";

    try {
      List<Integer> numbers = FileReaderUtil.readNumbersFromFile(filePath);
      List<List<Integer>> batches = splitIntoBatches(numbers);

      for (List<Integer> batch : batches) {
        if (!batch.isEmpty()) {
          FactorialThread thread = new FactorialThread(batch);
          thread.start();
        }
      }

    } catch (IOException e) {
      System.err.println("Фатальная ошибка: " + e.getMessage());
    }
  }

  private static List<List<Integer>> splitIntoBatches(List<Integer> list) {
    List<List<Integer>> batches = new ArrayList<>();
    int batchSize = (int) Math.ceil((double) list.size() / Main.MAX_THREADS);

    for (int i = 0; i < Main.MAX_THREADS; i++) {
      int fromIndex = i * batchSize;
      int toIndex = Math.min(fromIndex + batchSize, list.size());
      batches.add(new ArrayList<>(list.subList(fromIndex, toIndex)));
    }

    return batches;
  }
}