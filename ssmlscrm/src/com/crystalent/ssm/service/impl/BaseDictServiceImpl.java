package com.crystalent.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crystalent.ssm.dao.BaseDictDao;
import com.crystalent.ssm.pojo.BaseDict;
import com.crystalent.ssm.service.BaseDictService;
@Service
public class BaseDictServiceImpl implements BaseDictService{
	
	@Autowired
	private BaseDictDao baseDictDao;

	@Override
	public List<BaseDict> getBaseDictListByTypeCode(String typeCode) {
		
		List<BaseDict> list = baseDictDao.getBaseDictListByTypeCode(typeCode);
		
		return list;
	}

}
