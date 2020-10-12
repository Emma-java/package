package com.guangzhou.converted.service.impl;

import com.guangzhou.converted.service.DigitsInputService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @date 2020/20/11
 */
@Service
public class DigitsInputServiceImpl implements DigitsInputService {

    private static final Logger logger = LoggerFactory.getLogger(DigitsInputServiceImpl.class);

    /**
     * 将控制台输入的0-9的数字对应的字母输出
     */
    @Override
    public List<String> digitsToWrite(String digits) {
        logger.info("输入的数字： " + digits);
        List<String> list = new ArrayList<String>();
        if (digits.length() == 0)
            return list;
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        for (int i = 0; i < map.get(digits.charAt(0) - 48).length(); i++) {
            list.add(map.get(digits.charAt(0) - 48).substring(i, i + 1));
        }
        for (int i = 1; i < digits.length(); i++) {
            String str = map.get(digits.charAt(i) - 48);
            int len = list.size();
            for (int k = 0; k < len; k++) {
                String s = list.get(0);
                list.remove(0);
                for (int m = 0; m < str.length(); m++) {
                    list.add(s + str.substring(m, m + 1));
                }
            }
        }
        return list;
    }
}
