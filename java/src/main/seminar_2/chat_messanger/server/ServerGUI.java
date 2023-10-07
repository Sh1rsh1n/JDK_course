package src.main.seminar_2.chat_messanger.server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * графический интерфейс для взаимодействия с сервером
 */
public class ServerGUI extends JFrame {

    public static final int WIDTH = 400;
    public static final int HEIGHT = 300;

    JButton btnStart, btnStop;
    JTextArea log;
    Server server;

    public ServerGUI(Server server) {

        this.server = server;

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setTitle("ЧАТ-СЕРВЕР");
        setLocationRelativeTo(null);

        createPanel();

        setVisible(true);
    }

    /**
     * выводим сообщение в область текста основного окна
     * @param text
     */
    public void appendLog(String text){
        log.append(text + "\n");
    }

    /**
     * создаем панель с компонентами в основном окне
     */
    private void createPanel() {
        log = new JTextArea();
        add(log);
        add(createButtons(), BorderLayout.SOUTH);
    }

    /**
     * создаем кнопки и прописываем слушателей и их действия при нажатии на них
     * @return
     */
    private Component createButtons() {
        JPanel panel = new JPanel(new GridLayout(1, 2));
        btnStart = new JButton("Start");
        btnStop = new JButton("Stop");
        btnStop.setEnabled(server.isWork());

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (server.isWork()){
                    appendLog("Сервер уже был запущен");
                } else {
                    server.setWork(true);
                    appendLog("Сервер запущен!");
                }
                switchShowButtons();
            }
        });

        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!server.isWork()){
                    appendLog("Сервер уже был остановлен");
                } else {
                    server.setWork(false);

                    // Решение найдено. Итерируемся в обратном порядке. При этом вызываем
                    for (int i = server.getClientRepository().getAll().size(); i > 0 ; i--) {
                        server.getClientRepository().getAll().get(i - 1).disconnect();
                    }

                    //TODO поправить удаление
                    appendLog("Сервер остановлен!");
                }
                switchShowButtons();
            }
        });

        panel.add(btnStart);
        panel.add(btnStop);
        return panel;
    }

    /**
     * переключение кнопок в зависимости от того в каком состоянии сервер
     */
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
