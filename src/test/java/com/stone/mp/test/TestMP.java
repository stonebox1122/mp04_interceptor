package com.stone.mp.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.baomidou.mybatisplus.plugins.Page;
import com.stone.mp.beans.Emp;
import com.stone.mp.mapper.EmpMapper;

public class TestMP {	
	ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	EmpMapper empMapper = ctx.getBean("empMapper",EmpMapper.class);
	
	//测试分页插件
	@Test
	public void testPage() {		
		List<Emp> emps = empMapper.selectPage(new Page<Emp>(2, 2), null);
		System.out.println(emps);
	}
	
	@Test
	public void testPageInfo() {
		Page<Emp> page = new Page<Emp>(2, 2);
		List<Emp> emps = empMapper.selectPage(page, null);
		System.out.println(emps);
		System.out.println("======获取分页信息======");
		System.out.println("总记录数：" + page.getTotal());
		System.out.println("当前页码：" + page.getCurrent());
		System.out.println("总页码：" + page.getPages());
		System.out.println("每页显示的条数：" + page.getSize());
		System.out.println("是否有上一页：" + page.hasPrevious());
		System.out.println("是否有下一页：" + page.hasNext());
		//将查询的结果封装到page对象中
		page.setRecords(emps);
	}
	
	//测试SQL执行分析插件
	@Test
	public void testSQLExplain() {
		empMapper.delete(null); //全表删除
	}
	
	//测试性能分析插件
	@Test
	public void testPerformance() {
		Emp emp = new Emp();
		emp.setLastName("fff");
		emp.setEmail("fff@stone.com");
		emp.setGender("1");
		emp.setAge(22);
		empMapper.insert(emp);
	}
	
	//测试乐观锁插件
	@Test
	public void testOptimisticLocker() {
		Emp emp = new Emp();
		emp.setId(5);
		emp.setLastName("tom");
		emp.setEmail("tom@stone.com");
		emp.setGender("1");
		emp.setAge(22);
		emp.setVersion(1);
		empMapper.updateById(emp);
	}
}
