package Observable;

import Observer.NotificationAlertObserver;

public interface StockObservable {
    public void add(NotificationAlertObserver notificationAlertObserver);
    public void remove(NotificationAlertObserver notificationAlertObserver);
    public void notifyObservers();
    public void setStock(int newStock);
    public int getStock();
}
