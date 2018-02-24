public class Main {
    int $int = 567810562;
    double $double = 30.52;
    byte $byte = -73;
    short $short = 14562;
    long $long = 922337234656456L;
    float $float = 43.784f;
    char $char = 'H';
    boolean $boolean  = true;
    public static void main(String[] args){
        //Раскомментируй строки по отдельности

        //System.out.println(math((int)(Math.random() * 4), (int)(Math.random() * 4), (int)(Math.random() * 4), (int)(Math.random() * 4)));
        //System.out.println(compare((int)(Math.random() * 7), (int)(Math.random() * 7)));
        //plus_minus((int)(Math.random() * 20) - 10);
        //System.out.println(minus((int)(Math.random() * 20) - 10));
        //hi(введи что-нибудь));
        //every4(попробуй 400, 100, и еще что-нибудь);
    }

    public static float math(float a, float b, float c ,float d){
        System.out.println(a + ", " + b + ", " + c + ", " + d);
        return a * (b + (c / d));
    }

    public static boolean compare(double a, double b){
        System.out.println(a + ", " + b);
        return ((a * b >= 10) && (a * b <=20));
    }

    public static void plus_minus(int a){
        System.out.println(a);
        if (a < 0){
            System.out.println("Какое же оно отрицательное!!!");
        } else {
            System.out.println("Все в порядке, оно положителое :)");
        }
    }

    public static boolean minus(int a){
        System.out.println(a);
        return (a < 0);
    }

    public static void hi(String name){
        System.out.println("Привет,указанное имя!!! Тьфу, то есть привет, " + name + "!!!");
    }

    public static void every4(int year){
        System.out.println(year);
        String is = "Неа";
        if (year % 100 == 0) {
            is = "Високосный, еще как!";
        } else if (year % 4 == 0){
            is = "Високосный, еще как!";
        }
        if (year == 400){
            is = "Неа";
        }
            System.out.println(is);
    }
}
