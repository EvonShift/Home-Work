import java.util.Scanner;

public class HW4 {
    static Scanner sc = new Scanner(System.in);
    static final char DOT_X = 'X';
    static final char DOT_O = 'O';
    static final char DOT_NT = '-';
    static final int MAP_SIZE = 5;
    static final int DOTS_NEED = 4;
    static char $case[][];

    public static void main(String[] args) {
        $case = new char[MAP_SIZE][MAP_SIZE];
        for (int i = 0; i < $case.length; i++)
            for (int j = 0; j < $case.length; j++)
                $case[i][j] = DOT_NT;
        playersTurn();
    }

    public static void playersTurn() {
        int xy = sc.nextInt();
        int x = (int) (xy * 0.1);
        int y = xy % 10;
        if ((xy > 9) && (xy < 100)) {
            if ((x <= MAP_SIZE) && (y <= MAP_SIZE)) {
                if (($case[x - 1][y - 1] == DOT_NT)) {
                    $case[x - 1][y - 1] = DOT_X;
                    mapPrint();
                    if (end(winCondition(DOT_X, 1))) {
                        if (end(winCondition(DOT_O, 2))) {
                            aiTurn();
                        }
                    }
                } else {
                    System.out.println("Клетка занята");
                    playersTurn();
                }
            } else {
                System.out.println("Введенные координаты выходят за границы поля");
                playersTurn();
            }
        } else {
            System.out.println("Некорректный ввод");
            playersTurn();
        }
    }

    public static void aiTurn() {
        int x, y;
        int xy = AI();
        if (xy != -1) {
            x = (int) (xy * 0.1);
            y = xy % 10;
        } else {
            x = (int) (Math.random() * MAP_SIZE);
            y = (int) (Math.random() * MAP_SIZE);
        }
        if ((x <= MAP_SIZE - 1) && (y <= MAP_SIZE - 1) && (x >= 0) && (y >= 0)) {
            if (($case[x][y] == DOT_NT)) {
                System.out.println("Компьютер сходил в точку " + (x + 1) + ", " + (y + 1));
                $case[x][y] = DOT_O;
                mapPrint();
                if (end(winCondition(DOT_X, 1))) {
                    if (end(winCondition(DOT_O, 2))) {
                        playersTurn();
                    }
                }
            } else {
                aiTurn();
            }
        } else {
            aiTurn();
        }

    }

    public static void mapPrint() {
        for (int i = 0; i < $case.length; i++) {
            System.out.println();
            for (int j = 0; j < $case.length; j++) {
                System.out.print($case[j][i] + " ");
            }
        }
        System.out.println();
    }

    public static int winCondition(char dot, int player) {
        boolean rrr = true;
        for (int x = 0; x < (MAP_SIZE - DOTS_NEED) + 1; x++) {
            for (int y = 0; y < MAP_SIZE; y++) {
                rrr = true;
                for (int i = 0; i < DOTS_NEED; i++) {
                    rrr = (rrr && ($case[x + i][y] == dot));
                }
                if (rrr) break;
            }
            if (rrr) break;
        }
        if (rrr) return player;
        for (int y = 0; y < (MAP_SIZE - DOTS_NEED) + 1; y++) {
            for (int x = 0; x < MAP_SIZE; x++) {
                rrr = true;
                for (int i = 0; i < DOTS_NEED; i++) {
                    rrr = (rrr && ($case[x][y + i] == dot));
                }
                if (rrr) break;
            }
            if (rrr) break;
        }
        if (rrr) return player;
        for (int y = 0; y < (MAP_SIZE - DOTS_NEED) + 1; y++) {
            for (int x = 0; x < (MAP_SIZE - DOTS_NEED) + 1; x++) {
                rrr = true;
                for (int i = 0; i < DOTS_NEED; i++) {
                    rrr = (rrr && ($case[x + i][y + i] == dot));
                }
                if (rrr) break;
            }
            if (rrr) break;
        }
        if (rrr) return player;
        for (int y = 0; y < (MAP_SIZE - DOTS_NEED) + 1; y++) {
            for (int x = (MAP_SIZE - 1); x > 0; x--) {
                rrr = true;
                for (int i = 0; i < DOTS_NEED; i++) {
                    rrr = (rrr && ($case[x - i][y + i] == dot));
                }
                if (rrr) break;
            }
            if (rrr) break;
        }
        if (rrr) return player;
        return 0;
    }

    public static int AI(){
        if  (AIcheck(DOT_O) != -1) return AIcheck(DOT_O);
        return AIcheck(DOT_X);
    }

    public static int AIcheck(char dot) {
        boolean left, right;
        boolean rrr = true;
        for (int x = 0; x < (MAP_SIZE - DOTS_NEED) + 2; x++) {
            for (int y = 0; y < MAP_SIZE; y++) {
                rrr = true;
                for (int i = 0; i < DOTS_NEED - 1; i++) {
                    rrr = (rrr && ($case[x + i][y] == dot));
                }
                try { left = $case[x + DOTS_NEED - 1][y] == DOT_NT; }
                catch (ArrayIndexOutOfBoundsException e){ left = false;}
                try { right = $case[x - 1][y] == DOT_NT; }
                catch (ArrayIndexOutOfBoundsException e){ right = false;}
                if (rrr && (left || right)) {
                    if (boolRandom()) return (x + DOTS_NEED - 1) * 10 + y;
                    else return (x - 1) * 10 + y;
                }
            }
            if (rrr) break;
        }
        for (int y = 0; y < (MAP_SIZE - DOTS_NEED) + 2; y++) {
            for (int x = 0; x < MAP_SIZE; x++) {
                rrr = true;
                for (int i = 0; i < DOTS_NEED - 1; i++) {
                    rrr = (rrr && ($case[x][y + i] == dot));
                }
                try { left = $case[x][y + DOTS_NEED - 1] == DOT_NT; }
                catch (ArrayIndexOutOfBoundsException e){ left = false;}
                try { right = $case[x][y - 1] == DOT_NT; }
                catch (ArrayIndexOutOfBoundsException e){ right = false;}
                if (rrr && (left || right)) {
                    if (boolRandom()) return x * 10 + (y + DOTS_NEED - 1);
                    else return x * 10 + (y - 1);
                }
            }
            if (rrr) break;
        }
        for (int y = 0; y < (MAP_SIZE - DOTS_NEED) + 2; y++) {
            for (int x = 0; x < (MAP_SIZE - DOTS_NEED) + 1; x++) {
                rrr = true;
                for (int i = 0; i < DOTS_NEED - 1; i++) {
                    rrr = (rrr && ($case[x + i][y + i] == dot));
                }
                try { left = $case[x - 1][y - 1] == DOT_NT; }
                catch (ArrayIndexOutOfBoundsException e){ left = false;}
                try { right = $case[x + DOTS_NEED-1][y + DOTS_NEED-1] == DOT_NT; }
                catch (ArrayIndexOutOfBoundsException e){ right = false;}
                if (rrr && (left || right)) {
                    if (boolRandom()) return (x - 1) * 10 + (y - 1);
                    else return (x + DOTS_NEED-1) * 10 + y + DOTS_NEED-1;
                }
            }
            if (rrr) break;
        }
        for (int y = 0; y < (MAP_SIZE - DOTS_NEED) + 2; y++) {
            for (int x = (MAP_SIZE - 1); x > 0; x--) {
                rrr = true;
                for (int i = 0; i < DOTS_NEED - 1; i++) {
                    rrr = (rrr && ($case[x - i][y + i] == dot));
                }
                try { left = $case[x - DOTS_NEED + 1][y + DOTS_NEED-1]  == DOT_NT; }
                catch (ArrayIndexOutOfBoundsException e){ left = false;}
                try { right = $case[x + 1][y - 1] == DOT_NT; }
                catch (ArrayIndexOutOfBoundsException e){ right = false;}
                if (rrr && (left || right)) {
                    if (boolRandom()) return (x - DOTS_NEED + 1) * 10 + (y + DOTS_NEED-1);
                    else return (x + 1) * 10 + y - 1;
                }
            }
            if (rrr) break;
        }
        return -1;
    }

    public static boolean end(int who) {
        if (who == 1) {
            System.out.println("Игрок победил!");
            return false;
        } else if (who == 2) {
            System.out.println("Компьютер победил!");
            return false;
        } else return true;
    }

    public static boolean boolRandom() {
        int b = (int) (Math.random() * 2);
        if (b == 1) return true;
        else return false;
    }
}
