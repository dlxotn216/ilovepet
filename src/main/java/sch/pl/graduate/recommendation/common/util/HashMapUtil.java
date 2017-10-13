/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-13
 */
package sch.pl.graduate.recommendation.common.util;

/**
 * Created by Lee Tae Su on 2017-10-13.
 */
public class HashMapUtil {

    public static final float LOAD_FACTOR = 0.75f;

    public static int getCapacity(int size) {
        return (int) (size / LOAD_FACTOR) + 1;
    }

}
