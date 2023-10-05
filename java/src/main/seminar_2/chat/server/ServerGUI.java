package src.main.seminar_2.chat.server;


public class ServerGUI extends JFrame {

  private static final int WIDTH = 400;
  private static final int HEIGHT = 300;

  private JButton btnStart, btnStop;
  private JTextArea log;

  public ServerGUI(Server server) {

    
  }

  private void createPanel() {
        log = new JTextArea();
        add(log);
        add(createButtons(), BorderLayout.SOUTH);
    }

  private Component createButtons() {
    JPanel panel = new JPanel(new GridLayout(1, 2));
    btnStart = new JButton("Start");
    btnStop = new JButton("Stop");

    btnStart.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (work){
                appendLog("** Сервер уже был запущен **");
            } else {
                work = true;
                appendLog("** Сервер запущен! **");
            }
        }
    });

    btnStop.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!work){
                appendLog("** Сервер уже был остановлен **");
            } else {
                work = false;
                for (ClientGUI clientGUI: clientGUIList){
                    disconnectUser(clientGUI);
                }
                //TODO поправить удаление
                appendLog("** Сервер остановлен! **");
            }
        }
    });

      panel.add(btnStart);
      panel.add(btnStop);
      return panel;
  }
}