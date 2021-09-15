import java.util.Scanner;

class Scratch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("введите два целых для произведения этих чисел");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        float num3 = (float)num1/(1/(float)num2);
        System.out.println(num3);
    }
}