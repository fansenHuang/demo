package com.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * <p>角色表对象</p>
 * @author liwei
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "role")
public class Role extends BaseEntity<Role> {

	@ApiModelProperty(value = "角色名")
	private String name;

	@ApiModelProperty(value = "描述")
	private String remarks;

	@ApiModelProperty(value = "状态 0启用 1停用")
	private Integer status;

	@ApiModelProperty(value = "我不知道这是啥")
	private String roleRule;

	@ApiModelProperty(value = "为了实现回显 true/false")
	private Boolean checked = false;
}
