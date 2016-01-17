package io.netty.example.securechat;

import io.netty.handler.ssl.OpenSsl;

public class Main {

    public static void main(String[] args) throws Exception {

        System.out.println(OpenSsl.unavailabilityCause());
        System.out.println(OpenSsl.versionString());

        
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    SecureChatServer.main(null);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        }).start();
        ;

        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    SecureChatClient.main(null);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        }).start();
        ;

        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    SecureChatClient.main(null);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        }).start();
        ;

    }

}
