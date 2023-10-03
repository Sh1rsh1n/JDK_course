package src.main.seminar_1.chat.server;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class ChatServer extends JFrame {

    private final static int WIN_X = 900;
    private final static int WIN_Y = 500;
    private final static int WIN_H = 400;
    private final static int WIN_W = 400;

    JButton btnStart = new JButton("Start");
    JButton btnStop = new JButton("Stop");

    JTextArea jTextArea = new JTextArea(20, 20);

    public ChatServer() {

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WIN_X, WIN_Y);
        setSize(WIN_W, WIN_H);
        setTitle("Chat server");
        setResizable(false);

        JPanel btnPanel = new JPanel(new GridLayout(1, 2));
        btnPanel.add(btnStart);
        btnPanel.add(btnStop);
        btnStop.setEnabled(false);

        jTextArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(jTextArea);

        add(scroll, BorderLayout.CENTER);
        add(btnPanel, BorderLayout.SOUTH);

        setVisible(true);

        btnStart.addActionListener(e -> {
            switchShowButtons();
            jTextArea.append(String.format("Server is started %s\n",
                    new Date()));
        });


        btnStop.addActionListener(e -> {
            switchShowButtons();
            jTextArea.append(String.format("Server is stoped %s\n",
                    new Date()));
        });

    }

    private void switchShowButtons() {
        if (btnStart.isEnabled()) {
            btnStart.setEnabled(false);
            btnStop.setEnabled(true);
        } else {
            btnStart.setEnabled(true);
            btnStop.setEnabled(false);
        }
    }


}
