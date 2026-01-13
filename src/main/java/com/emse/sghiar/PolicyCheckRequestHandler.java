package com.emse.sghiar;

public class PolicyCheckRequestHandler extends RequestHandler {

    public PolicyCheckRequestHandler(RequestHandler successor) {
        super(successor);
    }

    @Override
    public void handleRequest(WebRequest request) {
        String path = request.getPath();
        User user = request.getLoggedUser();

        if ("/dashboard".equals(path) && !user.isAdmin()) {
            System.out.println("Status 403 : user is not authorized to access this content");
        } else if (successor != null) {
            successor.handleRequest(request);
        }
    }
}
