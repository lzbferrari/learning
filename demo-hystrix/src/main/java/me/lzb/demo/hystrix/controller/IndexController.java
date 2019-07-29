package me.lzb.demo.hystrix.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LZB
 */
@RestController
public class IndexController {

    @GetMapping("/demo")
    public String demo() {
        System.out.printf("[%s] demo 接口 : %d\n", Thread.currentThread().getName());
        return "demo!";
    }


    //使用hystrix限流的接口，会发生线程切换，最终执行业务逻辑的是hystrix的线程，不是web容器的线程
    //使用threadLocal会出问题，基于threadLocal的spring事务也会出问题

    @GetMapping("")
    @HystrixCommand(commandProperties = {
        @HystrixProperty(
            name = "execution.isolation.thread.timeoutInMilliseconds",
            value = "50"
        )},
        fallbackMethod = "fallbackMethod"
    )
    public String index(@RequestParam(required = false, defaultValue = "10") int costTime) throws InterruptedException {
        Thread.sleep(costTime);
        System.out.printf("[%s] Execution costs time : %d\n", Thread.currentThread().getName(), costTime);
        return "hystrix demo!!";
    }


    public String fallbackMethod(int costTime) {
        System.out.printf("[%s] fallback costs time : %d\n", Thread.currentThread().getName(), costTime);
        return "fallback - costTime :" + costTime + "ms";
    }


}
