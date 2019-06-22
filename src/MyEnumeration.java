import java.util.Enumeration;

public interface MyEnumeration<E>extends Enumeration<E> {
    void rewind();
    void skip(int number);
    int count();
    E nextToken();
}