import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    static List<List<Integer>> left;
    static List<List<Integer>> right;
    static Integer result(Integer n) {
        return (int) Math.pow(2, n-1);
    }
    public static void main(String[] argc) throws Exception {
        left = new ArrayList<>();
        right = new ArrayList<>();
        File leftFile = new File("left.final");
        File rightFile = new File("right.final");

        BufferedReader bufferedReaderLeft = new BufferedReader(new FileReader(leftFile));
        BufferedReader bufferedReaderRight = new BufferedReader(new FileReader(rightFile));

        String line;
        while( (line = bufferedReaderLeft.readLine()) != null) {
            Scanner scanner = new Scanner(line);
            List<Integer> thisOne = new ArrayList<>();
            while (scanner.hasNextInt()) {
                thisOne.add(scanner.nextInt());
            }
            left.add(thisOne);
        }
        while( (line = bufferedReaderRight.readLine()) != null ) {
            Scanner scanner = new Scanner(line);
            List<Integer> thisOne = new ArrayList<>();
            while(scanner.hasNextInt()) {
                thisOne.add(scanner.nextInt());
            }
            right.add(thisOne);
        }

        List<Integer> answer = new ArrayList<>(Collections.nCopies(left.size(),1));
        for (int i = 0; i < left.size(); i++) {
            Integer count = 0;
            for (int j = 0; j < left.get(i).size(); j++) {
                if(right.get(i).contains(left.get(i).get(j))) count++;
            }
            for (int j = 0; j < count; j++) {
                answer.set(i + j + 1, answer.get(i + j + 1) + answer.get(i));
            }
        }
        System.out.println(answer.toString());
        Integer sum = 0;
        for (int i = 0; i < answer.size(); i++) {
            sum += answer.get(i);
        }
        System.out.println("sum = " + sum);
    }
}
