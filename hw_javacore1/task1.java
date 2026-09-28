public class task1 {
    public boolean sortedAscending(int size, int[] array) {
        for (int i = 1; i < size; i++) {
            if (array[i] < array[i - 1]) {
                return false;
            }
        }
        return true;
    }
}