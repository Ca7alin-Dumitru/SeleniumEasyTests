package data.generator;

import com.github.javafaker.Faker;

public enum FakeData {
    INSTANCE;

    private static Faker connection = null;

    public static Faker getFake() {
        if (connection == null) {
            connection = new Faker();
        }

        return connection;
    }
}
