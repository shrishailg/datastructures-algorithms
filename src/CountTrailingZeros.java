public class CountTrailingZeros {

    public static void main(String[] args){
        long n = factorial(20);

        int count = 0;
        while (n>0){
            long x = n % 10;
            if (x != 0)
                break;
            count++;
            n=n/10;
        }
        System.out.println(count);
    }

    static long factorial(int n){
        if (n<1)
            return 1;
        return n * factorial(n-1);
    }

    //number of 5 in the n is no of trailing 0 as 0 is caused by 2 and 5 and no of 2 always greater than 5
    int countTrailingZeros(int n){
        if(n < 0){
            return -1;
        }

        int count=0;
        for(int i=5;n/i>=1;i=i*5){
            count += n/i;
        }

        return count;
    }
}
