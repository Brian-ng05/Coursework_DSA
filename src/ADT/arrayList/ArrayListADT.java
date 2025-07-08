package ADT.arrayList;


public class ArrayListADT<E> {
    private E[] elements;
    private int nextIndex;

    public ArrayListADT() {
        this.elements = (E[]) new Object[3];
        this.nextIndex = 0;
    }


    public boolean add(E element) {
        if (this.nextIndex == this.elements.length) {
            grow();
        }
        this.elements[this.nextIndex++] = element;
        return true;
    }

    @SuppressWarnings("unchecked")
    private void grow() {
        E[] biggerElements = (E[]) new Object[elements.length * 2];
            for ( int i = 0; i < elements.length; i++ ) {
                biggerElements[i] = elements[i];
        }
        elements = biggerElements;
    }

    @SuppressWarnings("unchecked")
    private void shirk(){
        E[] smallerElements = (E[]) new Object[elements.length / 2];
            for ( int i = 0; i < nextIndex; i++ ) {
                smallerElements[i] = elements[i];
        }
        elements = smallerElements;
    }

    public boolean add(int index, E element) {
        if (index < 0 || index > nextIndex) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds.");
        }
        if (this.nextIndex == this.elements.length) {
            grow();
        }
        for (int i = nextIndex; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        nextIndex++;
        return true;
    }

    public int indexOf(E element) {
        for (int i = 0; i < nextIndex; i++) {
            if (elements[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public E get(int index) {
        if (index < 0 || index >= nextIndex) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds.");
        }
        return this.elements[index];
    }

    public E set(int index, E element) {
        if (index < 0 || index >= nextIndex) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds.");
        }
        E old = elements[index];
        elements[index] = element;
        return old;
    }

    public E remove(int index) {
        if (index < 0 || index >= nextIndex){
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds.");
        }
        E removeElement = elements[index];
        for (int i = index; i < nextIndex - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[nextIndex - 1] = null;
        nextIndex--;
        if (nextIndex > 0 && nextIndex <= elements.length / 3){
            shirk();
        }
        return removeElement;
    }

    public int size() {
        return nextIndex;
    }

    public boolean contains(E element) {
        for (int i = 0; i < nextIndex; i++) {
            if (elements[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return nextIndex == 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nextIndex; i++) {
            sb.append(elements[i]);
            if (i < nextIndex - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}
