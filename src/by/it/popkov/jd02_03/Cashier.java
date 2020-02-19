package by.it.popkov.jd02_03;

import java.io.PrintStream;
import java.util.Map;

class Cashier implements Runnable {
    private final Object monitorCashier;

    private String name;

    private BuyerQueue buyerQueue;
    private Dispatcher dispatcher;

    public Cashier(int num, BuyerQueue buyerQueue, Object monitorCashier, Dispatcher dispatcher) {
        name = "Cashier " + num;
        this.buyerQueue = buyerQueue;
        this.monitorCashier = monitorCashier;
        this.dispatcher = dispatcher;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void run() {
        while (!dispatcher.marketIsClosed()) {
            Buyer pensioner = buyerQueue.getFirstPensioner();
            if (pensioner != null) {
                serve(pensioner);
            } else {
                Buyer buyer = buyerQueue.getFirstBuyer();
                if (buyer != null) {
                    serve(buyer);
                } else {
                    synchronized (monitorCashier) {
                        try {
                            dispatcher.cashierClosed();
                            System.out.println(this + " is closed");
                            monitorCashier.wait();
                            dispatcher.cashierOpened();
                            System.out.println(this + " is opened");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        System.out.println(this + " sent day report and went to home");
    }

    private void serve(Buyer buyer) {
        int sumOfCheck = buyer.getBasket().values().stream().mapToInt(Integer::intValue).sum();
        String tab = "";
        String posBuyerOnline = "";
        System.out.println(this + " start serve " + buyer);
        dispatcher.plusDayProfit(sumOfCheck);
        Helper.delay(Helper.randNum(2000, 5000)); //Time to serve
        String s = buyer.getBasket().toString()
                .replaceAll("[,{}]", "")
                .replaceAll(" ", "\n");
        StringBuffer stringBuffer = new StringBuffer();
        System.out.println(this + " print " + buyer + " check");
        switch (this.name) {
            case "Cashier 1":
                tab = "%10s";
                posBuyerOnline = "%150s";
                break;
            case "Cashier 2":
                tab = "%40s";
                posBuyerOnline = "%120s";
                break;
            case "Cashier 3":
                tab = "%70s";
                posBuyerOnline = "%90s";
                break;
            case "Cashier 4":
                tab = "%100s";
                posBuyerOnline = "%60s";
                break;
            case "Cashier 5":
                tab = "%130s";
                posBuyerOnline = "%30s";
                break;
        }
        stringBuffer.append(String.format(tab + "%-30s" + posBuyerOnline + "%20s" +  "\n","", buyer + " check:",
               "Buyer queue size:" + buyerQueue.getBuyerQueueSize(), "Day profit: " + dispatcher.getDayProfit()));
        for (Map.Entry<String, Integer> entry : buyer.getBasket().entrySet()) {
            stringBuffer.append(String.format(tab + "%-30s" + "\n", "", entry.getKey() + " = " + entry.getValue()));
        }
        stringBuffer.append(String.format(tab + "%-30s" + "\n", "", "SUM: " + sumOfCheck));
        System.out.println(stringBuffer);
//        System.out.println(stringBuffer.toString());
        System.out.println(this + " finished serve " + buyer);
        synchronized (buyer) {
            buyer.notify();
        }
    }
}
