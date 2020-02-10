package data.generator;

public class Address {

    public static String buildingNumber(){
        return FakeData.INSTANCE.getFake().address().buildingNumber();
    }

    public static String city(){
        return FakeData.INSTANCE.getFake().address().city();
    }

    public static String cityName(){
        return FakeData.INSTANCE.getFake().address().cityName();
    }

    public static String country(){
        return FakeData.INSTANCE.getFake().address().country();
    }

    public static String fullAddress(){
        return FakeData.INSTANCE.getFake().address().fullAddress();
    }

    public static String state(){
        return FakeData.INSTANCE.getFake().address().state();
    }

    public static String zipCode(){
        return FakeData.INSTANCE.getFake().address().zipCode();
    }
}
