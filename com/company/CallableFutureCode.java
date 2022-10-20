package com.company;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableFutureCode {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService service = Executors.newFixedThreadPool(3);
        Student s1 = new Student(5, "Jeevan", "Pune");
        Student s2 = new Student(7, "Jeevan", "Pune");
        Student s3 = new Student(8, "Jeevan", "Pune");
        Future<Student> f1 = service.submit(new StudentCallable(s1));
        Future<Student> f2 = service.submit(new StudentCallable(s2));
        Future<Student> f3 = service.submit(new StudentCallable(s3));

        System.out.println("Student s1 object  " + f1.get().id);
        System.out.println("Student s2 object  " + f2.get().id);
        System.out.println("Student s3 object  " + f3.get().id);
        service.shutdown();
    }
}


class Student {
    public int id;
    public String name;
    public String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

class StudentCallable implements Callable<Student> {
    public Student student;

    public StudentCallable(Student student) {
        this.student = student;

    }

    @Override
    public Student call() throws Exception {
        int result = student.getId() * 10;
        student.setId(result);
        return student;
    }
}
