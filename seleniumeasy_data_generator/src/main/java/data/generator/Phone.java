package data.generator;

public class Phone {

    public static String cellPhone(){
        return FakeData.INSTANCE.getFake().phoneNumber().cellPhone();
    }

    public static String phoneNumber(){
        return FakeData.INSTANCE.getFake().phoneNumber().phoneNumber();
    }
}
