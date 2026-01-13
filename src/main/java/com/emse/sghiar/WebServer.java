package com.emse.sghiar;

import java.util.ArrayList;
import java.util.List;

public class WebServer implements WebRequestObservable {

    private RequestHandler firstHandler;
    private List<WebRequestObserver> observers = new ArrayList<>();

    public WebServer(RequestHandler firstHandler) {
        this.firstHandler = firstHandler;
    }

    public void getRequest(WebRequest request) {
        notifyObservers(request);
        firstHandler.handleRequest(request);
    }

    @Override
    public void attach(WebRequestObserver observer){
        observers.add(observer);
    }

    @Override
    public void detach(WebRequestObserver observer){
        observers.remove(observer);
    };

    @Override
    public void notifyObservers(WebRequest webRequest){
        for (WebRequestObserver observer : observers) {
            observer.update(webRequest);
        }
    };
}
