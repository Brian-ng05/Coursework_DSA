package ADT.linkedList;

public class LinkedListADT<E> {
    private class Node<E>{
        // attributes
        private E element;
        private Node<E> next;

        // constructor
        public Node ( E element ) {
            this.element = element;
            this.next = null;
        }
    }

    // attributes
    private Node<E> head;
    private Node<E> tail;
    private int size;

    // constructor
    public LinkedListADT () {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }


    public void addFirst ( E element ) {
        Node<E> newNode = new Node<>(element);

        if (head == null && tail == null){
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head = newNode;
        }
        this.size++;
    }


    public void addLast ( E element ) {
        Node<E> newNode = new Node<>(element);

        if (head == null && tail == null){
            this.head = newNode;
            this.tail = newNode;
        } else {
            tail.next = newNode;
            this.tail = newNode;
        }
        this.size++;
    }


    public E removeFirst () {
        if (head == null && tail == null){
            throw new IllegalStateException("This list is empty");
        }

        E oldElement = this.head.element;

        if (head == tail){
            this.head = null;
            this.tail = null;
        } else {
            Node<E> tempNode = this.head;
            this.head = this.head.next;
            tempNode.next = null;
        }
        this.size--;
        return oldElement;
    }


    public E removeLast () {
        if (head == null && tail == null){
            throw new IllegalStateException("This list is empty");
        }

        E oldElement = this.tail.element;

        if (head == tail){
            this.head = null;
            this.tail = null;
        } else {
            Node<E> tempNode = this.head;
            while (tempNode.next != this.tail){
                tempNode = tempNode.next;
            }
            tempNode.next = null;
            this.tail = tempNode;
        }
        this.size--;
        return oldElement;
    }


    public E getFirst () {
        if (head == null && tail == null){
            throw new IllegalStateException("This list is empty");
        }
        return this.head.element;
    }


    public E getLast () {
        if (head == null && tail == null){
            throw new IllegalStateException("This list is empty");
        }
        return this.tail.element;
    }


    public int size () {
        return size;
    }


    public boolean isEmpty () {
        return size == 0;
    }


    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append("[");
        Node<E> tempNode = this.head;
        while (tempNode != null){
            result.append(tempNode.element);
                if (tempNode.next != null) {
                    result.append(", ");
                }
                tempNode = tempNode.next;
        }
        result.append("]");
        return result.toString();
    }
}
