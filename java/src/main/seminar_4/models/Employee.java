package src.main.seminar_4.models;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;


public class Employee {
    
    private static int COUNTER = 10000;
    
    private int tableNo;
    private String name;
    private String surname;
    private int experience;
    private List<String> phones;
    
    {
        tableNo = ++COUNTER;
    }
    
    public Employee(String name, String surname, int experience){
        this.name = name;
        this.surname = surname;
        this.experience = experience;
        phones = new ArrayList<>();
    }
    
    public int getTableNo(){
        return tableNo;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }

    public String getSurname(){
        return surname;
    }
    
    public void setSurname(String surname){
        this.surname = surname;
    }
    
    public int getExperience(){
        return experience;
    }
    
    public void setExperience(int experience){
        this.experience = experience;
    }
    
    public List<String> getPhones(){
        return List.copyOf(phones);
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }

    public boolean addNewPhone(String phone){
        return phones.add(phone);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (tableNo != employee.tableNo) return false;
        if (experience != employee.experience) return false;
        if (!Objects.equals(name, employee.name)) return false;
        if (!Objects.equals(surname, employee.surname)) return false;
        return Objects.equals(phones, employee.phones);
    }

    @Override
    public int hashCode() {
        int result = tableNo;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + experience;
        result = 31 * result + (phones != null ? phones.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "tableNo=" + tableNo +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", expirience=" + experience +
                ", phones=" + phones +
                '}';
    }
}