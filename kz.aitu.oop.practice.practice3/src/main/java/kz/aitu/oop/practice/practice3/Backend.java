package kz.aitu.oop.practice.practice3;

public class Backend implements Employee{
    private String name;
    private int level, period;
    private int salary = 20000, total = salary;
    public Backend(String name, int level, int period){
        this.name = name;
        this.level = level;
        this.period = period;
    }
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
        return salary * this.level;
    }

    @Override
    public int getTotal() {
        return total * period * level;
    }

    @Override
    public String getName() {
        return name;
    }
}
