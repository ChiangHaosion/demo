package com.dossen.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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


    //记录器
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void test() {
        long l = System.currentTimeMillis();
        System.out.println(l);

    }

    @Test
    public void testLog() {
        //日志的级别 由低到高trace<debug<info<warn<error
        //可以调整输出的日志级别；日志就只会在这个级别以以后的高级别生效
        //trace 跟踪 debug调试 info 信息 warn 警告 error 错误
        logger.trace("这是trace日志...");
        logger.debug("这是debug日志...");
        //SpringBoot默认给我们使用的是info级别的，没有指定级别的就用SpringBoot默认规定的级别；root级别
        logger.info("这是info日志...");
        logger.warn("这是warn日志...");
        logger.error("这是error日志...");
    }

}
