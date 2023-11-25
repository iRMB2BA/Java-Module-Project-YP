import java.util.ArrayList;

public class Calculator {
    ArrayList<Product> listProduct = new ArrayList<>();

    public void addProduct(Product product) {
        listProduct.add(product);
    }

    public double amountGuest(int n) {
        double sum = 0;
        for (Product i : listProduct) {
            sum += i.getPrice();
        }
        return sum / n;
    }

    public double totalAmount() {
        double sum = 0;
        for (Product i : listProduct) {
            sum += i.getPrice();
        }
        return sum;
    }

    public void printListProduct() {
        int index = 1;
        System.out.println("Добавленные товары:\n-------------------");

        for (Product i : listProduct) {
            System.out.println(index++ + ": " + i.getName() + "    " + Formatter.floorCount(i.getPrice()));
        }

        System.out.println("-------------------");
    }
}
