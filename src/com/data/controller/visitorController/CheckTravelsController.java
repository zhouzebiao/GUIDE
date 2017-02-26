package com.data.controller.visitorController;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.data.model.PositioningModel;
import com.data.model.tb_visitorModel;
import com.data.service.visitorService.attractionsPositioningService.attractionsPositioningServiceImp;
import com.data.service.visitorService.checkTravelsService.checkTravelsService;
import com.data.service.visitorService.checkTravelsService.checkTravelsServiceImp;

@Controller
public class CheckTravelsController {
	
	 List<Object> checktravelmodellist;
	 List list = new ArrayList();
	@RequestMapping("/checkTravelsUrl")
	@ResponseBody
	public ModelAndView handleRequest(HttpServletRequest request,
		HttpServletResponse response) throws Exception {
		//解决request传进中文"？？？"
		request.setCharacterEncoding("utf-8");
		//解决response传出中文“？？？”
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		//检查是否运行到这里	
		System.out.println("test                                             test");
		
		String visitor = request.getParameter("Visitor");	
		System.out.println(visitor+"test visitor");
	
			@SuppressWarnings("resource")
			ClassPathXmlApplicationContext factory= new ClassPathXmlApplicationContext("applicationContext.xml");
			tb_visitorModel tb_visitormodel=(tb_visitorModel)factory.getBean("tb_visitormodel");
			checkTravelsServiceImp ctlserviceimp=(checkTravelsServiceImp)factory.getBean("checkTravelsServiceImp");//检查是否运行到这里
			System.out.println("test  checkTravelsController");
			
			tb_visitormodel.setVisitor(visitor);
			
			checktravelmodellist=ctlserviceimp.CheckTravels(tb_visitormodel);
			//测试
			//System.out.println(checktravelmodellist);
			
			list=checktravelmodellist;
			
			Map map = new HashMap();
			map.put("list",list);
			JSONObject jso = JSONObject.fromObject(map);
			System.out.println(jso);
			out.print(jso);
			out.flush();
			out.close();
			return null;
	}
}
