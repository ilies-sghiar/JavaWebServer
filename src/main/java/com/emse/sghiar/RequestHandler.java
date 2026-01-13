package com.emse.sghiar;

public abstract class RequestHandler {

    protected RequestHandler successor;

    public void handleRequest(WebRequest webRequest){};

    public RequestHandler(RequestHandler successor){
        this.successor = successor;
    }

}
