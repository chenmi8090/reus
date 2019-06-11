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
 * <Description>: Entity<br>
 *
 * @author chenmin<br>
 * @version 1.0<br>
 * @CreateDate 2019年06月10日
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Entity implements Serializable {

    /**
     * 实体类ID
     */
    private String id;

    /**
     * 实体类名称
     */
    private String name;

    /**
     * 实体类包名称
     */
    private String packageName;

    /**
     * 实体类路径
     */
    private String path;

    /**
     * 是否自动生成
     */
    private boolean isGenerate;

}
