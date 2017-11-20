package com.crystalent.ssm.dao;

import java.util.List;

import com.crystalent.ssm.pojo.Customer;
import com.crystalent.ssm.pojo.QueryVo;

public interface CustomerMapper {
	

	/**
	 *  根据查询条件查询客户列表
	 * @return
	 */
	public List<Customer> getCustomerListByQueryVo(QueryVo queryVo);
	
	/**
	 * 根据查询条件统计总记录数
	 */
	public Integer getCountCustomer(QueryVo queryVo);
	
	/**
	 * 修改用户信息
	 */
	public void updateCustomer(Customer customer);
	
}
