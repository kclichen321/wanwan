package com.crystalent.ssm.service;

import java.util.List;

import com.crystalent.ssm.pojo.BaseDict;

public interface BaseDictService {
	public List<BaseDict> getBaseDictListByTypeCode(String typeCode);
}
