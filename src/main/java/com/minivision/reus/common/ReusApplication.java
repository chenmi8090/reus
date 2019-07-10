package com.minivision.reus.common;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import com.minivision.spring.framework.util.SpringContextHelper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.io.IOException;

/**
 * <Description> 后台启动类<br>
 *
 * @author xubin<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018年4月11日 <br>
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
//@MapperScan("com.minivision")
@ComponentScan(basePackages = "com.minivision",
        excludeFilters = { @ComponentScan.Filter(type = FilterType.CUSTOM, value = { PackageExcludeFilter.class })
        })
@EnableTransactionManagement
@EnableAsync
@RestController
@EnableDubboConfiguration
public class ReusApplication {
    /**
     * result <br>
     */
    private static String result = "hello, welcome to reus, i still alive!!!";

    /**
     * Description: 启动springboot<br>
     *
     * @param args <br>
     * @author QSS<br>
     * @taskId <br>
     */
    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext confApp = null;
        try {
            confApp = SpringApplication.run(ReusApplication.class, args);
        } finally {
            Runtime.getRuntime().exec("cmd /c start http://localhost:8099/reus/#/login");
            close(confApp);
        }
    }

    /**
     * Description:注入springContextHelper <br>
     *
     * @return {@link com.minivision.spring.framework.util.SpringContextHelper}<br>
     * @author qss<br>
     * @taskId <br>
     */
    @Bean
    public SpringContextHelper springHelper() {
        return new SpringContextHelper();
    }

    /**
     * Description: 优雅关闭服务<br>
     *
     * @param confApp confApp<br>
     * @author QSS<br>
     * @taskId <br>
     */
    private static void close(ConfigurableApplicationContext confApp) {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            if (confApp != null) {
                confApp.close();
            }
        }));
    }

    /**
     * Description: 健康检查<br>
     *
     * @return <br>
     * @author niewenxuan<br>
     * @taskId <br>
     */
    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcomeGateway() {
        return result;
    }

    /**
     * Description: 支持跨域<br>
     *
     * @return <br>
     * @author jiangzhenya<br>
     * @taskId <br>
     */
    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(source);
    }
}
