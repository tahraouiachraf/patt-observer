package org.sid;

import obs.*;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        ObservableImpl observable = new ObservableImpl();
        Observer o1 = new ObserverImpl1();
        Observer o2 = new ObserverImpl2();
        observable.subscribe(o1);
        observable.subscribe(o2);

        observable.subscribe((obs) -> {
            if (obs instanceof ObservableImpl o) {
                System.out.println("******** OBS Impl 3 ***********");
                System.out.println("Res = " + o.getState() * Math.cos(o.getState()));
                System.out.println("******** OBS Impl 3 ***********");
            }
        });

        observable.setState(60);
        observable.setState(80);
        observable.unsubscribe(o2);
        observable.setState(100);

        Button button = new Button("Ok");
        button.addActionListener(e -> {
            System.out.println(e.getSource());
        });
    }
}