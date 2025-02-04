package task10_1;

public class Main {
  public static void main(String[] args) {
    String filePath = "src/main/resources/numbers.txt";
    int maxThreads = 3;
    FactorialLoader loader = new FactorialLoader(filePath, maxThreads);
    loader.loadAndCalculate();
  }
}