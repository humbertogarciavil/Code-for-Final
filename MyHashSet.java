package org.csu.cpsc;

public class MyHashSet<E> {
    private E[] data;
    private int count;

    public MyHashSet(int initialCapacity){
        data = (E[]) new Object[initialCapacity];
    }

    public boolean add(E element){
        int position = findPosition(element);

        if(data[position] == null){
            data[position] = element;
            count++;
            return true;
        }

        return false;
    }

    public boolean contains(Object o){
        int position = findPosition((E) o);

        if(data[position] == null){
            return false;
        }else{
            return true;
        }
    }

    public E get(Object o){
        int position = findPosition((E) o);
        return data[position];
    }

    public int size(){
        return count;
    }

    public boolean isEmpty(){
        if(count == 0){
            return true;
        }else{
            return false;
        }
    }

    public boolean remove(Object o){
        int position = findPosition((E) o);

        if(data[position] == null){
            return false;
        } else {
            data[position] = null;
            count--;
            return true;
        }
    }

    private int findPosition(E element){
        int position = Math.abs(element.hashCode() % data.length);

        //TODO: Stop if completed loop
        while(data[position] != null && !data[position].equals(element)){
            position = (position + 1) % data.length;
        }

        return position;
    }
}
