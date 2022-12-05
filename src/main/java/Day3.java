import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day3 extends AoCPuzzle {

    public Day3() {
        super("3");
    }

    @Override
    void solve(List<String> input) {
        List<Integer> listOfZeros = new ArrayList<>(Collections.nCopies(input.get(0).length(), 0));
        List<Integer> listOfOnes = new ArrayList<>(Collections.nCopies(input.get(0).length(), 0));

        for (String s : input) {
            char[] stringToChars = s.toCharArray();
            for (int i = 0; i < stringToChars.length; i++) {
                if ((int) stringToChars[i] == 48) {
                    listOfZeros.set(i, listOfZeros.get(i) + 1);
                } else {
                    listOfOnes.set(i, listOfOnes.get(i) + 1);
                }
            }
        }
        StringBuilder binary = new StringBuilder();
        StringBuilder reversedBinary = new StringBuilder();
        for (int i = 0; i < listOfZeros.size(); i++) {
            if (listOfZeros.get(i) > listOfOnes.get(i)) {
                binary.append("0");
                reversedBinary.append("1");
            } else {
                binary.append("1");
                reversedBinary.append("0");
            }
        }
        int gammaRate = Integer.parseInt(binary.toString(), 2);
        int epsilonRate = Integer.parseInt(reversedBinary.toString(), 2);
        int result = gammaRate * epsilonRate;

        System.out.println("Day 3 First Answer: " + result);


    }
}
