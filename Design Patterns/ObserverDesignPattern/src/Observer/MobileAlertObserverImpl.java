package Observer;

import Observable.StockObservable;

public class MobileAlertObserverImpl implements NotificationAlertObserver{

    String phone;
    StockObservable stockObservable;

    public MobileAlertObserverImpl(String phone, StockObservable stockObservable)
    {
        this.stockObservable = stockObservable;
        this.phone = phone;
    }
    @Override
    public void update() {
        sendMessage(phone, "Hurry up product is back in stock!!");
    }

    private void sendMessage(String phone, String message)
    {
        System.out.println("Message sent to " + phone);
    }
}
