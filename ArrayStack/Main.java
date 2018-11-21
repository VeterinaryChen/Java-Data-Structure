public class Stack<E> implements IStack<E>{

    private  Array<E> array;


    public Stack(){
        array = new Array<>();
    }

    public Stack(int capacity){
        array = new Array<>(capacity);
    }

    @Override
    public void push(E e){
        array.append(e);
    }

    @Override
    public E pop(){
        return array.removeLast();
    }

    @Override
    public E peek(){
        return array.get(array.getSize());
    }

    @Override
    public int getSize(){
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.getSize() ==0;
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("[ stack:");
        for (int i=0; i<array.getSize(); i++){
            str.append(array.get(i));
            if(i!=array.getSize()){
                str.append(",");
            }
        }
        str.append("top ]");
        return str.toString();
    }
}
