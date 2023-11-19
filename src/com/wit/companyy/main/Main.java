package com.wit.companyy.main;

import com.wit.companyy.entity.Employee;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Employee> employees = new LinkedList<>();
        employees.add(new Employee(1,"Bilge", "Göksu"));
        employees.add(new Employee(1,"Bilge", "Göksu"));
        employees.add(new Employee(2,"SpongeBob", "SquarePants"));
        employees.add(new Employee(2,"SpongeBob", "SquarePants"));
        employees.add(new Employee(3,"Marilyne", "Monroe"));
        employees.add(new Employee(3,"Marilyne", "Monroe"));
        employees.add(new Employee(4,"Frank", "Sinatra"));
        employees.add(new Employee(4,"Frank", "Sinatra"));
        employees.add(null); // nullPointerException gelir 27. sırada. o yüzden employee != null && cehck'i eklemeliyim. ama o zaman da else de hata alırım.  direkt başka bir null if 'i ekliyorum en kısası.

        // null bir data eklenmemesi üzerine çalışmalıdır! Buna Single Responsibility denir.

        Map<Integer,Employee> empMap = new HashMap<>();
        List<Employee> removeEmps = new ArrayList<>();

        // ayrı bir metoda alabiliyorum bunu. if check 'i yapmam Single Responsibility 'ye uygun değil !!!
        Iterator iterator = employees.iterator();
        while(iterator.hasNext()){
            Employee employee = (Employee) iterator.next();
            if(employee == null) {
                System.out.println("Find a NullPointerException !");
                continue;
            }
            if(empMap.containsKey(employee.getId())){
                removeEmps.add(employee);
                iterator.remove();
            } else{
                empMap.put(employee.getId(),employee);
            }
        }
        System.out.println("List: " + employees);
        System.out.println("Map" + empMap);
        System.out.println("Removed" + removeEmps);

        // ConcurrentModificationException  alırız eğer FOR ile dönersek. List + Set ler için Iterator kullanıyorum: => // for (Employee employee: employees) {... employees.remove(employee);}
    }
}