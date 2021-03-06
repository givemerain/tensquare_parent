package cn.tensquare.spit;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import utils.IdWorker;

/**
 * @author ye jiacheng
 * @create 2018-09-03
 */
public class SpitApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpitApplication.class, args);
    }

    @Bean
    public IdWorker idWorkker(){
        return new IdWorker(1, 1);
    }
}
