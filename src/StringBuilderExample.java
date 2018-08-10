public class StringBuilderExample {

    public static void main(String[] args) {
        String result = "hello";
        StringBuilder test = new StringBuilder();


        test.append(result);
        test.append("dude");

        System.out.println(test);
    }
}
