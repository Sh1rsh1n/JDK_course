


public class ClientRepository implements Repository<ClientGUI> {

  private List<ClientGUI> listClients;
  
  public ClientRepository(){
    listClients = new ArrayList<>();
  }
  
  @Override
  public void add(ClientGUI client){
    listClients.add(client);
  }
  
  @Override
  public void remove(ClientGUI client){
    listClients.remove(client);
  }
  
  @Override
  public String getByIndex(int index) {
    return listClients.get(index);
  }

  @Override
  public List<ClientGUI> getAll(){
    return listClients;
  }


}