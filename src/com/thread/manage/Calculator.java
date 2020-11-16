package com.thread.manage;

/**
 * @author elliott
 *
 */
public class Calculator implements Runnable {
    @Override
    public void run() {
        long current = 1L;
        long max = 20000L;
        long numPrimes = 0L;
        System.out.printf("Thread '%s': START\n",Thread.currentThread().getName());

        while (current <= max){
            if (isPrime(current)){
                numPrimes++;
            }
            current++;
        }
        System.out.printf("Thread '%s': END.Number of Primes: %d\n",Thread.currentThread().getName(),numPrimes);
    }

    private boolean isPrime(long number) {
        if (number <= 2){
            return true;
        }
        for (long i = 2; i < number; i++) {
            if ((number % i) == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.printf("Minimum Priority: %s\n",Thread.MIN_PRIORITY);
        System.out.printf("Normal Priority: %s\n",Thread.NORM_PRIORITY);
        System.out.printf("Maximun Priority: %s\n",Thread.MAX_PRIORITY);
    }
}
