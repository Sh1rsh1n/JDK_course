package src.main.seminar_4.services;

import src.main.seminar_4.models.Employee;
import src.main.seminar_4.models.handbooks.Handbook;
import src.main.seminar_4.services.HandbookService;

import java.util.List;
import java.util.ArrayList;

/**
 * Класс, обработка данных Справочника
 * кроме реализуемых методов интерфейса HandbookService
 * имеет дополнительные методы получения уникальных данных
 */
public class EmployeeHandbookService implements HandbookService<Employee> {

    protected Handbook<Employee> handbook;

    public EmployeeHandbookService(Handbook<Employee> handbook){
        this.handbook = handbook;
    }

    @Override
    public boolean add(Employee employee) {
        return handbook.addElement(employee);
    }

    @Override
    public Employee getById(int id) {
        return handbook.getElementById(id);
    }

    @Override
    public List<Employee> getAll() {
        return handbook.getAll();
    }

    @Override
    public boolean remove(Employee employee) {
        return handbook.removeElement(employee);
    }

    @Override
    public Handbook<Employee> getHandbook() {
        return handbook;
    }

    /**
     * метод, ищет сотрудников по опыту работы
     * @param experience - опыт
     * @return - список сотрудников
     */
    public List<Employee> findEmployeesByExperience(int experience) {
        List<Employee> list = new ArrayList<>();
        for (Employee employee : handbook.getAll()) {
            if (employee.getExperience() == experience) {
                list.add(employee);
            }
        }
        return list;
    }

    /**
     * метод, ищет номера телефонов сотрудников по имени и фамилии
     * @param name - имя
     * @param surname - фамилия
     * @return - список телефонов
     */
    public List<String> getPhonesByFullName(String name, String surname) {
        List<String> phones = new ArrayList<>();
        for (Employee employee: handbook.getAll()) {
            if (employee.getName().equals(name) && employee.getSurname().equals(surname)) {
                phones.addAll(employee.getPhones());
                return phones;
            }
        }
        return phones;
    }


}


