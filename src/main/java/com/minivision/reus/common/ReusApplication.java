package com.minivision.reus.common;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import com.minivision.spring.framework.util.SpringContextHelper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * <Description> 后台启动类<br>
 * 
 * @author xubin<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018年4月11日 <br>
 */
@SpringBootApplication
@MapperScan("com.minivision")
@ComponentScan(basePackages = "com.minivision")
@EnableTransactionManagement
@EnableAsync
@RestController
@EnableDubboConfiguration
public class ReusApplication {
    /**
     * result <br>
     */
    private static String result = "hello, welcome to sms, i still alive!!!";

    /**
     * Description: 启动springboot<br>
     *
     * @author QSS<br>
     * @taskId <br>
     * @param args <br>
     */
    public static void main(String[] args) {
        ConfigurableApplicationContext confApp = null;
        try {
            confApp = SpringApplication.run(ReusApplication.class, args);

        } finally {
            close(confApp);
        }
    }

    /**
     * Description:注入springContextHelper <br>
     *
     * @author qss<br>
     * @taskId <br>
     * @return {@link com.minivision.spring.framework.util.SpringContextHelper}<br>
     */
    @Bean
    public SpringContextHelper springHelper() {
        return new SpringContextHelper();
    }

    /**
     * Description: 优雅关闭服务<br>
     *
     * @author QSS<br>
     * @taskId <br>
     * @param confApp confApp<br>
     */
    private static void close(ConfigurableApplicationContext confApp) {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                if (confApp != null) {
                    confApp.close();
                }
            }
        });
    }
    
    /**
     * Description: 健康检查<br>
     * 
     * @author niewenxuan<br>
     * @taskId <br>
     * @return <br>
     */
    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcomeGateway() {
        return result;
    }
}
