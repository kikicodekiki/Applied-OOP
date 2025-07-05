package Homeworks.Homework_1.com;

public class Stock {
    private String symbol;
    private String name;
    private double previousClosingPrice;
    private double currentPrice;

    Stock(String symbol, String name, double previousClosingPrice, double currentPrice) {
        // using the setter functions for code reusal
        setSymbol(symbol);
        setName(name);
        setPreviousClosingPrice(previousClosingPrice);
        setCurrentPrice(currentPrice);
    }

    Stock(){
        // set with some valid information by calling the other constructor
        this("symbol", "name", 0.0, 0.0);
    }

    Stock(Stock stock) {
        this.symbol = stock.symbol;
        this.name = stock.name;
        this.previousClosingPrice = stock.previousClosingPrice;
        this.currentPrice = stock.currentPrice;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        if (symbol == null || symbol.isEmpty()) {
            this.symbol = "symbol"; // so as to not leave it in an invalid state
            return;
        }
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            this.name = "name";
            return;
        }
        this.name = name;
    }

    public double getPreviousClosingPrice() {
        return previousClosingPrice;
    }

    public void setPreviousClosingPrice(double previousClosingPrice) {
        if (previousClosingPrice < 0.0) {
            this.previousClosingPrice = 0.0;
            return;
        }
        this.previousClosingPrice = previousClosingPrice;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        if (currentPrice < 0.0) {
            this.currentPrice = 0.0;
            return;
        }
        this.currentPrice = currentPrice;
    }

    public double changePercent(){
        // Returns the percetage of the difference compared to the previous closing price
        return ((currentPrice - previousClosingPrice) / previousClosingPrice) * 100.0;
    }
}
