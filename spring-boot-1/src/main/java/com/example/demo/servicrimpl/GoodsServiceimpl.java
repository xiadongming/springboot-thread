package com.example.demo.servicrimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.demo.mapper.GoodsMapper;
import com.example.demo.pojo.Googs;
import com.example.demo.service.GoodsService;

@Service
public class GoodsServiceimpl extends ServiceImpl<GoodsMapper,Googs> implements GoodsService {
	
	
	@Override
	public void getTest() { 
		
		EntityWrapper<Googs> entityWrapper = new EntityWrapper<Googs>();
		List<Googs> selectList = baseMapper.selectList(entityWrapper);
		for (Googs googs : selectList) {
			
			System.out.println(googs);
			
		}
	}
	


}
