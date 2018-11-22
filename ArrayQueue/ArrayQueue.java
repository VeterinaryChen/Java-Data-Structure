public class Queue<E> implements IQueue<E> {
    private Array<E> array;

    public Queue(int capacity){
        array = new Array<>(capacity);
    }

    public Queue(){
        array = new Array<>();
    }

    @Override
    public int getSize(){
        return array.getSize();
    }

    @Override
    public boolean isEmpty(){
        return array.isEmpty();
    }

    @Override
    public void enQueue(E e){
        array.append(e);
    }

    @Override
    public E deQueue(){
        return array.removeFirst();
    }

    @Override
    public E getFront(){
        return array.getFirst();
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("|Head<-");
        for (int i=0 ; i<array.getSize() ; i++){
            str.append(array.get(i)+" <- ");
        }
        str.append("End|");

        return str.toString();
    }
}
