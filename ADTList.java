/**
 * ADTListHW
 */

public abstract class ADTList<E> {
    public abstract boolean isEmpty(); // returns if the list is empty
    public abstract int size(); // returns the size of the list
    public abstract void add(String item); // adds the item to the list
    public abstract String remove(int index); // removes the element at a specific index, then returns the value stored at said index
    public abstract void remove(String item); // removes the first occurrence of the specified element
    public abstract String get(int index); // returns the element at the specified index
    public abstract void removeAll(); // removes all items in the list
}