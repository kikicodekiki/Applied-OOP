package Homeworks.Homework_1.com;

import java.util.Scanner;

public class StockTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stock stock = new Stock();
        String name, symbol;
        double currPrice, previousClosingPrice;

        System.out.print("Please, enter the name of the stock: ");
        name = scanner.nextLine();
        System.out.print("\nPlease, enter the symbol of the stock: ");
        symbol = scanner.nextLine();
        System.out.print("\nPlease, enter the current price of the stock: ");
        currPrice = scanner.nextDouble();
        System.out.print("\nPlease, enter the previous closing price of the stock: ");
        previousClosingPrice = scanner.nextDouble();

        stock.setName(name);
        stock.setSymbol(symbol);
        stock.setCurrentPrice(currPrice);
        stock.setPreviousClosingPrice(previousClosingPrice);

        System.out.println("\n-----------------------------------------------------------");

        System.out.println("Stock Name: " + stock.getName());
        System.out.println("Stock Symbol: " + stock.getSymbol());
        System.out.println("Stock Current Price: " + stock.getCurrentPrice());
        System.out.println("Stock Previous Closing Price: " + stock.getPreviousClosingPrice());
        System.out.printf("Price change percentage: %.2f", stock.changePercent() );

        System.out.println("\n-----------------------------------------------------------");
        System.out.println("Testing the copy constructor: ");

        Stock copy = new Stock(stock);
        System.out.println("Copy stock name: " + copy.getName());
        System.out.println("Copy stock symbol: " + copy.getSymbol());
        System.out.println("Copy stock current Price: " + copy.getCurrentPrice());
        System.out.println("Copy stock previous Closing Price: " + copy.getPreviousClosingPrice());
        System.out.printf("Price change percentage: %.2f", copy.changePercent() );

        System.out.println("\n-----------------------------------------------------------");

    }
}
