public class PrimeNumber {


    public boolean isPrime(int number){

        for (int i = 2; i<Math.sqrt(number); i++){
            if (number % i == 0) {
                return false;
            }

        }
        return true;
    }
    public int belowprime (int number){
        for (int i = number-1; i>1 ; i--){
            if (isPrime(i)){
                return i;
            }
        }
        return -1;
    }

    public int afterPrime(int number){
        number = number +1;
        while (number >0){
            if (isPrime(number)){
                return number;
            }
            number++;
        }
        return -1;
    }


    

    public static void main (String args[]){
        PrimeNumber primeNumber = new PrimeNumber();
        boolean result = primeNumber.isPrime(7);

        int beforeprime = primeNumber.belowprime(99);
        int afterprime = primeNumber.afterPrime(99);

        boolean beforePrimeResult  = primeNumber.isPrime(beforeprime);
        boolean afterPrimeResult = primeNumber.isPrime(afterprime);


        System.out.println(result + " " + beforeprime + " " + afterprime);
        System.out.println("before prime is "+ beforePrimeResult + " after prime is " + afterPrimeResult);





    }
}
