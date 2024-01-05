package util;

import java.util.Scanner;
import java.util.function.IntFunction;

public class InputReader {
    private InputReader() {
    }

    private static String read() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static <T> T readCommandInput(IntFunction<T> resultMapper) {
        T result;
        while (true) {
            try {
                result = resultMapper.apply(Integer.parseInt(read()));
                break;
            } catch (Exception e) {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }

        return result;
    }

    public static <T> T readProductInput(IntFunction<T> resultMapper) {
        T result;
        while (true) {
            try {
                result = resultMapper.apply(Integer.parseInt(read())-1);
                break;
            } catch (Exception e) {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }

        return result;
    }
}
