package kz.aitu.oop.practice.practice3;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.Scanner;

public class main {
    private static final String URL = "jdbc:mysql://localhost:3306/java";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    public static void main(String[] args){
        Connection connection;
        try {
            Scanner scanner = new Scanner(System.in);
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);

            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            int DO;
            while (true){
                System.out.println("1 to create team for project, 2 to add employee to company.");
                DO = scanner.nextInt();
                boolean h1 = true;
                switch (DO){
                    case 1:
                        ResultSet resultSet = statement.executeQuery("select * from project");
                        String[] searchjob = new String[100];
                        int[] searchlevel = new int[100];
                        int[] searchperiod = new int[100];
                        int n = 0;
                        while (resultSet.next()) {

                            searchjob[n] = resultSet.getString(3);
                            searchlevel[n] = resultSet.getInt(4);
                            searchperiod[n] = resultSet.getInt(5);
                            System.out.println(searchjob[n] + searchlevel[n] + searchperiod[n]);
                            n++;
                        }
                        /*ResultSet resultSet2 = statement.executeQuery("select name, total from " + searchjob[0] + " where level = " + searchlevel[0] + " and period = " + searchperiod[0] + " and status = 'free';");
                        while (resultSet2.next()) {
                            String searchname = resultSet2.getString(1);
                            int searchtotal = resultSet2.getInt(2);
                            System.out.println(searchname + " " + searchtotal);
                        }*/
                        for (int i = 0; i <= n; i++){
                            ResultSet resultSet2 = statement.executeQuery("select name, total from " + searchjob[i] + " where level = " + searchlevel[i] + " and period = " + searchperiod[i] + " and status = 'free';");
                            while (resultSet2.next()) {
                                String searchname = resultSet2.getString(1);
                                int searchtotal = resultSet2.getInt(2);
                                System.out.println(searchname + " " + searchtotal);
                                statement.executeUpdate("update project set " + "name= '" + searchname + "', total = " + searchtotal + " where job = '" + searchjob[i] + "' and level=" + searchlevel[i] + " and period = " + searchperiod[i] + ";");
                                //statement.executeUpdate("update " + searchjob[i] + " set status = 'in duty'" + " where level = " + searchlevel[i] + " and period = " + searchperiod[i] + " and status = 'free';");
                                System.out.println("Name: " + searchname + " Job: " + searchjob[i] + " level: " + searchlevel[i] + " period: " + searchperiod[i] + " total: " + searchtotal);
                            }
                                /*ResultSet resultSet2 = statement.executeQuery("select name, total from " + searchjob[i] + " where level = " + searchlevel[i] + " and period = " + searchperiod[i] + " and status = 'free';");
                                String searchname = resultSet2.getString(1);
                                int searchtotal = resultSet2.getInt(2);
                                statement.executeUpdate("update project" + "name= '" + searchname + "', total = " + searchtotal + " where level = " + searchlevel[i] + " and period = " + searchperiod[i] + ";");
                                statement.executeUpdate("update" + searchjob[i] + "status = 'in duty'" + " where level = " + searchlevel[i] + " and period = " + searchperiod[i] + " and status = 'free';");
                                System.out.println("Name: " + searchname + " Job: " + searchjob[i] + " level: " + searchlevel[i] + " period: " + searchperiod[i] + " total: " + searchtotal);*/
                            }


                        break;
                    case 2:
                        while(h1 == true) {
                            int act = scanner.nextInt();
                            String name;
                            int salary;
                            int total;
                            int level;
                            int period;
                            Employee rabotnik;
                            switch (act){
                                case 1:
                                    name = scanner.next();
                                    level = scanner.nextInt();
                                    period = scanner.nextInt();
                                    rabotnik = new Data(name, level, period);
                                    salary = rabotnik.getSalary();
                                    total = rabotnik.getTotal();
                                    statement.executeUpdate("insert into data (name, level, period, salary, total) values ('" + name + "'," + level + "," + period + "," + salary + "," + total + ");");
                                    break;
                                case 2:
                                    name = scanner.next();
                                    level = scanner.nextInt();
                                    period = scanner.nextInt();
                                    rabotnik = new Frontend(name, level, period);
                                    salary = rabotnik.getSalary();
                                    total = rabotnik.getTotal();
                                    statement.executeUpdate("insert into frontend (name, level, period, salary, total) values ('" + name + "'," + level + "," + period + "," + salary + "," + total + ");");
                                    break;
                                case 3:
                                    name = scanner.next();
                                    level = scanner.nextInt();
                                    period = scanner.nextInt();
                                    rabotnik = new Cyber(name, level, period);
                                    salary = rabotnik.getSalary();
                                    total = rabotnik.getTotal();
                                    statement.executeUpdate("insert into cyber (name, level, period, salary, total) values ('" + name + "'," + level + "," + period + "," + salary + "," + total + ");");
                                    break;
                                case 4:
                                    name = scanner.next();
                                    level = scanner.nextInt();
                                    period = scanner.nextInt();
                                    rabotnik = new Backend(name, level, period);
                                    salary = rabotnik.getSalary();
                                    total = rabotnik.getTotal();
                                    statement.executeUpdate("insert into backend (name, level, period, salary, total) values ('" + name + "'," + level + "," + period + "," + salary + "," + total + ");");
                                    break;
                                case 5:
                                    name = scanner.next();
                                    level = scanner.nextInt();
                                    period = scanner.nextInt();
                                    rabotnik = new Lawyer(name, level, period);
                                    salary = rabotnik.getSalary();
                                    total = rabotnik.getTotal();
                                    statement.executeUpdate("insert into lawyer (name, level, period, salary, total) values ('" + name + "'," + level + "," + period + "," + salary + "," + total + ");");
                                    break;
                                case 6:
                                    name = scanner.next();
                                    level = scanner.nextInt();
                                    period = scanner.nextInt();
                                    rabotnik = new Marketology(name, level, period);
                                    salary = rabotnik.getSalary();
                                    total = rabotnik.getTotal();
                                    statement.executeUpdate("insert into marketology (name, level, period, salary, total) values ('" + name + "'," + level + "," + period + "," + salary + "," + total + ");");
                                    break;
                                default:
                                    h1 = false;
                                    break;
                            }
                        }
                    default:
                        System.exit(0);
                        break;
                }
            }

        } catch (SQLException e) {
            System.err.println("Fail");
        }
    }
}
