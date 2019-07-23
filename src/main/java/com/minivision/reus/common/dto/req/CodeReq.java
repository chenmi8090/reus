/****************************************************************************************
 南京小视科技有限公司
 ****************************************************************************************/
package com.minivision.reus.common.dto.req;

import com.minivision.common.framework.validation.annotation.NotEmpty;
import com.minivision.reus.common.dto.code.ClassDTO;
import com.minivision.reus.common.dto.database.DatabaseDTO;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * <Description>: CodeReq<br>
 *
 * @author wcx<br>
 * @version 1.0<br>
 * @CreateDate 2019/06/24
 */
@Data
public class CodeReq implements Serializable {

    private String facadeImplPath;

    private String primaryKey = "id";

    private String encoding;

    private String xmlPath;

    @NotEmpty
    private String tableName;

    @NotEmpty
    private String author;

    @NotEmpty
    private String parentPackageName;

    @NotEmpty
    private String mapperName;

    @NotNull
    private DatabaseDTO dataSource;

    @NotNull
    private ClassDTO controller;

    @NotNull
    private ClassDTO service;

    @NotNull
    private ClassDTO dto;

    @NotNull
    private ClassDTO mainService;

    @NotNull
    private ClassDTO facade;

    @NotNull
    private ClassDTO entity;

    @NotNull
    private ClassDTO mapper;

}
