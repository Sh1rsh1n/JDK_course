package src.main.seminar_4;

import src.main.seminar_4.models.Employee;
import src.main.seminar_4.models.handbooks.EmployeeHandbook;
import src.main.seminar_4.services.EmployeeHandbookService;

import java.util.Arrays;

/*
Создать справочник сотрудников
Необходимо:
Создать класс справочник сотрудников, который содержит внутри коллекцию сотрудников - каждый сотрудник должен иметь следующие атрибуты:
Табельный номер
Номер телефона
Имя
Стаж
1. Добавить метод, который ищет сотрудника по стажу (может быть список)
2. Добавить метод, который выводит номер телефона сотрудника по имени (может быть список)
3. Добавить метод, который ищет сотрудника по табельному номеру
4. Добавить метод добавление нового сотрудника в справочник
*/
public class MainApp {

    public static void main(String[] args) {

        // обращаемся к сервису (EmployeeHandbookService) в параметры передаем (EmployeeHandbook)
        EmployeeHandbookService handbookService = new EmployeeHandbookService(new EmployeeHandbook());

        //region Task4 добавляем работников в справочник
        Employee emp1 = new Employee("Pavel", "Ivanov", 4);
        emp1.setPhones(Arrays.asList("+79876543210", "+79634561245"));

        Employee emp2 = new Employee("Ivan", "Pavlov", 2);
        emp2.setPhones(Arrays.asList("+79876540987"));

        Employee emp3 = new Employee("Alexey", "Petrov", 10);
        emp3.setPhones(Arrays.asList("+79876541111"));
        
        Employee emp4 = new Employee("Anna", "Kirova", 1);

        handbookService.add(emp1);
        handbookService.add(emp2);
        handbookService.add(emp3);
        handbookService.add(emp4);
        //endregion

        //region Tasks
        // Task1 метод, который ищет сотрудника по стажу (может быть список)
        System.out.println(handbookService.findEmployeesByExperience(10));

        // Task2 метод, который выводит номер телефона сотрудника по имени (может быть список)
        System.out.println(handbookService.getPhonesByFullName("Alexey", "Petrov"));

        // Task3 метод, который ищет сотрудника по табельному номеру
        System.out.println(handbookService.getById(10002));
        //endregion
    }

}