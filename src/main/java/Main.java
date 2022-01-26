import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int number;
    static char operation;
    static String result = "";

    public static void main(String[] args) {
        System.out.println("Введите выражение [\"a\" + \"b\", \"a\" - \"b\", \"a\" * x, \"a\" / x] где a и b - строки а x - число  от 1 до 10 включительно  + Enter ");

        String userInput = scanner.nextLine();

        operation = Calculator.defineOperation(userInput);

        ExpressionValidator.validateExpression(userInput);

        String[] blocks = userInput.split("[+-/*\"]");

        if (blocks.length == 5) {
            String st01 = blocks[1].trim();
            String st04 = blocks[4].trim();
            result = Calculator.calculateSumOrSubtraction(st01, st04, operation, result);
        } else {
            String st01 = blocks[1].trim();
            String st03 = blocks[3].trim();
            number = Integer.parseInt(st03);
            result = Calculator.calculateMultiplicationOrDivision(st01, number, operation, result);
        }
        if (result.length() > 40) {
            result = result.substring(0, 39) + "...";
        }
        System.out.println(result);
    }

}
