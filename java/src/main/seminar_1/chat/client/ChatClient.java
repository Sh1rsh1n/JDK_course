package src.main.seminar_1.chat.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ChatClient extends JFrame {

    private final static String LOG_FILE = "log.txt";

    private static int WINDOW_X = 1000;
    private static int WINDOW_Y = 500;
    private static int WINDOW_HEIGHT = 500;
    private static int WINDOW_WIGHT = 500;

    // верхние панели настроек входа и подключения
    private JPanel serverSettingsPanel = new JPanel(new GridLayout(1, 3));
    private JPanel userLoginPanel = new JPanel(new GridLayout(1, 3));
    private JPanel headerPanel = new JPanel(new GridLayout(2, 1));

    // компоненты верхней панели
    private JTextField address = new JTextField("127.0.0.1");
    private JTextField port = new JTextField("241");
    private JTextField login = new JTextField();
    private JPasswordField password = new JPasswordField();
    private JButton loginBtn = new JButton("Подключиться");

    // область текста
    private JTextArea log = new JTextArea();

    // панель отправки сообщения
    private JPanel footerPanel = new JPanel(new BorderLayout());
    private JTextField messageField = new JTextField();
    private JButton sendBtn = new JButton("Отправить");

    private JList<String> jList = new JList<>();

    public ChatClient() {

        try {
            if (!Files.exists(Path.of(LOG_FILE)))
                Files.createFile(Path.of(LOG_FILE));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        // параметры основного окна
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_X, WINDOW_Y);
        setSize(WINDOW_WIGHT, WINDOW_HEIGHT);
        setTitle("Simple Chat Client");

        // верхняя панель настроек подключения
        serverSettingsPanel.add(address);
        serverSettingsPanel.add(port);
        userLoginPanel.add(login);
        userLoginPanel.add(password);
        userLoginPanel.add(loginBtn);
        
        // добавляем элементы на верхнюю панель
        headerPanel.add(serverSettingsPanel);
        headerPanel.add(userLoginPanel);

        // добавляем саму панель в наше окно
        add(headerPanel, BorderLayout.NORTH);

        //центральная област отображения текста
        log.setEditable(false); // запрещаем редактировать область текста 
        JScrollPane scrollPane = new JScrollPane(log); // создаем скролл панель и внедряем в нее область текста
        add(scrollPane); // добавляем скролл панель
        scrollPane.setVisible(false);

        // добавляем элементы на нижнюю панель и привязваем саму панель к окну
        footerPanel.add(messageField, BorderLayout.CENTER);
        footerPanel.add(sendBtn, BorderLayout.EAST);
        footerPanel.setVisible(false);
        add(footerPanel, BorderLayout.SOUTH);

        // добавляем список пользователей
        String[] userArray = new String[]{"Alex", "Pavel", "Anna"};
        jList.setListData(userArray);
        jList.setVisible(false);
        add(jList, BorderLayout.WEST);

        setVisible(true);

        // слушатель событий для кнопки "Подключиться"
        loginBtn.addActionListener(e -> {
            // проверка логина и пароля для входа
            if (!checkLogin(login.getText(), password.getText())) {
                JOptionPane.showMessageDialog(this,
                        "Неверный логин или пароль",
                        "Ошибка авторизации.", JOptionPane.ERROR_MESSAGE);
            } else {
                // чтение сообщений из лог файла при подключении
                try (BufferedReader br = new BufferedReader(new FileReader(LOG_FILE))) {
                    String str;
                    while ((str = br.readLine()) != null) {
                        log.append(str);
                        log.append("\n");
                    }
                }catch (IOException ex) {
                    ex.printStackTrace();
                }
                jList.setVisible(true);
                footerPanel.setVisible(true);
                scrollPane.setVisible(true);
                loginBtn.setEnabled(false);
            }
        });

        // отправка сообщения по нажатию клавиши ENTER
        messageField.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    log.append(String.format("%s %s %s\n",
                            jList.getSelectedValue(),
                            messageField.getText(),
                            new Date()));

                    try (BufferedWriter bw = new BufferedWriter(new FileWriter(LOG_FILE, true))) {
                        bw.append(String.format("%s %s %s\n", jList.getSelectedValue(), messageField.getText(), new Date()));
                        bw.flush();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }

                    messageField.setText("");
                }


            }
        });

        // слушатель событий нажатия для кнопки "Отправить"
        sendBtn.addActionListener(e -> {
            log.append(String.format("%s %s %s\n",
                    jList.getSelectedValue(),
                    messageField.getText(),
                    new Date()));

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(LOG_FILE, true))) {
                bw.append(String.format("%s %s %s\n", jList.getSelectedValue(), messageField.getText(), new Date()));
                bw.flush();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

            messageField.setText("");
        });
    }

    // типа проверка входа пользователя
    private boolean checkLogin(String login, String password) {
        for (Map.Entry<String, String> entry : userLoginDataBase().entrySet()) {
            if (login.equalsIgnoreCase(entry.getKey()) && password.equals(entry.getValue())) {
                return true;
            }
        }
        return false;
    }

    // типа БД пользователей
    private Map<String, String> userLoginDataBase() {
        Map<String, String> map = new HashMap<>();

        map.put("alex", "123qwe");
        map.put("den", "123qwe");

        return map;
    }
}
