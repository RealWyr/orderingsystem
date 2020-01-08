package com.southwind;
//client中异步访问clienthandler里findAll接口，再通过feign访问menu
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
//声明feign接口，用spring框架自动创建feign实现类
public class ClientApplication {
    public static void main(String[] args) {
       SpringApplication.run(ClientApplication.class,args);
    }
}
