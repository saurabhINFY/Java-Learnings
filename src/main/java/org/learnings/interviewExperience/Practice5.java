package org.learnings.interviewExperience;

class Practice5{
    public static void main(String[] args) {
        Student student = new Student("John", 20, "A");
        Thread t1 = new Thread(()->{
            try {
                System.out.println("Thread 1 is running");
               // Thread.sleep(2000);
                System.out.println("Thread 1 is setting age to 50");
                student.setAge(50);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        Thread t2 = new Thread(()->{
            System.out.println("Thread 2 is running");
            if(student.getAge() < 50) {
                System.out.println("Thread 2 is setting age to 30");
                student.setAge(30);
            }
        });
        System.out.println("Before starting Thread1");
        t1.start();
        System.out.println("After starting Thread1");
        System.out.println("Before starting Thread2");
        t2.start();
        System.out.println("After starting Thread2");
        System.out.println("Log1" + student.getAge());
        System.out.println("Log2" + student.getAge());
    }
}
class Student{
    private String name;
    private int age;
    private String grade;

    public Student(String name, int age, String grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}