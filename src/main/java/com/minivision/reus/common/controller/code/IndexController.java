/****************************************************************************************
 南京小视科技有限公司
 ****************************************************************************************/
package com.minivision.reus.common.controller.code;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <Description>: IndexController<br>
 *
 * @author wcx<br>
 * @version 1.0<br>
 * @CreateDate 2019/07/04
 */
@Controller
@Slf4j
@CrossOrigin
public class IndexController {

    @RequestMapping("/")
    public String index() {
        System.out.println("1111");
        return "forward:/index.html";
    }

}
