package algorithms.sort;

/**
 * 通过将递增序列改为预先计算的方式实现希尔排序
 */
public class ShellSort extends BaseSort {

    private int step[];

    public ShellSort(Comparable[] a) {
        super(a);
        step = new int[a.length / 3 + 1];
        for (int i = 0; i < step.length; i++) {
            step[i] = i * 3 + 1;
        }
    }

    @Override
    public void sort() {
        for (int h = step.length - 1; h >= 0; h--) {
            for (int i = step[h]; i < a.length; i++) {
                for (int j = i; j >= step[h]; j -= step[h]) {
                    if (less(a[j - step[h]], a[j])) {
                        continue;
                    }
                    exch(a, j - step[h], j);
                }
            }

        }
    }
}
