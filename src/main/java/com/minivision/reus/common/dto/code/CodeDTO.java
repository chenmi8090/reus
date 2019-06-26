package com.minivision.reus.common.dto.code;

import com.minivision.common.framework.validation.annotation.NotEmpty;
import com.minivision.reus.common.dto.database.DatabaseDTO;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <Description> <br>
 *
 * @author jiangzhenya(jiangzhenya @ aliyun.com)<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018年11月29日 <br>
 */

@Setter
@Getter
public class CodeDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5868157075370413384L;

	@NotEmpty
	private String tableName;

	@NotEmpty
	private String encoding;

	private String primaryKey = "id";

	private ClassDTO controller;

	private ClassDTO service;

	private ClassDTO dto;

	private ClassDTO entity;

	private ClassDTO mapper;

    private DatabaseDTO dataSource;

	private String mapperName;


}
