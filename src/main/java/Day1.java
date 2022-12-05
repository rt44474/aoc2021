import java.util.List;

public class Day1 extends AoCPuzzle {

    public Day1() {
        super("1");
    }

    @Override
    void solve(List<String> input) {
        int measurementsLarger = -1;
        int startingMeasurement = 0;
        for (String s : input) {
            int measurement = Integer.parseInt(s);
            if (measurement > startingMeasurement) {
                measurementsLarger++;
            }
            startingMeasurement = measurement;
        }

        System.out.println("Day 1 First Answer: " + measurementsLarger);


        measurementsLarger = 0;
        int first = Integer.parseInt(input.get(0));
        int second = Integer.parseInt(input.get(1));
        int third = Integer.parseInt(input.get(2));
        startingMeasurement = first + second + third;
        for (int i = 1; i < input.size(); i++) {
            try {
                first = Integer.parseInt(input.get(i));
                second = Integer.parseInt(input.get(i + 1));
                third = Integer.parseInt(input.get(i + 2));
                int secondSum = first + second + third;
                if (startingMeasurement < secondSum) {
                    measurementsLarger++;
                }
                startingMeasurement = secondSum;

            } catch (IndexOutOfBoundsException e) {
                break;
            }
        }

        System.out.println("Day 1 Second Answer: " + measurementsLarger);
    }
}
