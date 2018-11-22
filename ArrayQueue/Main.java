public class Main {

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();

        for (int i=0 ; i<5 ; i++){
            queue.enQueue(i);
            System.out.println(queue);
        }
        queue.deQueue();
        System.out.print(queue);
    }

}
