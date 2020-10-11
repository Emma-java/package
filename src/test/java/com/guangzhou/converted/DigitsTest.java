package com.guangzhou.converted;

import com.guangzhou.converted.service.impl.DigitsInputServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @date 2020/20/11
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DigitsTest {

    @Test
    public void numberTest() {
        String number = "25";
        DigitsInputServiceImpl digitsInputService = new DigitsInputServiceImpl();
        List<String> list = digitsInputService.digitsToWrite(number);
        System.out.print("转换后的字母= " + list);
    }
}
