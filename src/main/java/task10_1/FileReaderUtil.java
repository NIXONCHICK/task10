package task10_1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class FileReaderUtil {
  public static List<Integer> readNumbersFromFile(String filePath) throws IOException {
    try {
      return Files.lines(Path.of(filePath))
          .map(String::trim)
          .filter(line -> !line.isEmpty())
          .map(line -> {
            try {
              return Integer.parseInt(line);
            } catch (NumberFormatException e) {
              System.err.println("Ошибка парсинга: '" + line + "' не является числом");
              return null;
            }
          })
          .filter(Objects::nonNull)
          .collect(Collectors.toList());
    } catch (IOException e) {
      System.err.println("Ошибка чтения файла: " + e.getMessage());
      return Collections.emptyList();
    }
  }
}