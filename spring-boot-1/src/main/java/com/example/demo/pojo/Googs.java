package com.example.demo.pojo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

@TableName(value="city")
public class Googs implements Serializable {


	 @TableId(value = "id", type = IdType.AUTO) // 主键自增长
     private Integer id;

 	 @TableField(value = "name")
     private String name;

 	@TableField(value = "state")
     private String state ;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Googs [id=" + id + ", name=" + name + ", state=" + state + "]";
	}
   
}
