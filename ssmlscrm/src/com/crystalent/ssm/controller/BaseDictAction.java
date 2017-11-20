package com.crystalent.ssm.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crystalent.ssm.pojo.BaseDict;
import com.crystalent.ssm.pojo.Constants;
import com.crystalent.ssm.pojo.Customer;
import com.crystalent.ssm.pojo.QueryVo;
import com.crystalent.ssm.service.BaseDictService;
import com.crystalent.ssm.service.CustomerService;
import com.crystalent.ssm.util.Page;

@Controller
public class BaseDictAction {
	@Autowired
	private BaseDictService baseDictService;
	
	@Autowired
	private CustomerService customerService;

	@RequestMapping("/customer/list")
	public String listCustomer(Model model,QueryVo queryVo){
		//获取下拉列表的值，展示在页面
		//1.注入service
		//2.调用service的方法获取值
		
		List<BaseDict>custResourcelist = baseDictService.getBaseDictListByTypeCode(Constants.CON_cust_source);
		List<BaseDict>custIndustrylist = baseDictService.getBaseDictListByTypeCode(Constants.CON_cust_industry);
		List<BaseDict>custLevellist = baseDictService.getBaseDictListByTypeCode(Constants.CON_cust_level);
		
		
		
		//3.设置模型数据
		model.addAttribute("fromType", custResourcelist);
		model.addAttribute("industryType", custIndustrylist);
		model.addAttribute("levelType", custLevellist);
		
		Page<Customer> page = customerService.getCustomerListByQueryVo(queryVo);
		model.addAttribute("page",page);
		
		//4.返回即可
		return "customer";
	}

	@RequestMapping(value="/customer/update",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String updateCustomer(Customer customer){
		customerService.updateCustomer(customer);
		
		return "{\"name\":12}";
	}
}
