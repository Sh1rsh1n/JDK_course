package src.main.seminar_4;

import src.main.seminar_4.models.handbooks.*;
import src.main.seminar_4.models.Employee;
/*
Создать справочник сотрудников
Необходимо:
Создать класс справочник сотрудников, который содержит внутри коллекцию сотрудников - каждый сотрудник должен иметь следующие атрибуты:
Табельный номер
Номер телефона
Имя
Стаж
Добавить метод, который ищет сотрудника по стажу (может быть список)
Добавить метод, который выводит номер телефона сотрудника по имени (может быть список)
Добавить метод, который ищет сотрудника по табельному номеру
Добавить метод добавление нового сотрудника в справочник
*/
public class MainApp {

    public static void main(String[] args) {

        Employee emp1 = new Employee("Pavel", "Ivanov", 4);

        Handbook hb = new EmployeeHandbook();
        HandbookHandler hh = new EmployeeHandbookHandler(nb);

        
    }

}