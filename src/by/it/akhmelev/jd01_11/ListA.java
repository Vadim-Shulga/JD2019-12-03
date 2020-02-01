package by.it.akhmelev.jd01_11;

import java.util.*;

public class ListA<T> implements List<T> {

    private T[] elements = (T[]) new Object[10]; //создали контейнер для объектов
    private int size = 0; //реальный размер коллекции

    @Override
    public boolean add(T element) { //добавление нового елемента
        if (size >= elements.length) { //проверим есть ли куда добавлять
            //если некуда, то увеличим массив в 1.5 раза + 1
            elements = Arrays.copyOf(elements, (elements.length * 3 / 2) + 1);
        }
        elements[size++] = element; //добавляем элемент и потом увеличиваем размер коллеции.
        return true; //говорим что все получилось
    }

    @Override
    public T remove(int index) {
        T element = elements[index];
        int count = size - index - 1; //сколько элементов перенести левее
        //теперь делаем перенос
        System.arraycopy(elements, index + 1, elements, index, count);
        //и усеньшаем размер, а затем освобождаем последнюю ячейку
        elements[--size] = null;
        return element;
    }

    @Override
    public T get(int index) {
        return elements[index];
    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder("[");
        String delimiter = "";
        for (int i = 0; i < size; i++) {
            text.append(delimiter).append(elements[i]);
            delimiter = ", ";
        }
        text.append("]");
        return text.toString();
    }

    @Override
    public int size() {
        return size;
    }
    ///----------- stubs -------------------------------


    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    @Override
    public void add(int index, T element) {

    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}
