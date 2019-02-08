package list;

import java.util.Arrays;
import java.util.List;

public class ArrayList implements interfaces.List {
    private String[] array;
    private int capacity;
    private int size;
    private int lastIndexWithValueInIt;

    public ArrayList() {
        this.array = new String[0];
//        this.initializeArray();
        this.capacity = 8;
    }

//    TO add : Implement Get and if element is empty or above
//     the current size to Throw
//     new IndexOutOfBoundsException


    private void initializeArray() {
        for (int i = 0; i < this.array.length; i++) {
            array[i] = "";
        }
    }

    private void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    private void setSize(int size) {
        this.size = size;
    }

    private void validateRange(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Index " + index
                    + " is out of bounds for length " + this.size);
        }
    }

    private void incrementSize(int amount) {
        this.setSize(this.size + amount);
    }

    private void decrementSize(int amount) {
        this.setSize(this.size -= amount);
    }

    private void growToAdd() {
        String[] temp = this.array;
        this.array = new String[temp.length + 1];
        for (int i = 0; i < temp.length; i++) {
            this.array[i] = temp[i];
        }
    }

    @Override
    public void add(String element) {
        this.incrementSize(1);
        growToAdd();
        if (size >= capacity) {
            grow();
        }
        for (int i = size - 1; i < capacity; i++) {
            if (array[i] == null) {
                array[i] = element;
                break;
            }
        }

    }

    @Override
    public void addAll(String[] elements) {
        while (this.size > capacity) {
            grow();
        }
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == null) {
                continue;
            }
            this.add(elements[i]);
        }


    }

    @Override
    public void grow() {
        this.setCapacity(this.capacity * 2);
        String[] temp = this.array;
        this.array = new String[this.capacity];
        for (int i = 0; i < temp.length; i++) {

            this.array[i] = temp[i];
        }
    }

    @Override
    public void set(int index, String element) {
        this.validateRange(index);
        this.array[index] = element;
    }

    @Override
    public void remove(int index) {
        this.validateRange(index);
        this.decrementSize(1);
        String[] temp = this.array;
        this.array = new String[this.size];

        int counter = 0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == null) {
                continue;
            }
            if (i == index) {
                continue;
            }
            this.array[counter] = temp[i];
            counter++;
        }
    }

    @Override
    public void remove(String element) {
        boolean isExist = false;
        int index = 0;
        for (int i = 0; i < this.array.length; i++) {
            String s = this.array[i];
            if (element.equals(s)) {
                isExist = true;
                index = i;
                break;
            }
        }
        if (isExist) {
            this.remove(index);
        }
    }

    @Override
    public boolean contains(String searchElement) {
        for (String s : this.array) {
            if (s != null && s.equals(searchElement)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public String get(int index) {
        this.validateRange(index);
        return this.array[index];
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public List<String> clone() {
        return Arrays.asList(this.array);
    }
}
