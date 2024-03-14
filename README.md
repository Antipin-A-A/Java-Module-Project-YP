import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        CalculatorMenu calculatorMenu = new CalculatorMenu();

        Scanner scanner = new Scanner(System.in);
        System.out.println("На скольких человек необходимо разделить счёт.");
        int person = 0;

        while (true) {
            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                if (number >= 0) {
                    System.out.println("Колличество человек = " + number);
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
        System.out.println("Колличество человек после = " + person);
        calculatorMenu.start();
        calculatorMenu.costOfOrder(person);
    }
}

class CalculatorMenu {
    HashMap<String, Double> menu = new HashMap<>();

    Scanner scanner = new Scanner(System.in);

    double sum = 0;

    public void start() {
        while (true) {
            System.out.println("Введите название товара");
            String menuSting = scanner.next();
            if (menuSting.equalsIgnoreCase("Завершить")) {
                break;
            } else {
                System.out.println("Введите стоимость товара руб,коп");
                if (scanner.hasNextDouble()) {
                    double priceInt = scanner.nextDouble();
                    if (priceInt > 0) {
                        menu.put(menuSting, priceInt);
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
        for (Double i : menu.values()) { // сложение значейний value
            sum += i;
        }
        System.out.println("Добавленные товары:");
        for (String key : menu.keySet()) {
            System.out.println(key);
        }
    }

    public void costOfOrder(int person) {
        double priseFoPerson = sum / person;
        if (priseFoPerson <= 1.99) {
            System.out.printf("Стоимость покупки с человека: %.2f рубль", priseFoPerson);
        } else if (priseFoPerson >= 5) {
            System.out.printf("Стоимость покупки с человека: %.2f рублей", priseFoPerson);
        } else {
            System.out.printf("Стоимость покупки с человека: %.2f рубля", priseFoPerson);
        }
    }
}


