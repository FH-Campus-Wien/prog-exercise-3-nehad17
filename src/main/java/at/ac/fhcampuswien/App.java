package at.ac.fhcampuswien;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class App {

    public static void oneMonthCalendar(int anzahl, int tageins) {
        int lines;
        if((anzahl + tageins)%7!=0)
            lines = (anzahl /7)+1;
        else
            lines = anzahl /7;

        for (int x = 1; x < tageins; x++) {
            System.out.print("   ");
        }

        int count = 1;
        int column = tageins;

        for (int y = 0; y < lines; y++) {
            while (column <= 7) {
                System.out.printf("%2d ",count);
                if (count == anzahl){
                    System.out.println();
                    return;
                }
                column++;
                count++;
            }
            column =1;
            System.out.println();
        }
    }


    public static long[] lcg(long seed) {
        long l = ((long) Math.pow(2, 31));
        long m = 1103515245;
        long n = 12345;

        long[] arr1 = new long[11];
        arr1[0] = seed;

        for (int i = 1; i < 11; i++) {
            arr1[i] = ((m *arr1[i-1])+n)% l;
        }

        return Arrays.copyOfRange(arr1,1,arr1.length);
    }

    public static void guessingGame(int numberToGuess) {
        Scanner scan = new Scanner(System.in);
        int guess;

        for (int x = 1; x <= 10; x++) {
            System.out.print("Guess number "+ x +": ");
            guess = scan.nextInt();

            if (guess == numberToGuess){
                System.out.println("You won wisenheimer!");
                break;
            }

            if (x == 10){
                System.out.println("You lost! Have you ever heard of divide & conquer?");
                break;
            }

            if (guess > numberToGuess)
                System.out.println("The number AI picked is lower than your guess.");
            if (guess < numberToGuess)
                System.out.println("The number AI picked is higher than your guess.");
        }
    }

    public static int randomNumberBetweenOneAndHundred() {
        Random rndm = new Random();
        return rndm.nextInt(100)+1;
    }

    public static boolean swapArrays(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length)
            return false;

        for (int a = 0; a < arr1.length; a++) {
            arr1[a]=arr1[a]-arr2[a];
            arr2[a]=arr2[a]+arr1[a];
            arr1[a]=arr2[a]-arr1[a];
        }
        return true;
    }

    public static String camelCase(String s) {
        char[] satz = s.toCharArray();
        if (satz[0] >= 97 && satz[0] <= 122)
            satz[0] -= 32;

        for (int n = 0; n < satz.length; n++) {
            if (n >= 1 && satz[n -1] == ' ' && satz[n] >= 97 && satz[n] <= 122){
                satz[n] -= 32;
            }
            if (n >= 1 && satz[n -1] != ' ' && satz[n] >= 65 && satz[n] <= 90){
                satz[n] += 32;
            }
        }

        for (int i = 0; i < satz.length; i++) {
            if ((satz[i] > 0 && satz[i] <= 64) || (satz[i] >= 91 && satz[i] <= 96) || (satz[i] >= 123 && satz[i] <= 127)){
                satz[i] = 32;
            }
        }
        String sol = String.valueOf(satz).replaceAll(" ","");
        return sol;
    }

    public static int checkDigit(int[] arr1) {
        int wichtung = 2;
        int sum=0;
        int mod;
        for (int x = 0; x < arr1.length; x++) {
            sum += arr1[x]*(wichtung + x);
        }
        mod = sum%11;

        if (11-mod==10)
            return 0;
        if (11-mod==11)
            return 5;

        return 11-mod;
    }

    public static void main(String[] args) {

        System.out.println("Aufgabe 1");
        oneMonthCalendar(30,3);
        System.out.println();

        System.out.println("Aufgabe 2");
        lcg(12345);
        System.out.println();

        System.out.println("Aufgabe 30");
        guessingGame(1);
        System.out.println();

        System.out.println("Aufgabe 4");
        int[] array1 = new int[]{1, 2, 3, 4, 5, 6};
        int[] array2 = new int[]{100, 202, 30, 14, 15, 16};
        swapArrays(array1,array2);
        System.out.println();

        System.out.println("Aufgabe 5");
        camelCase("abc abc abc aBc");
        System.out.println();

        System.out.println("Aufgabe 6");
        checkDigit(array1);
        System.out.println();
    }
}