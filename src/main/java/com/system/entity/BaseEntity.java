package com.system.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>实体类继承这个类</p>
 * @author wendong
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseEntity implements Serializable {

	@ApiModelProperty(value = "主键")
	private Integer ID;

	@ApiModelProperty(value = "创建人")
	private String createBy;

	@ApiModelProperty(value = "更新人")
	private String updateBy;

	@ApiModelProperty(value = "创建时间")
	private Date createTime;

	@ApiModelProperty(value = "更新时间")
	private Date updateTime;
}
