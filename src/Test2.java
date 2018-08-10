public class Test2 {

    public static void main(String args[]){
        String test = "hello";
        char[] result = test.toCharArray();
        for (char i :result){
            System.out.println(Character.getNumericValue(i));
        }
        System.out.println("test2");
    }
}
