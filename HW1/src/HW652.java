public class HW652 {
    public static void main(String[] args){
        _01();
        array8();
        multiple();
        diagonal();
        minMax();
        checkBalance();
        shift();
    }

    public static void _01(){
        System.out.println("");
        int array[] = {0, 1, 1, 0, 1, 0, 0, 1, 0, 1};
        for (int i = 0; i < array.length; i++){
            array[i] += 1;
            if (array[i] == 2) array[i] = 0;
            System.out.print(array[i]);
        }
    }

    public static void array8(){
        System.out.println("");
        int array[] = new int[8];
        for (int i=0; i<array.length; i++) array[i] = i*3;
    }

    public static void multiple(){
        System.out.println("");
        int array[] = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i=0; i<array.length; i++){
            System.out.print(array[i]+ " ");
        }
        System.out.println("");
        for (int i=0; i<array.length; i++){
            if (array[i] < 6) array[i] *= 2;
            System.out.print(array[i]+ " ");
        }
    }

    public static void diagonal(){
        System.out.println("");
        int rrr = (int)(Math.random() * 12) + 2;
        int array[][] = new int[rrr][rrr];
        for (int y = 0; y < rrr; y++){
            for (int x = 0; x < rrr; x++){
                if ((x == y) || (rrr - x == y+1)) {
                    array[x][y] = 1;
                }
            }
        }
        System.out.println(" ");
        System.out.print("  ");
        for (int y = 0; y < rrr; y++){
            for (int x = 0; x < rrr; x++){
                if (x == rrr-1) {
                    System.out.println(array[x][y]);
                    System.out.print("  ");
                } else {
                    System.out.print(array[x][y]);
                    System.out.print("  ");
                }
            }
        }
    }

    public static void minMax(){
        System.out.println("");
        int array[] = new int[12];
        for (int i = 0; i < array.length; i++){
            array[i] = (int)(Math.random() * 100) - 50;
            System.out.print(array[i] + ", ");
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++){
            if (array[i] < min) min = array[i];
            if (array[i] > max) max = array[i];
        }
        System.out.println("MIN: " + min + ", MAX: " + max);
    }

    public static boolean checkBalance(){
        System.out.println("");
        boolean rrr = false;
        int array[] = new int[8];
        int place = 0;
        for (int i =0; i < array.length; i++){
            array[i] = (int)(Math.random()*4);
        }
        int left = 0;
        int right = 0;
        for (int i =0; i < array.length; i++){
            left = 0;
            right = 0;
            for (int f = 0; f < i; f++){
                left += array[f];
            }
            for (int s = i; s < array.length; s++){
                right += array[s];
            }
            if (left == right){
                rrr = true;
                place = i;
                break;
            }
        }
        for (int i = 0; i < array.length; i++){
            if ((i == place)&&(rrr == true)){
                System.out.print("^ ");
            }
            System.out.print(array[i] + " ");
        }
        System.out.print(rrr);
        return rrr;
    }

    public static void shift(){
        System.out.println("");
        int array[] = new int[8];
        int help[] = new int[8];
        for (int i =0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 4);
            System.out.print(array[i] + " ");
        }
        int n = -1;
        //777
        while (n < 0){
            n+=array.length;
        }
        for (int i = 0; i < n; i++) {
            int now = array[array.length-1];
            for (int u = array.length-1; u > 0; u--) {
                array[u] = array[u-1];
            }
            array[0] = now;
        }
        System.out.println(" ");
        for (int i =0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}