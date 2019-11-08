package list;

public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private int count;

    public SinglyLinkedList() {

    }

    public int getSize() {
        return count;
    }

    public T getHead() {
        if (count == 0) {
            throw new IndexOutOfBoundsException("Список пуст!");
        }
        return head.getData();
    }

    public ListItem<T> getItem(int index) {
        if (index >= count || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        ListItem<T> element = head;
        int i = 0;
        while (i < index) {
            element = element.getNext();
            i++;
        }
        return element;
    }

    public T getFirstElementValue() {
        return head.getData();
    }

    public T getValue(int index) {
        return getItem(index).getData();
    }

    public T setValue(int index, T value) {
        ListItem<T> element = getItem(index);
        T oldValue = element.getData();
        element.setData(value);

        return oldValue;
    }

    public T deleteElement(int index) {
        if (index == 0) {
            return deleteFirstElement();
        }
        ListItem<T> element = getItem(index - 1);
        T temp = element.getNext().getData();
        element.setNext(getItem(index + 1));
        count--;

        return temp;
    }

    public void addFirstElement(T obj) {
        ListItem<T> p = new ListItem<>(obj);
        p.setNext(head);
        head = p;
        count++;
    }

    public T deleteFirstElement() {
        T temp = head.getData();
        head = head.getNext();
        count--;

        return temp;
    }

    public void insertElement(int index, T obj) {
        if (index == 0) {
            addFirstElement(obj);
        }
        ListItem<T> newItem = new ListItem<>(obj);
        ListItem<T> element = getItem(index - 1);
        newItem.setNext(element.getNext());
        element.setNext(newItem);
        count++;
    }

    public boolean deleteByValue(T value) {
        ListItem<T> element = head;

        for (int i = 0; i < count; i++) {
            if (value.equals(element.getData())) {
                deleteElement(i);
                return true;
            }
            element = element.getNext();
        }

        return false;
    }

    public void reverse() {
        for (int i = 0, j = count - 1; i < j; i++, j--) {
            ListItem<T> element1 = getItem(i);
            ListItem<T> element2 = getItem(j);
            T temp = element1.getData();
            element1.setData(element2.getData());
            element2.setData(temp);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("{");
        for (ListItem<T> element = head; element != null; element = element.getNext()) {
            if (element.getData() == null) {
                builder.append("null;");
                continue;
            }
            builder.append(element.getData().toString());
            builder.append(",");
        }
        builder.setLength(builder.length() - 1);
        builder.append("}");

        return builder.toString();
    }


}
