public class Main {


    public static int[] Selection(int[] num){
        int temp;
        for (int i=0 ; i<num.length ; i++)
        {
            int min = i;
            for (int j=i+1 ; j<num.length ; j++){
                if(num[i]>num[j]) {
                    min = j;
                    temp = num[i];
                    num[i] = num[j];
                    num[j] = temp;
                }
            }
        }
        return num;
    }
    public static void main(String[] args) {
        int[] arr ={1,3,9,5,2,0};
        Selection(arr);
        for (int key : arr){
            System.out.println(key);
        }
    }
}
