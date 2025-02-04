package task10_1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FactorialLoader {
  private final String filePath;
  private final int maxThreads;

  public FactorialLoader(String filePath, int maxThreads) {
    this.filePath = filePath;
    this.maxThreads = maxThreads;
  }

  public void loadAndCalculate() {
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
      System.err.println("Fatal error: " + e.getMessage());
    }
  }

  private List<List<Integer>> splitIntoBatches(List<Integer> list) {
    List<List<Integer>> batches = new ArrayList<>();
    int batchSize = (int) Math.ceil((double) list.size() / maxThreads);

    for (int i = 0; i < maxThreads; i++) {
      int fromIndex = i * batchSize;
      int toIndex = Math.min(fromIndex + batchSize, list.size());
      batches.add(new ArrayList<>(list.subList(fromIndex, toIndex)));
    }

    return batches;
  }
}