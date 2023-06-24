//Разработать программу, имитирующую поведение коллекции HashSet.
// В программе содать метод add, добавляющий элемент,
// метод toString, возвращающий строку с элементами множества,
// и метод, позволяющий читать элементы по индексу.
//  *Реализовать все методы из семинара.
//  Формат данных Integer.

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        SetTwin setTwin = new SetTwin();
        System.out.println(setTwin.add(9));
        System.out.println(setTwin.add(9));
        System.out.println(setTwin.add(2));
        System.out.println(setTwin.add(2));
        System.out.println(setTwin.delete(9));
        System.out.println(setTwin.delete(9));
        System.out.println(setTwin.delete(2));
        System.out.println(setTwin.size());
        System.out.println(setTwin.isEmpty());
        System.out.println(setTwin.contains(9));

        for (int i = 0; i < 10; i++) {
            setTwin.add(new Random().nextInt(50));
        }

        Iterator<Integer> iterator = setTwin.iterator();
        while(iterator.hasNext()){
            int i = iterator.next();
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println(setTwin.getElementByIndex(3));
//        System.out.println(setTwin.getElementByIndex(50));
        System.out.println(setTwin.toString());
    }
}

class SetTwin<E>{
    private HashMap<E,Object> list = new HashMap<>();
    private static final Object OBJECT = new Object();
    public boolean add (E num){return list.put(num,OBJECT) == null;}
    public boolean delete (E num){return list.remove(num,OBJECT);}
    public int size(){return list.size();}
    public boolean isEmpty(){return list.isEmpty();}
    public boolean contains(Object num ){return list.containsValue(num);}
    public Iterator<E> iterator(){return list.keySet().iterator();}
    public E getElementByIndex(int index) {
        E[] listArray = (E[]) list.keySet().toArray();
        return listArray[index];
    }
    public String toString() {
        E[] listArray = (E[]) list.keySet().toArray();
        return Arrays.toString(listArray);
    }

}