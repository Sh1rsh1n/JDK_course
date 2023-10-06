package src.main.seminar_2.chat;


import src.main.seminar_2.chat.client.ClientGUI;
import src.main.seminar_2.chat.server.ServerGUI;

public class Main {

    public static void main(String[] args) {
    
        ServerGUI server = new ServerGUI();
        new ClientGUI(server);
        new ClientGUI(server);
    }
}
