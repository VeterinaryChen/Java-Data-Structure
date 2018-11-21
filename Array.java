public class Array<E>{
    private E[] data;
    private int size;

    public Array(){
        this(10);
    }

    public Array(int capacity){
        data = (E[])new Object[capacity];
        size = 0;
    }

    //从数组的末端插入数据
    public void append(E e){
        if(size == data.length){
            throw new IllegalArgumentException("Array is already full");
        }
        data[size] = e;
        size++;
    }

    //从数组的前端插入数据
    public void shift(E e){
        insert(0,e);
    }

    //获取数组的长度
    public int getSize(){
        return size;
    }

    //取出数组中的某个值
    E get(int index){
        if (index <0 || index >size){
            throw new IllegalArgumentException("get failed,index is illegal!");
        }
        return data[index];

    }

    //设置数组中的某个值
    void set(int index , E e){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("set failed,index is illeagal!");
        }
        data[index]=e;
    }

    //在特定的位置插入数据
    public void insert(int index , E e){
        if(index <0 || index > size ){
            throw new IllegalArgumentException("invalid index!");
        }
        if (index == size){
            resize(2* data.length);
        }
        for (int i=size-1 ; i>=index ; i--){
            data[i+1] = data[i];
        }
        data[index] = e;
        size++;
    }

    //改变数组的容量
    private void resize(int newcapacity){
        E[] newData = (E[])new Object[newcapacity];
        for (int i=0 ; i<size ;i++){
            newData[i] = data[i];
        }
        data = newData;
    }

    //判断是否空数组
    public boolean isEmpty(){
        return size == 0;
    }

    //输出数组
    @Override
    public String toString(){
        StringBuilder res =  new StringBuilder();
        res.append(String.format("Array :size = %d ,capacity = %d\n",size,data.length));
        res.append("[");
        for (int i=0 ; i<size ; i++){
            res.append(data[i]);
            if (i!=size-1){
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }

    //判断元素是否在数组中
    public boolean contains(int e){
        for (int i=0 ; i<size ; i++){
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    //判断元素是否在数组中，并返回下标
    public int find(E e){
        for (int i=0 ; i<size ; i++){
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    //删除数组中指定下标元素，并返回该元素
    public E remove(int index){
        if (index <0 || index >size){
            throw new IllegalArgumentException("index is illegal!");
        }

        E ret = data[index];
        for (int i=index+1 ; i<size ; i++){
            data[i-1] = data[i];
        }
        size--;

        if (index == data.length/4){
            resize(data.length/2);
        }
        return ret;
    }

    //删除数组中第一个元素，并返回该元素
    public E removeFirst(){
        return  remove(0);
    }

    //删除数组中最后一个元素，并返回该元素
    public E removeLast(){
        return remove(size-1);
    }

    //删除数组中的指定元素
    public void removeElement(E e){

        int index = find(e);
        if (index!=-1){
            remove(index);
        }
    }
}
