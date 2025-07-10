package Observable;

import Observer.NotificationAlertObserver;

import java.util.ArrayList;
import java.util.List;

public class ProductObservableImpl implements StockObservable{
    public List<NotificationAlertObserver> observersList = new ArrayList<>();
    public int stock = 0;

    @Override
    public void add(NotificationAlertObserver notificationAlertObserver) {
        observersList.add(notificationAlertObserver);
    }

    @Override
    public void remove(NotificationAlertObserver notificationAlertObserver) {
        observersList.remove(notificationAlertObserver);
    }

    @Override
    public void notifyObservers() {
        for(NotificationAlertObserver observer: observersList)
            observer.update();
    }

    @Override
    public void setStock(int newStock) {
        if(stock == 0)
        {
            notifyObservers();
        }
        stock += newStock;
    }

    @Override
    public int getStock() {
        return stock;
    }
}
