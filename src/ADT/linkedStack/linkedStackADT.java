package ADT.linkedStack;

public class linkedStackADT<E> {
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
    private Node<E> top;
    private int size;

    // constructor
    public linkedStackADT () {
        this.top = null;
        this.size = 0;
    }



    public void push ( E element ) {
       Node<E> newNode = new Node<>(element);

       if (this.top == null) {
           this.top = newNode;
       } else {
           newNode.next = this.top;
           this.top = newNode;
       }
        this.size++;
    }


    public E pop () {
        if (this.top == null){
            throw new IllegalStateException("This stack is empty");
        }
        E oldElement = this.top.element;

        Node<E> tempNode = this.top;
        this.top = this.top.next;
        tempNode.next = null;

        this.size--;

        return oldElement;
    }


    public E peek () {
         if (top == null){
             throw new IllegalStateException("This stack is empty");
         }
        return this.top.element;
    }


    public int size () {
        return size;
    }


    public boolean isEmpty () {
        return size == 0;
    }


    public String toString(){
        StringBuilder result = new StringBuilder();

        Node<E> current = top;
        while (current != null) {
            result.append(current.element);
            if (current.next != null) {
                result.append(", ");
            }
            current = current.next;
        }

        return result.toString();

    }
}
