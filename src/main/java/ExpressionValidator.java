public class ExpressionValidator {
    public static void validateExpression(String userInput) {
        if (userInput.length() > 27) {
            System.out.println("String length must be lower then 27!");
            System.exit(1);
        }
        String[] userInputArrayWithSpaceDelimiter = userInput.split("[-+/*]");
        if (!(userInputArrayWithSpaceDelimiter[0].trim().startsWith("\"") && userInputArrayWithSpaceDelimiter[0].trim().endsWith("\""))) {
            throw new InvalidInputException("The first operand must be enclosed in quotes!");
        }
        if (userInputArrayWithSpaceDelimiter[1].trim().startsWith("\"") && userInputArrayWithSpaceDelimiter[1].trim().endsWith("\"")) {
            if (userInputArrayWithSpaceDelimiter[0].length() > 12 || userInputArrayWithSpaceDelimiter[1].length() > 12) {
                throw new InvalidInputException("The operand's length mustn't be bigger than 10!");
            }
        } else {
            int integerOperand = Integer.parseInt(userInputArrayWithSpaceDelimiter[1].trim());
            if (!(integerOperand >= 1 && integerOperand <= 10)) {
                throw new InvalidInputException("If we use digits, they must be in range (1, 10)!");
            }
        }
    }
}
