package week11;
public class BOGOSORT {
    public static void main(String[] args) {
        int[] arr = new int[15];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=(int)(Math.random()*10+1);   
        }
        System.out.println(prtArr(arr));
        System.out.println("\n SORTING ARRAY... \n");
        int[] sortedArr = BogoSort(arr);
        System.out.println(prtArr(sortedArr));
    }
    private static String prtArr(int[] arr) {
        String str = "";
        for (int i : arr) {
            str += i + " ";
        }
        return str;
    }
    private static int[] BogoSort(int[] arr) {
        boolean sorted = false;
        
        while (!sorted){
            sorted = true;
            int itter = 0;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i-1]>arr[i]){
                    sorted=false;
                }   
            }
            if (!sorted){
                for (int i = 0; i < arr.length; i++) {
                    int index = (int)(Math.random()*arr.length);
                    int temp = arr[index];
                    arr[index]=arr[i];
                    arr[i]=temp;    
                }
            }
            System.out.print(prtArr(arr) + "     Iteration: " + itter + "\r");
        }
        return arr;
    }
}