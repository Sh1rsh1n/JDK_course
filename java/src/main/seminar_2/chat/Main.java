package src.main.seminar_2.chat;


import src.main.seminar_2.chat.client.ClientGUI;
import src.main.seminar_2.chat.server.ServerWindow;

public class Main {
    public static void main(String[] args) {
        ServerWindow serverWindow = new ServerWindow();
        new ClientGUI(serverWindow);
        new ClientGUI(serverWindow);
    }
}
