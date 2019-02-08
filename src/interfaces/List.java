package interfaces;

public interface List {

    void add(String element);

    void addAll(String[] elements);

    void grow();

    void set(int index, String element);

    void remove(int index);

    void remove(String element);

    boolean contains(String string);

    int size();

    String get(int index);

    boolean isEmpty();

    java.util.List<String> clone();


}
