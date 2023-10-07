package src.main.seminar_2.chat_messanger.client;

import src.main.seminar_2.chat_messanger.server.Server;

import java.util.Objects;

/**
 * Клиентская часть подключения к серверу
 */
public class Client {
    private String name;
    private ClientView clientView;
    private Server server;
    private boolean connected;

    public Client(ClientView clientView, Server server) {
        this.clientView = clientView;
        this.server = server;
    }

    /**
     * подключение пользователя к серверу
     * @param name
     * @return
     */
    public boolean connectToServer(String name){
        this.name = name;
        if (server.connectUser(this)){
            printText("Вы успешно подключились!\n");
            connected = true;
            String log = server.getHistory();
            if (log != null){
                printText(log);
            }
            return true;
        } else {
            printText("Подключение не удалось");
            return false;
        }
    }

    /**
     * выход пользователя из чата(отключение)
     */
    public void disconnect(){
        if (connected) {
            connected = false;
            server.disconnectUser(this);
            clientView.disconnectFromServer();
            printText("Вы были отключены от сервера!");
        }
    }

    /**
     * отправка сообщения
     */
    public void sendMessage(String message){
        if (connected) {
            if (!message.isEmpty()) {
                server.sendMessage(name + ": " + message);
            }
        } else {
            printText("Нет подключения к серверу");
        }
    }

    /**
     * прием сообщения
     * @param answer
     */
    public void serverAnswer(String answer){
        printText(answer);
    }

    /**
     * имя клиента
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * печатаем текст в основной области текста
     * @param text
     */
    private void printText(String text){
        clientView.showMessage(text);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (connected != client.connected) return false;
        if (!Objects.equals(name, client.name)) return false;
        if (!Objects.equals(clientView, client.clientView)) return false;
        return Objects.equals(server, client.server);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (clientView != null ? clientView.hashCode() : 0);
        result = 31 * result + (server != null ? server.hashCode() : 0);
        result = 31 * result + (connected ? 1 : 0);
        return result;
    }
}
