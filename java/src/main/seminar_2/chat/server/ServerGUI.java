package src.main.seminar_2.chat.server;


public class ServerGUI extends JFrame {

  private static final int WIDTH = 400;
  private static final int HEIGHT = 300;

  private JButton btnStart, btnStop;
  private JTextArea log;
  
  private Server server;

  public ServerGUI() {
  
    server = new Server(this)

    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(WIDTH, HEIGHT);
    setResizable(false);
    setTitle("Chat server");
    setLocationRelativeTo(null);

    createPanel();

    setVisible(true);
    
  }

  private void createPanel() {
      log = new JTextArea();
      ScrollPane sp = new ScrollPane(log);
      add(sp);
      add(createButtons(), BorderLayout.SOUTH);
  }

  private Component createButtons() {
  
    JPanel panel = new JPanel(new GridLayout(1, 2));
    btnStart = new JButton("Старт");
    btnStop = new JButton("Стоп");

    btnStart.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (work){
            server.saveInLog("** Сервер уже был запущен **");
        } else {
            work = true;
            server.saveInLog("** Сервер запущен! **");
        }
      }
  });

  btnStop.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
      if (!work){
          server.saveInLog("** Сервер уже был остановлен **");
      } else {
          work = false;
          for (ClientGUI client: server.getClientRepository().getAll()) {
              server.disconnectUser(client);
          }
          //TODO поправить удаление
          server.saveInLog("** Сервер остановлен! **");
      }
    }
  });

    panel.add(btnStart);
    panel.add(btnStop);
    return panel;
  }
}