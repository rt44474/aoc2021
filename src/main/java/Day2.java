import java.util.List;

public class Day2 extends AoCPuzzle {

    public Day2() {
        super("2");
    }

    @Override
    void solve(List<String> input) {
        int horizontal = 0;
        int depth = 0;

        for (String s : input) {
            String[] split = s.split(" ");
            int number = Integer.parseInt(split[1]);
            if (split[0].equals("forward")) {
                horizontal += number;
            } else if (split[0].equals("up")) {
                depth -= number;
            } else {
                depth += number;
            }
        }
        int res = horizontal * depth;

        System.out.println("Day 2 First Answer: " + res);

        horizontal = 0;
        depth = 0;
        int aim = 0;
        for (String s : input) {
            String[] split = s.split(" ");
            int number = Integer.parseInt(split[1]);
            if (split[0].equals("forward")) {
                horizontal += number;
                depth = depth + (aim * number);
            } else if (split[0].equals("up")) {
                aim -= number;
            } else {
                aim += number;
            }
        }
        res = horizontal * depth;

        System.out.println("Day 2 Second Answer: " + res);
    }
}
