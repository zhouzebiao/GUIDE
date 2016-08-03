package com.data.controller.visitorController;

import java.io.IOException;
import java.io.Writer;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.data.model.tb_adviceModel;
import com.data.service.visitorService.checkAdviceService.CheckAdvice;

@Controller
public class CheckAdviceController {
	@RequestMapping("/getAdviceNumber")
	@ResponseBody
	public String getAdviceNumber(HttpServletResponse response)
			throws IOException {
		ApplicationContext factory = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		CheckAdvice checkAdvice = (CheckAdvice) factory.getBean("CheckAdvice");
		System.out.println(checkAdvice.queryAdviceNumber());
		Writer writer = response.getWriter();
		int number = checkAdvice.queryAdviceNumber();
		String json = "{\"number\":" + number + "}";
		writer.write(json);
		System.out.println("/getAdviceNumber");
		return null;
	}

	@RequestMapping("/getAdviceRecordList")
	@ResponseBody
	public List<Object> getAdviceRecordList() throws IOException {
		System.out.println("getAdviceRecordList");
		ApplicationContext factory = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		CheckAdvice checkAdvice = (CheckAdvice) factory.getBean("CheckAdvice");
		List<Object> adviceRecordList = new LinkedList<Object>();
		adviceRecordList = checkAdvice.queryAdviceRecord();
		
		if (adviceRecordList != null)
		{
			System.out.println(adviceRecordList.size());
			System.out.println("数据提取成功");
			JSONArray jsonArray=JSONArray.fromObject(adviceRecordList);
			//System.out.println(jsonArray);
			//tb_adviceModel t=(tb_adviceModel) adviceRecordList.get(0);
			//System.out.println(t.getADid());
			return jsonArray;
			
		}
		else {
			System.out.println(0);
		}
		
		return null;
	}
	
	@RequestMapping("/getTitleAndAdvice")
	@ResponseBody
    public JSONArray getTitleAndAdvice(@RequestParam(value = "ADid", required = false) String ADid)
    {
		ApplicationContext factory = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		CheckAdvice checkAdvice = (CheckAdvice) factory.getBean("CheckAdvice");
		tb_adviceModel tbAdviceModel=(tb_adviceModel) checkAdvice.queryTitleAndAdvice(ADid);
		JSONArray jsonArray=JSONArray.fromObject(tbAdviceModel);
		System.out.println(jsonArray);
		return jsonArray;
    }
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		CheckAdvice checkAdvice = (CheckAdvice) factory.getBean("CheckAdvice");
		
		/*System.out.println(checkAdvice.queryAdviceNumber());
		List<Object> adviceRecordList = new LinkedList<Object>();
		adviceRecordList = checkAdvice.queryAdviceRecord();
		if (adviceRecordList != null)
			System.out.println(adviceRecordList.size());
		else {
			System.out.println(0);
		}*/
		tb_adviceModel tbAdviceModel=(tb_adviceModel) checkAdvice.queryTitleAndAdvice("201608031535331");
		System.out.println(tbAdviceModel.getTitle()+" "+tbAdviceModel.getAdvice());
	}
}
