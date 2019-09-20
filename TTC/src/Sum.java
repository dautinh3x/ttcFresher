import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        System.out.println("Input n = ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println("Sum = " + sum(n));
    }

    public static double sum(int n) {
        double sum;
        sum = (n*(n+1))/2;
        return sum;
    }
}
