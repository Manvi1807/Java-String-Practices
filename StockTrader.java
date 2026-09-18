import java.util.Scanner;

public class StockTrader {

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int lowestPriceSeenSoFar = prices[0];
        int maxProfitRecorded = 0;

        for (int i = 1; i < prices.length; i++) {
            int currentProfit = prices[i] - lowestPriceSeenSoFar;
            if (currentProfit > maxProfitRecorded) {
                maxProfitRecorded = currentProfit;
            }
            if (prices[i] < lowestPriceSeenSoFar) {
                lowestPriceSeenSoFar = prices[i];
            }
        }

        return maxProfitRecorded;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int totalDays = scanner.nextInt();
            int[] stockPrices = new int[totalDays];
            for (int i = 0; i < totalDays; i++) {
                stockPrices[i] = scanner.nextInt();
            }

            int bestProfit = maxProfit(stockPrices);
            System.out.println(bestProfit);
        } catch (Exception e) {
            System.out.println("Error reading prices: " + e.getMessage());
        }
    }
}