package task10_2;

public class AlternatingPrinter {
  private static volatile boolean isNumberTurn = true;

  public static void main(String[] args) {
    Thread numberThread = new Thread(() -> {
      for (int i = 0; i < 10; i++) {
        while (!isNumberTurn) {
          Thread.yield();
        }
        System.out.print(i + " ");
        isNumberTurn = false;
      }
    });

    Thread letterThread = new Thread(() -> {
      for (char c = 'a'; c <= 'j'; c++) {
        while (isNumberTurn) {
          Thread.yield();
        }
        System.out.print(c + " ");
        isNumberTurn = true;
      }
    });

    numberThread.start();
    letterThread.start();
  }
}
