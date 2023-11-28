import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println("На скольких человек необходимо разделить счёт?");
        int numberPeople = getNumberGuest();
        addProduct(calculator);
        calculator.printListProduct();
        System.out.println("Количество гостей: " + numberPeople);
        System.out.println("Общая сумма: " + Formatter.format(calculator.totalAmount()));
        System.out.println("Сумма к оплате на каждого гостя: "
                + Formatter.format(calculator.amountGuest(numberPeople)));
        scanner.close();
    }

    public static int getNumberGuest() {
        int numberPeople;
        do {
            while (true) {
                try {
                    numberPeople = Integer.parseInt(scanner.next());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Некорректное значение, пожалуйста повторите ввод.");
                }
            }

            if (numberPeople == 0 || numberPeople == 1) {
                System.out.println("Ошибка. Количество" +
                        " человек должно быть минимум двое!\n" +
                        "Введите корректное количество гостей:");
            } else if (numberPeople < 0) {
                System.out.println("Ошибка. Количество" +
                        " человек не может быть отрицательным!\n" +
                        "Введите корректное количество гостей:");
            }
        } while (numberPeople <= 1);

        return numberPeople;
    }

    public static void addProduct(Calculator calculator) {
        do {
            System.out.println("Название:");
            String name = scanner.next();
            System.out.println("Cтоимость:");
            double price;

            while (true) {
                try {
                    price = scanner.nextDouble();

                    if (price < 0) {
                        System.out.println("Некорректное значение, пожалуйста повторите ввод.");
                    } else {
                        break;
                    }

                } catch (Exception e) {
                    System.out.println("Некорректное значение, пожалуйста повторите ввод.");
                    scanner.nextLine();
                }


            }

            calculator.addProduct(new Product(name, price));
            System.out.println("Товар успешно добавлен.\nХотите добавить еще один товар? ");
        } while (!scanner.next().equalsIgnoreCase("Завершить"));
    }


}
