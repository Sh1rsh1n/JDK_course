package src.main.entity.seminar_4;

import java.util.List;
import java.util.ArrayList;


public class Employee {
    
    private static int COUNTER = 10000;
    
    private int tableNo;
    private String name;
    private String surname;
    private int expirience;
    private List<String> phones;
    
    {
        tableNo = ++COUNTER;
    }
    
    public Employee(String name, String surname, int expirience){
        this.name = name;
        this.surname = surname;
        this.expirience = expirience;
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
    
    public int getExpirience(){
        return expirience;
    }
    
    public void setExpirience(int expirience){
        this.expirience = expirience;
    }
    
    public List<String> getPhones(){
        return List.of(phones);
    }
    
    public boolean addNewPhone(String phone){
        return phones.add(phone);
    }
}