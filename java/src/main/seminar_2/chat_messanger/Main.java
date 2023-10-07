package src.main.seminar_2.chat_messanger;


import src.main.seminar_2.chat_messanger.client.ClientGUI;
import src.main.seminar_2.chat_messanger.server.Server;

public class Main {
    public static void main(String[] args) {

        Server server = new Server();

        new ClientGUI(server);
        new ClientGUI(server);
    }
}
