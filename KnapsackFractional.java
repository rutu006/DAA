import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class KnapsackFractional {

    public static double fractionalKnapsack(double[] weights, double[] values, double capacity, int[] objectNumbers) {
        int n = weights.length;
        Double[][] ratios = new Double[n][2];

        for (int i = 0; i < n; i++) {
            ratios[i][0] = values[i] / weights[i]; // Ratio of value to weight
            ratios[i][1] = weights[i]; // Weight
        }

        Arrays.sort(ratios, new Comparator<Double[]>() {
            @Override
            public int compare(Double[] a, Double[] b) {
                return Double.compare(b[0], a[0]); // Sort in descending order of ratios //position of b and a
            }
        });

        double totalValue = 0.0;
        double remainingCapacity = capacity;

        for (int i = 0; i < n; i++) {
            double ratio = ratios[i][0];
            double weight = ratios[i][1];

            if (remainingCapacity >= weight) {
                totalValue += ratio * weight;
                remainingCapacity -= weight;
                objectNumbers[i] = i + 1; // Store object number
            } else {
                double fraction = remainingCapacity / weight;
                totalValue += ratio * remainingCapacity;
                objectNumbers[i] = i + 1; // Store object number
                break;
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the total number of elements: ");
        int n = scanner.nextInt();

        double[] weights = new double[n];
        double[] values = new double[n];
        int[] objectNumbers = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter the weight of the " + (i + 1) + "th element: ");
            weights[i] = scanner.nextDouble();
            System.out.print("Enter the value of the " + (i + 1) + "th element: ");
            values[i] = scanner.nextDouble();
        }

        System.out.print("Enter the capacity: ");
        double capacity = scanner.nextDouble();

        double maxValue = fractionalKnapsack(weights, values, capacity, objectNumbers);
        System.out.println("Maximum value that can be obtained is: " + maxValue);

        System.out.print("Selected objects: ");
        for (int i = 0; i < n; i++) {
            if (objectNumbers[i] > 0) {
                System.out.print(objectNumbers[i] + " ");
            }
        }

        scanner.close();
    }
}
