package com.emse.sghiar;

import java.util.HashSet;
import java.util.Set;

public class ExistingContentCheckRequestHandler extends RequestHandler {

    private static final Set<String> validPaths = new HashSet<>();

    static {
        validPaths.add("/home");
        validPaths.add("/dashboard");
    }

    public ExistingContentCheckRequestHandler(RequestHandler successor){
        super(successor);
    }

    @Override
    public void handleRequest(WebRequest request) {
        if (!validPaths.contains(request.getPath())) {
            System.out.println("Status 404 : Page missing");
        } else if (this.successor != null) {
            this.successor.handleRequest(request);
        }
    }

}
