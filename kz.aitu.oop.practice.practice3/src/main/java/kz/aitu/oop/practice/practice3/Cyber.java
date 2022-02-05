package kz.aitu.oop.practice.practice3;

public class Cyber implements Employee{
    private String name;
    private int level, period;
    public Cyber(String name, int level, int period){
        this.name = name;
        this.level = level;
        this.period = period;
    }


    private int salary = 25000;
    private int total = salary;

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public int getPeriod() {
        return period;
    }

    @Override
    public int getSalary() {
        return this.salary * this.level;
    }

    @Override
    public int getTotal() {
        return this.total * this.level * this.period;
    }

    @Override
    public String getName() {
        return name;
    }

}
