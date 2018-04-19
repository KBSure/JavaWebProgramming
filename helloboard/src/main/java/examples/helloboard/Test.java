package examples.helloboard;

public class Test {
    public static void main(String[] args){
        String str1 = "hello";
        String str5 = "he" + "llo";
        if(str1 == str5){
            System.out.println("str1 == str5");
        }else{
            System.out.println("str1 != str5");
        }
//        String[] split = System.getProperties().getProperty("java.class.path").split(";");
//        for(int i = 0; i < split.length; i++){
//            System.out.println(split[i]);
//        }
    }
}
