import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<Item> implements Iterable<Item> {

    private Node<Item> first;
    private int n;

    private static class Node <Item>
    {
        Item value;
        Node<Item> next;
    }

    public boolean isEmpty()
    { return first == null; }

    public int size()
    { return n; }

    public void push(Item i)
    {
        Node<Item> oldFirst = first;
        first = new Node<Item>();
        first.value = i;
        first.next = oldFirst;
        n++;
    }

    public Item pop()
    {
        Item v = first.value;
        first = first.next;
        n--;
        return v;
    }

    public Iterator<Item> iterator() {
        return new ListIterator<Item>(first);
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.value;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(3);
        s.push(5);

        System.out.println(s.pop());
    }
}
