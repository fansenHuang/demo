package com.system.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * <p>部门表对象</p>
 * @author liwei
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "dept")
public class Dept {

    @ApiModelProperty(value = "部门id")
	private Integer id;

    @ApiModelProperty(value = "部门名称")
	private String name;

    @ApiModelProperty(value = "上级部门id")
	private Integer pId;
	
}
