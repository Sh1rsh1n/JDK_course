package src.main.seminar_2.chat.repository;

import java.io.*;
import java.util.List;

/**
 * Репозиторий для хранения сообщений, взаимодействует с обычным текстовым
 * файлом
 */
public class TextFileRepository extends MessageRepository {

  private final static String FILE_PATH = "logMessage.txt";

  public TextFileRepository() {
    super();
    loadMessage();
  }

  /**
   * добавляем сообщение в список и сохраняем в текстовый файл
   */
  @Override
  public void add(String message) {
    listMessage.add(message);
    writeMessage(message);
  }

  /**
   * получаем сообщение из репозитория по индексу списка
   */
  @Override
  public String getByIndex(int index) {
    return listMessage.get(index);
  }

  /**
   * загружаем все сообщения, которые хранятся в файле
   */
  private void loadMessage() {

    try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
      String str; 
      while ((str = br.readLine()) != null) {
        if (!str.startsWith("**") && !str.endsWith("**")) {
          listMessage.add(str);
        }
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  /**
   * записываем сообщение в файл
   */
  private void writeMessage(String message) {

    try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
      bw.write(message);
      bw.write("\n");
      bw.flush();
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }
}