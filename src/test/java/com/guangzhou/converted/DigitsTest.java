package com.guangzhou.converted;

import com.guangzhou.converted.service.impl.DigitsInputServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @date 2020/20/11
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DigitsTest {

    @Test
    public void test() {
        DigitsInputServiceImpl digitsInputService = new DigitsInputServiceImpl();
        digitsInputService.digitsToWrite();
    }
}
