package com.guangzhou.converted.common;

import java.util.*;

/**
 * @date 2020/20/11
 */
public class CommonCheck {
    /**
     * 判断输入数字是否合法
     * @param scan 从键盘输入的数据
     * @return
     */
    public static String CheckDigits(Scanner scan) throws Exception {
        String digits = "";
        //判断输入数字是否合法
        while (true) {
            digits = scan.next();
            if (!digits.matches("[0-9]{1,2}")) {
                System.out.println("输入不合法！只能输入0-99的整数数字,请重新输入：");
            } else {
                break;
            }
        }
        return digits;
    }

    /**
     * 初始化数据
     * 使用HashMap来存储数字和字母的映射关系，其中数字作为key，字母作为value，
     * 因为一个数字对应了多个字母，且每个数字对应的字母个数又不尽相同，所以这里的value使用List集合来进行存放
     * @return
     * @throws Exception
     */
    public static Map<String, List> initDigitsMap() throws Exception {
        Map<String, List> map = new HashMap<String, List>();
        map.put("1", Arrays.asList(""));
        map.put("2", Arrays.asList("a", "b", "c"));
        map.put("3", Arrays.asList("d", "e", "f"));
        map.put("4", Arrays.asList("g", "h", "i"));
        map.put("5", Arrays.asList("j", "k", "l"));
        map.put("6", Arrays.asList("m", "n", "o"));
        map.put("7", Arrays.asList("p", "q", "r", "s"));
        map.put("8", Arrays.asList("t", "u", "v"));
        map.put("9", Arrays.asList("w", "x", "y", "z"));
        map.put("0", Arrays.asList(""));
        map.put("*", Arrays.asList(""));
        map.put("#", Arrays.asList(""));
        return map;
    }

    /**
     * 递归实现多数组排列组合
     * @param dataList 字母集合
     * @param index
     * @param resultList
     * @return
     */
    public static List<String[]> makeupLetters(List<String[]> dataList, int index, List<String[]> resultList) throws Exception {
        if (index == dataList.size()) {
            return resultList;
        }

        List<String[]> resultList0 = new ArrayList<String[]>();
        if (index == 0) {
            //第一列数组默认有多少个字母就添加多少个排列数据
            String[] dataArr = dataList.get(0);
            for (String s : dataArr) {
                resultList0.add(new String[]{s});
            }
        } else {
            String[] dataArr = dataList.get(index);
            for (String[] dataArr0 : resultList) {
                for (String s : dataArr) {
                    //复制数组并扩充新元素
                    String[] dataArrCopy = new String[dataArr0.length + 1];
                    System.arraycopy(dataArr0, 0, dataArrCopy, 0, dataArr0.length);
                    dataArrCopy[dataArrCopy.length - 1] = s;
                    //追加到结果集
                    resultList0.add(dataArrCopy);
                }
            }
        }
        return makeupLetters(dataList, ++index, resultList0);
    }
}
