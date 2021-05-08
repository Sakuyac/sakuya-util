package sakuya.sort;

import java.util.List;

/**
 * @author chenyuanqiao
 * @date 2021/3/24
 * 使用接口的方式实现
 */
public interface Universal<T, K> {

    /**
     * 智能排序
     * @param o1List 需要排序的对象列表
     * @param o2List 排序字段列表
     * */
    default void sort(List<T> o1List, List<K> o2List){
        int count = o1List.size();
        int end = o1List.size() - 1;
        int i = 0;
        while (count > 1){
            T o1 = o1List.get(i);
            for (int j = 0 ; j < o2List.size() ; j++){
                if (compare(o1, o2List.get(j))){
                    if (i == j){
                        i++;
                    } else {
                        swap(i, j, o1List);
                    }
                    count--;
                    break;
                }
                if (j == o2List.size() - 1){
                    swap(i, end--, o1List);
                    count--;
                }

            }
        }
    }
    /**
     * 交换列表中属性
     * @param index1 坐标1
     * @param index2 坐标2
     * @param o1List 需要交换的列表
     * */
    default void swap(Integer index1, Integer index2, List<T> o1List){
        T o1 = o1List.get(index1);
        o1List.set(index1, o1List.get(index2));
        o1List.set(index2, o1);
    }

    /**
     * 返回是否相等
     * @param o1 对象
     * @param o2 对象
     * @return true false
     * */
    public abstract boolean compare(T o1, K o2);
}
