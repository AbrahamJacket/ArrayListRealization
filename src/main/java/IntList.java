public interface IntList {

    void add(Integer element);

    boolean add(Integer index, Integer element);

    void clear();

    Integer get(Integer index);

    boolean isEmpty();

    boolean remove(Integer index);

    boolean removeByValue(Integer value);

    boolean set(Integer index, Integer element);

    Integer size();

    Integer[] subList(Integer fromIndex, Integer toIndex);

    Integer[] toArray();
}
