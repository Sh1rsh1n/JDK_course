package src.main.seminar_2.chat_messanger.server;

import src.main.seminar_2.chat_messanger.repository.ClientRepository;
import src.main.seminar_2.chat_messanger.repository.MessageRepository;
import src.main.seminar_2.chat_messanger.repository.TextFileRepository;
import src.main.seminar_2.chat_messanger.client.Client;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Сервер чата, которому подключается пользователь
 */
public class Server {

    private ClientRepository clientRepository;

    private MessageRepository messageRepository;

    private boolean work;

    private ServerGUI serverGUI;

    public Server() {

        serverGUI = new ServerGUI(this);
        clientRepository = new ClientRepository();
        messageRepository = new TextFileRepository();

    }

    public boolean isWork() {
        return work;
    }

    public void setWork(boolean work) {
        this.work = work;
    }

    public ClientRepository getClientRepository() {
        return clientRepository;
    }

    public MessageRepository getMessageRepository() {
        return messageRepository;
    }

    /**
     * метод подключения пользователя
     * @param client
     * @return
     */
    public boolean connectUser(Client client) {
        // проверяем работает ли сервер
        if (!work) {
            return false;
        }
        // добавляем пользователя в список
        clientRepository.add(client);
        //печатаем сообщение на экране графического приложения сервера
        serverGUI.appendLog(String.format("** %s подключился: %s **",
                client.getName(),
                LocalTime.now().format(DateTimeFormatter.ISO_TIME)));
        return true;
    }

    /**
     * отключение пользователя от сервера
     * @param client
     */
    public void disconnectUser(Client client) {
        // удаляем пользователя из списка
        clientRepository.remove(client);
        String text = String.format("** %s: покинул чат: %s **",
                client.getName(),
                LocalTime.now().format(DateTimeFormatter.ISO_TIME));
        //печатаем сообщение на экране графического приложения сервера
        serverGUI.appendLog(text);
        // оповещаем всех пользователей
        answerAll(text);
        //сохранение в лог
        saveInLog(text);
    }

    /**
     * отправка сообщения
     * @param text
     */
    public void sendMessage(String text){
        if (!work){
            return;
        }
        // оповещаем всех пользователей
        answerAll(text);
        //сохранение в лог
        saveInLog(text);
    }

    /**
     * получаем историю из лог-файла
     * @return
     */
    public String getHistory() {
        return readLog();
    }

    /**
     * метод чтения данных из лог-файла(репозитория)
     * @return
     */
    private String readLog() {
        StringBuilder sb = new StringBuilder();
        for (String str : messageRepository.getAll()) {
            sb.append(str).append("\n");
        }
        return sb.toString();
    }

    /**
     * метод сохранения сообщения в лог-файл (репозиторий)
     * @param text
     */
    private void saveInLog(String text) {
        messageRepository.add(text);
    }

    /**
     * оповещение всех пользователей
     * @param text
     */
    private void answerAll(String text) {
        for (Client client : clientRepository.getAll()) {
            client.serverAnswer(text);
        }
    }
}
