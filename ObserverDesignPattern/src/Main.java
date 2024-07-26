import Observable.ProductObservableImpl;
import Observable.StockObservable;
import Observer.EmailAlertObserverImpl;
import Observer.MobileAlertObserverImpl;
import Observer.NotificationAlertObserver;

public class Main {
    public static void main(String[] args) {

        StockObservable productObservable = new ProductObservableImpl();

        NotificationAlertObserver observer1 = new MobileAlertObserverImpl("8984036", productObservable);
        NotificationAlertObserver observer2 = new EmailAlertObserverImpl("xys@aghl.com", productObservable);

        productObservable.add(observer1);
        productObservable.add(observer2);

        productObservable.setStock(10);
    }
}