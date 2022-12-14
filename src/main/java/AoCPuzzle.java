import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class AoCPuzzle {
    private int part = 1;
    private long timerStart;

    public AoCPuzzle(String day) {
        File file = new File("res/day" + day + ".txt");
        if (!file.exists()) {
            solve(new ArrayList<>());
            return;
        }

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            System.err.println("File not found!!");
            solve(new ArrayList<>());
            return;
        }

        List<String> inputLines = new ArrayList<>();
        try {
            String line;
            while ((line = reader.readLine()) != null)
                inputLines.add(line);

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        timerStart = System.nanoTime();
        solve(inputLines);
    }

    abstract void solve(List<String> input);

    public void lap(long answer) {
        lap(String.valueOf(answer));
    }

    public void lap(String answer) {
        long timeSpent = (System.nanoTime() - timerStart) / 1000;
        if (timeSpent < 1000)
            System.out.println("Part " + part + ": " + answer + ", Duration: " + timeSpent + "µs");
        else if (timeSpent < 1000000)
            System.out.println("Part " + part + ": " + answer + ", Duration: " + (timeSpent / 1000.0) + "ms");
        else
            System.out.println("Part " + part + ": " + answer + ", Duration: " + (timeSpent / 1000000.0) + "s");
        timerStart = System.nanoTime();
        part++;
    }

    public List<Integer> convertToInts(List<String> input) {
        List<Integer> ints = new ArrayList<>();
        for (String s : input)
            ints.add(Integer.parseInt(s));
        return ints;
    }

    public List<Long> convertToLongs(List<String> input) {
        List<Long> ints = new ArrayList<>();
        for (String s : input)
            ints.add(Long.parseLong(s));
        return ints;
    }
}
