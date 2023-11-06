import java.util.Scanner;
/*Input: N = 3, W = 4, profit[] = {1, 2, 3}, weight[] = {4, 5, 1}
Output: 3*/
public class Knapsack0_1 {

    public static int knapSack(int capacity, int[] wt, int[] val, int n) {
        int[][] K = new int[n + 1][capacity + 1];

        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (i == 0 || w == 0) {
                    K[i][w] = 0;
                } else if (wt[i - 1] <= w) {
                    K[i][w] = Math.max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
                } else {
                    K[i][w] = K[i - 1][w];
                }
            }
        }

        System.out.println("DP table is:");
        for (int i = 0; i <= n; i++) {
            System.out.println();
            for (int j = 0; j <= capacity; j++) {
                System.out.print(K[i][j] + " ");
            }
            System.out.println();
        }

        return K[n][capacity];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();

        int[] profit = new int[n];
        int[] weight = new int[n];

        System.out.println("Enter the profit of each element:");
        for (int i = 0; i < n; i++) {
            profit[i] = scanner.nextInt();
        }

        System.out.println("Enter the weight of each element:");
        for (int i = 0; i < n; i++) {
            weight[i] = scanner.nextInt();
        }

        System.out.print("Enter max capacity: ");
        int W = scanner.nextInt();

        long startTime = System.currentTimeMillis();
        System.out.println("Max profit is: " + knapSack(W, weight, profit, n));
        long endTime = System.currentTimeMillis();

        System.out.println("Time required to execute the program is: " + (endTime - startTime) + " milliseconds");

        scanner.close();
    }
}
