package com.dossen.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName TestHello
 * @Description: TODO
 * @Author Haosion
 * @Date 2019/10/10
 * @Version V1.0
 **/

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestHello {
    @Test
    public void test(){
        long l = System.currentTimeMillis();
        System.out.println(l);

    }

}
