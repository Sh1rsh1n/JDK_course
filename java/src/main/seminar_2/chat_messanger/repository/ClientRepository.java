package src.main.seminar_2.chat_messanger.repository;

import src.main.seminar_2.chat_messanger.client.Client;

import java.util.LinkedList;
import java.util.List;

/**
 * Класс репозиторий с пользователями,
 * выполняет все операция для взаимодействия с пользователями
 */
public class ClientRepository implements Repository<Client> {

    private List<Client> listClients;

    public ClientRepository() {
        listClients = new LinkedList<>();
    }

    /**
     * добавления пользователя
     * @param client
     */
    @Override
    public void add(Client client) {
        listClients.add(client);
    }

    /**
     * удаление пользователя
     * @param client
     */
    @Override
    public void remove(Client client) {
        listClients.removeIf(c -> c.equals(client));
    }

    /**
     * поиск по индексу
     * @param index
     * @return
     */
    @Override
    public Client getByIndex(int index) {
        return listClients.get(index);
    }

    /**
     * получить всех пользователей
     * @return
     */
    @Override
    public List<Client> getAll() {
        return listClients;
    }


}