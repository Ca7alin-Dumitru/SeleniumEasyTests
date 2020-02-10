package data.generator;

import java.util.Random;

public class Credentials {
    static Random r = new Random();

    public static String user(String param1){
        return param1 + r.nextInt(9999);
    }

    public static String password(String param1){
        return param1 + r.nextInt(9999);
    }
}
