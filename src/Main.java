import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Введите выражение: ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            try {
                String result = calc(input);
                System.out.println(result);
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
    }

    public static String calc(String input) {

        String[] operator = {" + ", " - ", " / ", " * "};
        String[] regexOperator = {" \\+ ", " - ", " / ", " \\* "};


        int operatorIndex = -1;
        for (int i = 0; i < operator.length; i++) {
            if (input.contains(operator[i])) {
                operatorIndex = i;
                break;
            }
        }
        if (operatorIndex == -1) {
            throw new IllegalArgumentException("Введено неккоректное выражение");
        }

        String[] data = input.split(regexOperator[operatorIndex]);
        if (data.length > 2) {
            throw new IllegalArgumentException("Ошибка. Введите два операнда и один оператор (+, -, /, *)");

    }

    Converter converter = new Converter();


        if (converter.isRim(data[0]) == converter.isRim(data[1])) {
            int number1;
            int number2;
            boolean isRim = converter.isRim(data[0]);

            if (isRim) {
                number1 = converter.rimToInt(data[0]);
                number2 = converter.rimToInt(data[1]);
            } else {
                number1 = Integer.parseInt(data[0]);
                number2 = Integer.parseInt(data[1]);
            }


            if (number1 > 10 || number2 > 10) {
                throw new IllegalArgumentException("Принимаются только числа от 1 до 10");

            }
            int result;
            switch (operator[operatorIndex]) {
                case " + ":
                    result = number1 + number2;
                    break;
                case " - ":
                    result = number1 - number2;
                    break;
                case " * ":
                    result = number1 * number2;
                    break;
                default:
                    result = number1 / number2;
                    break;
            }
            if (isRim && (result <= 0)) {
                throw new IllegalArgumentException("Результатом работы калькулятора с римскими числами могут быть только положительные числа.");
            }

            if (isRim) {
                System.out.println(converter.intToRim(result));
            } else {
                System.out.println(result);
            }
        } else {
            throw new IllegalArgumentException("Используются одновременно разные системы счисления");
        }
return "";
    }





    }


