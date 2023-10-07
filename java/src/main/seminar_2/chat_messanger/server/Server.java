package src.main.seminar_2.chat_messanger.server;

import src.main.seminar_2.chat_messanger.repository.ClientRepository;
import src.main.seminar_2.chat_messanger.repository.MessageRepository;
import src.main.seminar_2.chat_messanger.repository.TextFileRepository;
import src.main.seminar_2.chat_messanger.client.Client;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


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

    public boolean connectUser(Client client) {
        if (!work) {
            return false;
        }
        clientRepository.add(client);
        serverGUI.appendLog(String.format("** %s подключился: %s **",
                client.getName(),
                LocalTime.now().format(DateTimeFormatter.ISO_TIME)));
        return true;
    }

    public void disconnectUser(Client client) {
        clientRepository.remove(client);
        String text = String.format("** %s: покинул чат: %s **",
                client.getName(),
                LocalTime.now().format(DateTimeFormatter.ISO_TIME));
        serverGUI.appendLog(text);
        answerAll(text);
        saveInLog(text);
    }

    public void sendMessage(String text){
        if (!work){
            return;
        }
        answerAll(text);
        saveInLog(text);
    }

    public String getHistory() {
        return readLog();
    }

    private String readLog() {
        StringBuilder sb = new StringBuilder();
        for (String str : messageRepository.getAll()) {
            sb.append(str).append("\n");
        }
        return sb.toString();
    }

    private void saveInLog(String text) {
        messageRepository.add(text);
    }


    private void answerAll(String text) {
        for (Client client : clientRepository.getAll()) {
            client.serverAnswer(text);
        }
    }
}
