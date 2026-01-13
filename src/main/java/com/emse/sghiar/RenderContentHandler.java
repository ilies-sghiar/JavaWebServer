package com.emse.sghiar;

public class RenderContentHandler extends RequestHandler{

    public RenderContentHandler(){
        super(null);
    }
    
    @Override
    public void handleRequest(WebRequest request) {
        String path = request.getPath();
        switch (path) {
            case "/home":
                System.out.println("Status 200 : Home content here");
                break;
            case "/dashboard":
                System.out.println("Status 200 : Dashboard content here");
                break;
        }
    }
}
