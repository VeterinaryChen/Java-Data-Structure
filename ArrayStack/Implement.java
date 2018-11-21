public abstract interface IStack<E> {
    E pop();

    void push(E e);

    E peek();

    int getSize();

    boolean isEmpty();
}
