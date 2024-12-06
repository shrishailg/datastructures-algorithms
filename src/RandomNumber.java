import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomNumber {

    public static void main(String[] args){

        // using Math.random(
        int[] arr = new int[]{1,2,3,4,5};

        // generates number brtween 0-1
        int rand = (int) (Math.random() * arr.length);

        System.out.println(arr[rand]);

        // using java util random
        String[] available_cards = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Queen", "King", "Jack", "Ace"};
        Random random = new Random();
        int random_computer_card = random.nextInt(available_cards.length);
        System.out.println(available_cards[random_computer_card]);

        //Threadsafe randome function
        String[] available_cards1 = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Queen", "King", "Jack", "Ace"};

        int random_computer_card1 = ThreadLocalRandom.current().nextInt(0, available_cards.length);
        System.out.println(available_cards1[random_computer_card1]);
    }
}
