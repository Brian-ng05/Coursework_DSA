package ADT.linkedQueue;

public class linkedQueueADT<E> {
    private class Node<E> {
        // data
        private E element;
        private Node<E> next;

        // constructor
        public Node ( E element ) {
            this.element = element;
            this.next = null;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size;

    // constructor
    public linkedQueueADT (){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }


    public void offer ( E element ) {
        Node<E>  newNode = new Node<>(element);

        if (head == null && tail == null){
            this.head = newNode;
            this.tail = newNode;
        } else {
            tail.next = newNode;
            this.tail = newNode;
        }
        this.size++;
    }


    public E poll() {
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


    public E peek() {
        if (head == null && tail == null){
            throw new IllegalStateException("This list is empty");
        }
        return this.head.element;
    }

    public int size () {
        return this.size;
    }

    public boolean isEmpty () {
        return this.size == 0;
    }


    public String toString () {
        StringBuilder result = new StringBuilder();
        Node<E> tempNode = this.head;

        while (tempNode != null){
            result.append(tempNode.element);
            if (tempNode.next != null) {
                result.append(", ");
            }
            tempNode = tempNode.next;
        }
        return result.toString();
    }

}
