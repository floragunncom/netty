package io.netty.example.securechat;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;

import io.netty.handler.ssl.OpenSsl;
import io.netty.handler.ssl.SslProvider;

public class Main {
    
    //public final static SslProvider PROVIDER = SslProvider.JDK;
    public final static SslProvider PROVIDER = SslProvider.OPENSSL;

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

    public static File getAbsoluteFilePathFromClassPath(final String fileNameFromClasspath) {
        File file = null;
        final URL fileUrl = Main.class.getClassLoader().getResource(fileNameFromClasspath);
        if (fileUrl != null) {
            try {
                file = new File(URLDecoder.decode(fileUrl.getFile(), "UTF-8"));
            } catch (final UnsupportedEncodingException e) {
                return null;
            }

            if (file.exists() && file.canRead()) {
                return file;
            } else {
                System.out.println("Cannot read from {}, maybe the file does not exists? " + file.getAbsolutePath());
            }

        } else {
            System.out.println("Failed to load " + fileNameFromClasspath);
        }
        return null;
    }
}
