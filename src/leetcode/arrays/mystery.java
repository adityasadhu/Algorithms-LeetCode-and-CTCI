package leetcode.arrays;

public class mystery {

    static public int answer(int a, int b){

        int x = a;
        int y = b;

        while(true){
            if (x == y)
                break;
            if(x > y){
                x = x - y;
            }
            else if (x < y){
                y = y - x;

            }
        }
        System.out.println(x);
        return x;
    }


    public static void main(String[] args) {
        answer(2437, 875);

    }
}
