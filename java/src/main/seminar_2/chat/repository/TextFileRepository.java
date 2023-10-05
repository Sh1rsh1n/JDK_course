

/**
 * Репозиторий для хранения сообщений, взаимодействует с обычным текстовым файлом
 */
public class TextFileRepository extends ChatRepository {

  privat final static String FILE_PATH = "logMessage.txt"
  private List<String> listMessage;
  private BufferedReader br;
  private BufferedWriter bw;

  public TextFileRepository() {
    listMessage = new ArrayList<>();
    loadMessage();
  }

  /**
   * добавляем сообщение в список и сохраняем в текстовый файл
   */
  @Override
  public void saveMessage(String message) {
    listMessage.add(message);
    writeMessage(message);
  }

  /**
   * получаем последнее сообщение из репозитория
   */
  @Override
  public String getLastMessage() {
    return listMessage.get(listMessage.size - 1);
  }

  /**
   * Получаем все сообщения из репозитория
   */
  @Override
  public List<String> getAllMessages() {
    return listMessage;
  }

  /**
   * загружаем все сообщения, которые хранятся в файле
   */
  private void loadMessage() {

    try (br = new BufferedReader(new FileReader(FILE_PATH))) {
      String str; 
      while ((str = br.readline) != null) {
        if (!str.srartWith("**") && !str.endsWith("**")) {
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

    try (bw = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
      bw.write(message);
      bw.write("\n");
      bw.flush();
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }
}