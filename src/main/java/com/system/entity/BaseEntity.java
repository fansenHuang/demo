package com.system.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * <p>关系型数据库基础通用列实体类</p>
 * @author liwei
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseEntity<T extends Model<T>>extends Model<T> implements Serializable {

	@ApiModelProperty(value = "主键（不用填写）", hidden = true)
	@TableField(fill = FieldFill.INSERT)
	private Integer ID;

	@ApiModelProperty(value = "创建人（不用填写）", hidden = true)
	@TableField(fill = FieldFill.INSERT)
	private String createBy;

	@ApiModelProperty(value = "更新人（不用填写）", hidden = true)
	@TableField(fill = FieldFill.UPDATE)
	private String updateBy;

	@ApiModelProperty(value = "创建时间（不用填写）", hidden = true)
	@TableField(fill = FieldFill.INSERT)
	private Date createTime;

	@ApiModelProperty(value = "更新时间（不用填写）", hidden = true)
	@TableField(fill = FieldFill.UPDATE)
	private Date updateTime;

	/**
	 * 设置主键
	 */
	@Override
	protected Serializable pkVal() {
		return this.ID;
	}


}
