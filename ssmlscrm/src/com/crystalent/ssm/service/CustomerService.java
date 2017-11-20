package com.crystalent.ssm.service;

import com.crystalent.ssm.pojo.Customer;
import com.crystalent.ssm.pojo.QueryVo;
import com.crystalent.ssm.util.Page;

public interface CustomerService {

	/**
	 * 基本信息查询
	 * @param typeCode
	 * @return
	 */
	public Page<Customer> getCustomerListByQueryVo(QueryVo queryVo);
	
	/**
	 * 查询客户信息
	 * @param customer
	 */
	public void updateCustomer(Customer customer);
	
}
