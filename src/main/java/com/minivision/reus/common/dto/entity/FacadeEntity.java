/************************************************************************** 
 南京小视科技有限公司           
 **************************************************************************/
package com.minivision.reus.common.dto.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * <Description>: DTO<br>
 *
 * @author chenmin<br>
 * @version 1.0<br>
 * @CreateDate 2019年06月10日
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FacadeEntity implements Serializable {

    /**
     * DTO类名称
     */
    private String name;

    /**
     * DTO包名称
     */
    private String packageName;

    /**
     * DTO层路径
     */
    private String path;

    /**
     * 是否自动生成
     */
    private boolean isGenerate;

}
