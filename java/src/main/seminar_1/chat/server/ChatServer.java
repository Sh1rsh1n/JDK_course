package src.main.seminar_1.chat.server;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class ChatServer extends JFrame {

    private final static int WIN_X = 900;
    private final static int WIN_Y = 500;
    private final static int WIN_H = 400;
    private final static int WIN_W = 400;

    JButton btnStart = new JButton("Старт");
    JButton btnStop = new JButton("Стоп");

    JTextArea jTextArea = new JTextArea(20, 20);

    public ChatServer() {

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WIN_X, WIN_Y);
        setSize(WIN_W, WIN_H);
        setTitle("Chat server");
        setResizable(false);
        
        // добавляем панель кнопок и привязываем к ней кнопки
        JPanel btnPanel = new JPanel(new GridLayout(1, 2));
        btnPanel.add(btnStart);
        btnPanel.add(btnStop);
        btnStop.setEnabled(false);

        // запрещаем редактировать область текста и добавляем ее в область скролла
        jTextArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(jTextArea);

        // привязываем все добавленные компоненты к окну
        add(scroll, BorderLayout.CENTER);
        add(btnPanel, BorderLayout.SOUTH);

        setVisible(true);

        // слушатель событий нажатия кнопки "Старт"
        btnStart.addActionListener(e -> {
            switchShowButtons();
            jTextArea.append(String.format("Server is started %s\n",
                    new Date()));
        });

        // слушатель событий нажатия кнопки "Стоп"
        btnStop.addActionListener(e -> {
            switchShowButtons();
            jTextArea.append(String.format("Server is stoped %s\n",
                    new Date()));
        });

    }

    // переключатель кнопок, делает кнопки не активными в зависимости от статуса работы приложения
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
