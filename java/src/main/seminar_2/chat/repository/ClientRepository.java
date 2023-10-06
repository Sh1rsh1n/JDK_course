package src.main.seminar_2.chat.repository;

import java.util.List;
import java.util.ArrayList;

import src.main.seminar_2.chat.client.ClientGUI;


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
  public ClientGUI getByIndex(int index) {
    return listClients.get(index);
  }

  @Override
  public List<ClientGUI> getAll(){
    return listClients;
  }


}