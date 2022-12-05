import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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

        String secondResult = "";
        String thirdResult = "";
        List<String> OGR = List.copyOf(input);
        List<String> CSR = List.copyOf(input);
        for (int i = 0; i < binary.length(); i++) {
            if (OGR.size() == 1) {
                secondResult = OGR.get(0);
            }
            if (CSR.size() == 1) {
                thirdResult = CSR.get(0);
            }

            List<String> zeros;
            List<String> ones;
            List<String> zeros1;
            List<String> ones1;
            int finalI = i;
            zeros = OGR.stream().filter(item -> item.charAt(finalI) == '0').collect(Collectors.toList());
            ones = OGR.stream().filter(item -> item.charAt(finalI) == '1').collect(Collectors.toList());
            zeros1 = CSR.stream().filter(item -> item.charAt(finalI) == '0').collect(Collectors.toList());
            ones1 = CSR.stream().filter(item -> item.charAt(finalI) == '1').collect(Collectors.toList());
            if (zeros.size() > ones.size()) {
                OGR = zeros;
            } else {
                OGR = ones;
            }
            if (zeros1.size() > ones1.size()) {
                CSR = ones1;
            } else {
                CSR = zeros1;
            }
        }
        if (OGR.size() == 1) {
            secondResult = OGR.get(0);
        }
        if (CSR.size() == 1) {
            thirdResult = CSR.get(0);
        }


        gammaRate = Integer.parseInt(secondResult, 2);
        epsilonRate = Integer.parseInt(thirdResult, 2);
        result = gammaRate * epsilonRate;

        System.out.println("Day 3 Second Answer: " + result);
    }
}
