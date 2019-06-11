/************************************************************************** 
 南京小视科技有限公司           
 **************************************************************************/
package com.minivision.reus.common.dto.resp;

import com.minivision.reus.common.dto.entity.ControllerEntity;
import com.minivision.reus.common.dto.entity.DTOEntity;
import com.minivision.reus.common.dto.entity.Entity;
import com.minivision.reus.common.dto.entity.MapperEntity;
import com.minivision.reus.common.dto.entity.ServiceEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * <Description>: ClassAndPackageResp<br>
 *
 * @author chenmin<br>
 * @version 1.0<br>
 * @CreateDate 2019年06月10日
 */
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ClassAndPackageResp implements Serializable {

    /**
     * 是否分页
     */
    private boolean isPaging;

    /**
     * 表名
     */
    private String tableName;

    /**
     * 编码格式
     */
    private String encoding;

    /**
     * Controller类参数
     */
    private ControllerEntity controller;

    /**
     * Service类参数
     */
    private ServiceEntity service;

    /**
     * 实体类参数
     */
    private Entity entity;

    /**
     * DTO类参数
     */
    private DTOEntity dto;

    /**
     * Mapper文件参数
     */
    private MapperEntity mapper;

}
