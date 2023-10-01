package src.main.seminar_1.chat.server;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.time.LocalDateTime;

public class ChatServer extends JFrame {

    private final static int PORT = 241;
    private static int WINDOW_X = 1000;
    private static int WINDOW_Y = 500;
    private static int WINDOW_HEIGHT = 500;
    private static int WINDOW_WIGHT = 500;

    private JTextArea textArea = new JTextArea(20,1);
    private JScrollPane pane = new JScrollPane(textArea);
    private JButton startBtn = new JButton("Start");
    private JButton stopBtn = new JButton("Stop");
    private JPanel buttonsPanel = new JPanel(new GridLayout(1, 2));

    private ServerSocket serverSocket;

    private boolean isStarted;

    public ChatServer() {

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_X, WINDOW_Y);
        setSize(WINDOW_WIGHT, WINDOW_HEIGHT);
        setTitle("Simple Chat Server");
        setResizable(false);
        setVisible(true);

        buttonsPanel.add(startBtn);
        buttonsPanel.add(stopBtn);
        stopBtn.setVisible(isStarted);

        textArea.setEditable(false);
        pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);


        add(pane, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.SOUTH);

        startBtn.addActionListener(e -> {
            try {
                serverSocket = new ServerSocket(PORT);
                textArea.append(String.format("Сервер запущен %s\nАдрес и порт подключения: %s:%d\n",
                        LocalDateTime.now(),
                        serverSocket.getInetAddress().toString(),
                        serverSocket.getLocalPort()));
                        startBtn.setVisible(isStarted);
                        stopBtn.setVisible(!isStarted);
                        isStarted = true;

            } catch (IOException ex) {
                System.out.println("Ошибка подключения");
            }
        });

        stopBtn.addActionListener(e -> {
            try {
                serverSocket.close();
                stopBtn.setVisible(!isStarted);
                startBtn.setVisible(isStarted);
                isStarted = false;
            } catch (IOException ex) {
                System.out.println("Ошибка завершения работы сервера");
            }
            textArea.append(String.format("Сервер остановлен %s\n", LocalDateTime.now()));
        });
    }
}
