import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        int numberPeople;
        System.out.println("На скольких человек необходимо разделить счёт?");

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

        System.out.println("Введите название товара и его стоимость.");
        do {
            System.out.println("Название:");
            String name = scanner.next();
            System.out.println("Cтоимость:");
            double price;

            while (true) {
                try {
                    price = Double.parseDouble(scanner.next());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Некорректное значение, пожалуйста повторите ввод.");
                }
            }

            calculator.addProduct(new Product(name, price));
            System.out.println("Товар успешно добавлен.\nХотите добавить еще один товар? ");
        } while (!scanner.next().equalsIgnoreCase("Завершить"));

        calculator.printListProduct();
        System.out.println("Количество гостей: " + numberPeople);
        System.out.println("Общая сумма: " + Formatter.format(calculator.totalAmount()));
        System.out.println("Сумма к оплате на каждого гостя: "
                + Formatter.format(calculator.amountGuest(numberPeople)));
        scanner.close();
    }
}
