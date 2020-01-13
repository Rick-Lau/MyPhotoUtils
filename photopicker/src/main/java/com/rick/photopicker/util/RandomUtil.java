package com.rick.photopicker.util;

import java.util.Random;

/**
 * Created by Rick.Lau on 2020/1/13 9:56.
 */


public class RandomUtil {
    /**
     * 取某个范围的任意数
     * @param min
     * @param max
     * @return
     */
    public static int getRandom(int min, int max){
        Random random = new Random();
        int s = random.nextInt(max) % (max - min + 1) + min;
        return s;
    }
}
