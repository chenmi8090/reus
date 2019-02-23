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
public class PackageExcludeFilter extends RegexPatternTypeFilter
{
    public PackageExcludeFilter() {
        super(Pattern.compile("com.minivision.sms.*"));
    }
}
