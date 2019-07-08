/****************************************************************************************
 南京小视科技有限公司
 ****************************************************************************************/
package com.minivision.reus.common.util;

import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.boot.web.servlet.ErrorPageRegistrar;
import org.springframework.boot.web.servlet.ErrorPageRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * <Description>: ErrorPageConfig<br>
 *
 * @author wcx<br>
 * @version 1.0<br>
 * @CreateDate 2019/07/04
 */
@Component
public class ErrorPageConfig implements ErrorPageRegistrar {

    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        ErrorPage error401Page=new ErrorPage(HttpStatus.UNAUTHORIZED,"/index.html");
        registry.addErrorPages(error401Page);
    }
}
