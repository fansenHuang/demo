package com.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>用户详情</p>
 *
 * @author liwei
 * @date 2019/2/22 14:43
 **/
@Getter
@Setter
@ToString
@TableName(value = "user")
public class User extends BaseEntity {
	 
	private static final long serialVersionUID = -8044013948470887797L;

    @ApiModelProperty(value = "用户名")
	private String userName;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "状态 0 停用  1 启用")
    private Integer status;

}
