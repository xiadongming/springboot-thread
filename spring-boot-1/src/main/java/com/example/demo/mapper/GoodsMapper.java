package com.example.demo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.demo.pojo.Googs;

public interface GoodsMapper extends BaseMapper<Googs> {

	
	/**
	 * 继承basemapper后，不用再写mapper.xml文件，即可实现crud功能
	 * */
}
