import java.util.InputMismatchException;

public class Calculator {

    public static char defineOperation(String userInput) {
        char[] uchar = new char[27];

        for (int i = 0; i < userInput.length(); i++) {
            uchar[i] = userInput.charAt(i);
            if (uchar[i] == '+') {
                return  '+';
            }
            if (uchar[i] == '-') {
                return  '-';
            }
            if (uchar[i] == '*') {
                return  '*';
            }
            if (uchar[i] == '/') {
                return  '/';
            }
        }
        throw new InvalidInputException("Invalid operation!");
    }

    public static String calculateSumOrSubtraction(String num1, String num2, char op, String result) {

        switch (op) {

            case '+':
                result = num1 + num2;
                break;
            case '-':
                if (num1.contains(num2)) {
                    int resultA = num1.length() - num2.length();
                    result = num1.substring(0, resultA);
                } else {
                    result = num1;
                }
                break;
            case '*':
                System.out.println("Неверный знак операции * (введите + или -)");
                break;
            case '/':
                System.out.println("Неверный знак операции / (введите + или -)");

                break;
            default:
                throw new IllegalArgumentException("Не верный знак операции");
        }
        return result;
    }

    public static String calculateMultiplicationOrDivision(String num1, int num, char op, String result) {

        switch (op) {
            case '+':
                System.out.println("Неверный знак операции + (введите * или /)");

                break;
            case '-':
                System.out.println("Неверный знак операции - (введите * или /)");
                break;
            case '*':

                for (int u = 0; u < num; u++) {
                    result = result + num1;
                }
                break;
            case '/':
                try {
                    int resultB = num1.length() / num;
                    result = num1.substring(0, resultB);
                } catch (ArithmeticException | InputMismatchException e) {
                    System.out.println("Exception : " + e);
                    System.out.println("Only integer non-zero parameters allowed");
                    break;
                } finally {
                    if (num1.length() < num) {
                        System.out.println("Делимое меньше делителя");
                    }
                }
                break;
            default:
                throw new IllegalArgumentException("Не верный знак операции");
        }
        return result;
    }
}
