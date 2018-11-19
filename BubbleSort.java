public class Main {


    public static int[] bubble(int[] num){
        int temp;
        for (int i=0 ; i<num.length ; i++){
            for (int j=i+1 ; j<num.length ; j++){
                if(num[i]>num[j]) {
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
        bubble(arr);
        for (int num1=0 ; num1<arr.length ; num1++){
            System.out.println(arr[num1]);
        }
    }
}
