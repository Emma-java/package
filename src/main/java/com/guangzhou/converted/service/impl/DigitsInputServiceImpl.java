package com.guangzhou.converted.service.impl;

import com.guangzhou.converted.common.CommonCheck;
import com.guangzhou.converted.service.DigitsInputService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

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
    public void digitsToWrite() {
        try{
            System.out.println("请输入0到9的数字:");
            //从键盘输入数据
            Scanner scan = new Scanner(System.in);
            //定义输入的数字,判断输入数字是否合法
            String digits = CommonCheck.CheckDigits(scan);
            //数字合法后，对输入数字进行拆分和获取对应的字母集合
            StringBuilder arrInput = new StringBuilder("Input：arr [] ={");
            String[] arrStr = digits.split("");
            //定义数字对应的字母集合
            List<String[]> dataList = new ArrayList<String[]>();
            //获取按键数组常量
            Map<String, List> digitsMap = CommonCheck.initDigitsMap();
            for (int i = 0; i < arrStr.length; i++) {
                //给数组加入逗号
                arrInput.append(arrStr[i]);
                if (i < arrStr.length - 1) {
                    arrInput.append(",");
                }
                //将常量中的数据添加到List中
                List<String> writeList = digitsMap.get(arrStr[i]);
                if (writeList.size() > 0) {
                    //没有数据的集合不能强行转换为数组
                    String[] writeArr = (String[]) writeList.toArray();
                    dataList.add(writeArr);
                }
            }
            arrInput.append("}");
            //递归实现多数组排列组合，并返回最终的排列集合
            List<String[]> resultList = CommonCheck.makeupLetters(dataList, 0, null);
            //打印输入内容
            System.out.println(arrInput.toString());
            System.out.print("Output:");
            //打印输出排列组合结果
            for (int i = 0; i < resultList.size(); i++) {
                String[] letterArr = resultList.get(i);
                System.out.print(" ");
                for (String s : letterArr) {
                    System.out.print(s);
                }
            }
        }catch (Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }



}
