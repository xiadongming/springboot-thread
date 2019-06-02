package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.demo.pojo.Googs;
import com.example.demo.service.GoodsService;

@RestController
@RequestMapping("/web")
public class GoodsController {
	
	
	@Autowired
	private GoodsService goodsService;
	
	//查询一个数据
	@RequestMapping("/one")
	public void getDataById() {
		Googs selectOne = goodsService.selectOne(new EntityWrapper<Googs>().eq("id", "1"));
		System.out.println(selectOne);

		List<Googs> list = goodsService.selectList(new EntityWrapper<Googs>().eq("id", "1"));
		System.out.println(list);
		
	}
	 
	 
	//查询所有数据
	@RequestMapping("/html")
	public void getTest() {
		goodsService.getTest();
		//System.out.println(list);
	
	}
	
	
}
