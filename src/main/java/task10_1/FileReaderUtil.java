package task10_1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class FileReaderUtil {
  public static List<Integer> readNumbersFromFile(String filePath) throws IOException {
    return Files.lines(Path.of(filePath))
        .map(String::trim)
        .filter(line -> !line.isEmpty())
        .map(Integer::parseInt)
        .collect(Collectors.toList());
  }
}
