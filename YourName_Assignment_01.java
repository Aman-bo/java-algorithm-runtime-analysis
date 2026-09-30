import java.util.Date;

public class YourName_Assignment_01 {

    private static final int[] toSum = {10, 100, 1000, 10000, 100000, 1000000};
    private static final long[] timeOfA = new long[toSum.length];
    private static final long[] timeOfB = new long[toSum.length];
    private static final long[] timeOfC = new long[toSum.length];

    public static void main(String[] args) {
        System.out.println("CS2050 Assignment-01");
        
        for (int i = 0; i < toSum.length; i++) {
            int n = toSum[i];
            timeOfA[i] = measureTimeMilliseconds(() -> algorithmA(n));
            timeOfB[i] = measureTimeMilliseconds(() -> algorithmB(n));
            timeOfC[i] = measureTimeMilliseconds(() -> algorithmC(n));
        }

        displayResults();
    }

    public static long measureTimeMilliseconds(Runnable algorithm) {
        Date start = new Date();
        algorithm.run();
        Date end = new Date();
        return end.getTime() - start.getTime(); // Milliseconds
    }

    public static int algorithmA(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum = sum + i;
        }
        return sum;
    }

    public static int algorithmB(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                sum = sum + 1;
            }
        }
        return sum;
    }

    public static int algorithmC(int n) {
        return n * (n + 1) / 2;
    }
   // I used Ai to help me with the spacing between the numbers in the display because before it display the 
   // numbers close together and it was confusing which number was in which column I thought I had to only
    // put space between the "" and + to make space in the print and the Ai gave me this part %-10s %-20s %-20s %-20s%n 
    //of the code 
    public static void displayResults() {
        System.out.printf("%-10s %-20s %-20s %-20s%n", "N", "Time A (ms)", "Time B (ms)", "Time C (ms)");
        for (int i = 0; i < toSum.length; i++) {
            System.out.printf("%-10d %-20d %-20d %-20d%n", toSum[i], timeOfA[i], timeOfB[i], timeOfC[i]);
        }
    }
}
