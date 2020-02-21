package com.dmgroup.springboot.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {
// ���ڲ�׽Exception�쳣�������࣬��׽��֮�󲢰��쳣��ַ�Ž�ModelAndView�У�Ȼ����ת��errorPage.jsp
	@ExceptionHandler(value = Exception.class)
	public ModelAndView defaultErrorHanler(HttpServletRequest req, Exception e) throws Exception{
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", e);
		mav.addObject("url", req.getRequestURL());
		mav.setViewName("errorPage");
		return mav;
	}
}
