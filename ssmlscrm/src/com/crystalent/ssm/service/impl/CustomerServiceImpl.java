package com.crystalent.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crystalent.ssm.dao.CustomerMapper;

import com.crystalent.ssm.pojo.Customer;
import com.crystalent.ssm.pojo.QueryVo;
import com.crystalent.ssm.service.CustomerService;
import com.crystalent.ssm.util.Page;
@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerMapper customerMapper;
	
	@Override
	public Page<Customer> getCustomerListByQueryVo(QueryVo queryVo) {
		
		//根据queryVo传递的分页的值进行计算设置
		if(queryVo!=null){
			if(queryVo.getPage()==null){
				queryVo.setPage(1);
			}
			queryVo.setStart((queryVo.getPage()-1)*queryVo.getSize());
		}
		
		List<Customer> list = customerMapper.getCustomerListByQueryVo(queryVo);
		
		Integer total = customerMapper.getCountCustomer(queryVo);
		
		Page<Customer> page =new Page<Customer>();
		page.setPage(queryVo.getPage());
		page.setRows(list);
		page.setSize(queryVo.getSize());
		page.setTotal(total);//总记录数是查出来的
		
		return page;
	}

	
	public void updateCustomer(Customer customer) {
		
		customerMapper.updateCustomer(customer);
	}

}
