package com.minivision.reus.common;

import org.springframework.core.type.filter.RegexPatternTypeFilter;

import java.util.regex.Pattern;

/**
 * <Description> <br>
 *
 * @author jiangzhenya(jiangzhenya @ aliyun.com)<br>
 * @version 1.0<br>
 * @CreateDate 2019年01月15日 <br>
 */
public class ComponentPackageFilter extends RegexPatternTypeFilter
{
    public ComponentPackageFilter() {
        super(Pattern.compile("com.minivision.sms.*"));
    }
}
