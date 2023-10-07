package src.main.seminar_2.chat_messanger.client;

import src.main.seminar_2.chat_messanger.server.Server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * графический интерфейс приложения для пользователей
 */
public class ClientGUI extends JFrame implements ClientView {
    public static final int WIDTH = 400;
    public static final int HEIGHT = 300;

    JTextArea log;
    JTextField tfIPAddress, tfPort, tfLogin, tfMessage;
    JPasswordField password;
    JButton btnLogin, btnSend;
    JPanel headerPanel;

    private Client client;

    private Server server;

    public ClientGUI(Server server) {
        this.server = server;
        this.client = new Client(this, server);

        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Chat client");
        setLocation(500, 500);

        createPanel();

        setVisible(true);
    }

    /**
     * подключение к серверу
     */
    private void connectToServer() {
        if (client.connectToServer(tfLogin.getText())) {
            hideHeaderPanel(false);
        }
    }

    /**
     * отключение пользователя от сервера
     */
    public void disconnectFromServer() {
        hideHeaderPanel(true);
        client.disconnect();
    }

    /**
     * отображение(добавление) сообщений в чат
     * @param text
     */
    @Override
    public void showMessage(String text) {
        appendLog(text);
    }

    /**
     * скрыть панель с настройками подключения пользователя
     * @param visible
     */
    private void hideHeaderPanel(boolean visible) {
        headerPanel.setVisible(visible);
    }

    /**
     * отправка сообщения пользователем
     */
    public void sendMessage() {
        client.sendMessage(tfMessage.getText());
        tfMessage.setText("");
    }

    /**
     * добавление сообщения в поле с сообщениями
     * @param text
     */
    private void appendLog(String text) {
        log.append(text + "\n");
    }

    /**
     * заполняем основное окно панелями с полями взаимодействия с пользователем
     */
    private void createPanel() {
        add(createHeaderPanel(), BorderLayout.NORTH);
        add(createLog());
        add(createFooter(), BorderLayout.SOUTH);

    }

    /**
     * верхняя панель (панель настроек входа)
     * @return
     */
    private Component createHeaderPanel() {
        headerPanel = new JPanel(new GridLayout(2, 3));
        tfIPAddress = new JTextField("127.0.0.1");
        tfPort = new JTextField("8189");
        tfLogin = new JTextField("Ivan Ivanovich");
        password = new JPasswordField("123456");
        btnLogin = new JButton("login");
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                connectToServer();
            }
        });

        headerPanel.add(tfIPAddress);
        headerPanel.add(tfPort);
        headerPanel.add(new JPanel());
        headerPanel.add(tfLogin);
        headerPanel.add(password);
        headerPanel.add(btnLogin);

        return headerPanel;
    }

    /**
     * панель чата (текстовая область)
     * @return
     */
    private Component createLog() {
        log = new JTextArea();
        log.setEditable(false);
        return new JScrollPane(log);
    }

    /**
     * нижняя панель (отправка сообщения)
     * @return
     */
    private Component createFooter() {
        JPanel panel = new JPanel(new BorderLayout());
        tfMessage = new JTextField();
        tfMessage.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == '\n') {
                    sendMessage();
                }
            }
        });
        btnSend = new JButton("send");
        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });
        panel.add(tfMessage);
        panel.add(btnSend, BorderLayout.EAST);
        return panel;
    }

    /**
     * действие при закрытии основного окна
     * @param
     */
    @Override
    protected void processWindowEvent(WindowEvent e) {
        super.processWindowEvent(e);
        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
            disconnectFromServer();
        }
    }
}
