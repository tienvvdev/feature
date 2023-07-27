import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VietnameseCharactersCounter {
    public static int countVietnameseCharacters(String input) {
        String[] telexMapping = {"aw", "aa", "dd", "ee", "oo", "ow", "w"};

        int count = 0;
        int index = 0;
        while (index < input.length()) {
            boolean formed = false;
            for (String telex : telexMapping) {
                if (input.regionMatches(index, telex, 0, telex.length())) {
                    count++;
                    index += telex.length();
                    formed = true;
                    break;
                }
            }
            if (!formed) {
                index++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập chuỗi chữ cái Latinh: ");
        String input = scanner.nextLine();
        scanner.close();

        int result = countVietnameseCharacters(input);
        System.out.println("Số lượng chữ cái Tiếng Việt có thể tạo thành trong chuỗi đó là : " + result);
    }
}
