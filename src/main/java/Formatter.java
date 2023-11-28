public class Formatter {
    public static String format(Double price) {
        String resultPrice;
        int floorPrice = (int) Math.floor(price);

        if (floorPrice == 11 || floorPrice % 100 == 11 || floorPrice % 10 >= 5 || floorPrice % 10 == 0) {
            resultPrice = "рублей";
        } else if (floorPrice % 10 == 1) {
            resultPrice = "рубль";
        } else {
            resultPrice = "рубля";
        }

        return floorCount(price) + " " + resultPrice;
    }

    public static String floorCount(double n) {
        return String.format("%.2f", n);
    }
}
