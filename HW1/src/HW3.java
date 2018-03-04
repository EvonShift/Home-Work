import java.util.Scanner;

public class HW3 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        Guess();
        word();
    }

    public static void Guess(){
        boolean play = true;
        int num;
        int tries;
        int guess = -1;
        int reboot;
        while (play){
            System.out.println("Число загаданно");
            tries = 3;
            num = (int)(Math.random()*10);
            while ((tries > 0) || (guess == num)) {
                guess = sc.nextInt();
                if (guess < num)
                    System.out.println("Загаданное число больше");
                else if (guess > num)
                    System.out.println("Загаданное число меньше");
                else {
                    System.out.println("Вы угадали!");
                    break;
                }
                tries--;
                System.out.println("Осталось " + tries + " попыток");
            }
            System.out.println("Еще разок? (1 - да)");
            reboot = sc.nextInt();
            if (reboot != 1)
                play = false;
        }
    }

    public static void word(){
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive",
                "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        String myWord = words[(int)(Math.random() * words.length)];
        String guess = sc.nextLine();
        int chars = myWord.length();
        while (!guess.equals(myWord)){
            if (myWord.length() > guess.length()) chars = guess.length();
            else chars = myWord.length();
            System.out.println();
            for (int i = 0; i < chars; i++){
                if (guess.charAt(i) == myWord.charAt(i))
                    System.out.print(myWord.charAt(i));
                else
                    System.out.print("#");
            }
            for (int i = 0; i < (11 - chars); i++){
                System.out.print("#");
            }
            System.out.println();
            guess = sc.nextLine();
        }
        System.out.println("Ты угадал, это " + myWord);
    }
}
