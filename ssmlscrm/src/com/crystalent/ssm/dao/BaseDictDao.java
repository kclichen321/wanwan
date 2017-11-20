package com.crystalent.ssm.dao;

import java.util.List;

import com.crystalent.ssm.pojo.BaseDict;

public interface BaseDictDao {
	/**
	 * 基本信息查询
	 * @param typeCode
	 * @return
	 */
	public List<BaseDict> getBaseDictListByTypeCode(String typeCode);
}
