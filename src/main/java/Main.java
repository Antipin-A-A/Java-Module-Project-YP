import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        CalculatorMenu calculatorMenu = new CalculatorMenu();
        calculatorMenu.countPerson();
        calculatorMenu.menu();
        calculatorMenu.costOfOrder();

    }
}

class CalculatorMenu {
    HashMap<String, Double> menu = new HashMap<>();

    private final Scanner scanner = new Scanner(System.in);
    private int person = 1;

    private double sum = 0;

    public void menu() {
        while (true) {
            System.out.println("Введите название товара");
            String menuSting = scanner.next();
            if (menuSting.equalsIgnoreCase("Завершить")) {
                break;
            } else {
                System.out.println("Введите стоимость товара руб,коп");
                if (scanner.hasNextDouble()) {
                    double priceDouble = scanner.nextDouble();
                    if (priceDouble > 0) {
                        menu.put(menuSting, priceDouble);
                        System.out.println("Товар успешно добавлен");
                        System.out.println("Хотите еще добавить товар? если нет введите 'Завершить'");
                    } else
                        System.out.println("Стоимость не должна быть отрицательной");
                } else {
                    System.out.println("Некорректный ввод данных, форма ввода стоимости '0,00'");
                    scanner.next();
                }
            }
        }

        for (Double i : menu.values()) { // сложение значейний value, общая стоимость
            sum += i;
        }
        System.out.println("Добавленные товары:");
        for (String key : menu.keySet()) {
            System.out.println(key);
        }
    }

    public void costOfOrder() {
        String[] stringRub = {"рубль", "рубля", "рублей"};
        double priseFoPerson = sum / person; //  расчет стоимости с каждого клиента
        if (priseFoPerson % 100 >= 5 && priseFoPerson % 100 < 20.99) {
            System.out.printf("Стоимость  покупки с человека: %.2f %s", priseFoPerson, stringRub[2]);
        } else if (priseFoPerson % 10 >= 1.00 && priseFoPerson % 10 < 2) {
            System.out.printf("Стоимость  покупки с человека: %.2f %s", priseFoPerson, stringRub[0]);
            ;
        } else if (priseFoPerson % 10 >= 2 && priseFoPerson % 10 < 5) {
            System.out.printf("Стоимость  покупки с человека: %.2f %s", priseFoPerson, stringRub[1]);
            ;
        } else System.out.printf("Стоимость  покупки с человека: %.2f %s", priseFoPerson, stringRub[2]);
        ;
    }

    public void countPerson() {
        System.out.println("На скольких человек необходимо разделить счёт.");
        while (true) {
            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                if (number >= 0) {
                    person = number;
                    break;
                } else {
                    System.out.println("Введите число > 0");
                }
            } else {
                System.out.println("некорректное значение для подсчёта, введите положительное число ");
                scanner.next();
            }
        }
        System.out.println("Колличество человек = " + person);
    }
}
