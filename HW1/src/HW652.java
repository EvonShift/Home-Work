public class HW652 {
    public static void main(String[] args){
        _01();
        array8();
        multiple();
        diagonal();
        minMax();
        int array1[] = new int [8];
        for (int i = 0; i < array1.length; i++)
            array1[i] = (int)(Math.random()*3);
        System.out.print(checkBalance(array1));
        int array2[] = new int[8];
        for (int i =0; i < array2.length; i++)
            array2[i] = (int) (Math.random() * 4);
        shift(array2, -45);
    }

    private static void _01(){
        System.out.println();
        int array[] = {0, 1, 1, 0, 1, 0, 0, 1, 0, 1};
        for (int i = 0; i < array.length; i++){
            if (array[i] == 1) array[i] = 0;
            else array[i] = 1;
            System.out.print(array[i]);
        }
    }

    private static void array8(){
        System.out.println();
        int array[] = new int[8];
        for (int i=0; i<array.length; i++) array[i] = i*3;
    }

    private static void multiple(){
        System.out.println();
        int array[] = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int anArray : array) System.out.print(anArray + " ");
        System.out.println();
        for (int i=0; i<array.length; i++){
            if (array[i] < 6) array[i] *= 2;
            System.out.print(array[i]+ " ");
        }
    }

    private static void diagonal(){
        System.out.println();
        int rrr = (int)(Math.random() * 12) + 2;
        int array[][] = new int[rrr][rrr];
        for (int y = 0; y < rrr; y++){
            for (int x = 0; x < rrr; x++){
                if ((x == y) || (rrr - x == y+1)) {
                    array[x][y] = 1;
                }
            }
        }
        System.out.println();
        for (int y = 0; y < rrr; y++){
            for (int x = 0; x < rrr; x++){
                System.out.print(array[x][y] + "  ");
            }
            System.out.println();
        }
    }

    private static void minMax(){
        System.out.println("");
        int array[] = new int[12];
        for (int i = 0; i < array.length; i++){
            array[i] = (int)(Math.random() * 100) - 50;
            System.out.print(array[i] + ", ");
        }
        System.out.println();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int anArray : array) {
            if (anArray < min) min = anArray;
            if (anArray > max) max = anArray;
        }
        System.out.println("MIN: " + min + ", MAX: " + max);
    }

    private static boolean checkBalance(int [] array){
        System.out.println("");
        boolean rrr = false;
        int place = 0;
        for (int i =0; i < array.length; i++)
            array[i] = (int)(Math.random()*4);
        int left = 0;
        int right = 0;
        for (int i : array) right += i;
        for (int i =0; i < array.length-1; i++){
            left += array[i];
            right -= array[i];
            if (left == right){
                rrr = true;
                place = i;
                break;
            }
        }
        for (int i = 0; i < array.length; i++){
            if ((i == place)&&(rrr)){
                System.out.print("^ ");
            }
            System.out.print(array[i] + " ");
        }
        return rrr;
    }

    private static void shift(int[] array, int n){
        System.out.println();
        while (n < 0) n+=array.length;
        while (n > array.length) n-=array.length;
        for (int anArray : array) {
            System.out.print(anArray + " ");
        }
        for (int i = 0; i < n; i++) { 
            int now = array[array.length-1];
            for (int u = array.length-1; u > 0; u--) array[u] = array[u-1];
            array[0] = now;
        }
        System.out.println();
        for (int anArray : array) {
            System.out.print(anArray + " ");
        }
    }
}