import java.util.Objects;

public class IntArrayList implements IntList {

    private Integer[] array = new Integer[10];

    @Override
    public void add(Integer element) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                array[i] = element;
                return;
            }
        }
        increaseArrayInSize();
        add(element);
    }

    private void increaseArrayInSize() {
        Integer[] newArray = new Integer[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    @Override
    public boolean add(Integer index, Integer element) {
        while (index >= array.length) {
            increaseArrayInSize();
        }
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        } else if (array[index] == null) {
            array[index] = element;
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        array = new Integer[10];
    }

    @Override
    public Integer get(Integer index) {
        if (array[index] != null) {
            return array[index];
        }
        return null;//throw exception
    }

    @Override
    public boolean isEmpty() {
        for (Integer integer : array) {
            if (integer != null) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean remove(Integer index) {
        if (index >= 0 && index < array.length) {
            array[index] = null;
            return true;
        }
        return false;
    }

    @Override
    public boolean removeByValue(Integer value) {
        for (int i = 0; i < array.length; i++) {
            if (Objects.equals(array[i], value)) {
                array[i] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean set(Integer index, Integer element) {
        for (int i = 0; i < array.length; i++) {
            if (0 <= index && index < array.length) {
                array[index] = element;
                return true;
            }
        }
        return false;
    }

    @Override
    public Integer size() {
        Integer size = 0;
        for (Integer integer : array) {
            if (integer == null) size++;
        }
        return size;
    }

    @Override
    public Integer[] subList(Integer fromIndex, Integer toIndex) {
        int subListLength = toIndex - fromIndex + 1;
        if (fromIndex >= 0 && toIndex >= fromIndex && toIndex < array.length) {
            Integer[] subList = new Integer[subListLength];
            System.arraycopy(array, fromIndex, subList, toIndex, subListLength);
            return subList;
        }
        return null;
    }

    @Override
    public Integer[] toArray() {
        return array;
    }
}
