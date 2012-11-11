package jp.sunflower09.common.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.sunflower09.common.form.HelloWorldForm;
import jp.sunflower09.common.service.MyService;

import org.apache.struts.action.ActionForm;
import org.springframework.beans.factory.annotation.Autowired;

public class HelloWorldAction extends StandardAction {

	@Autowired
	MyService service;

	@Override
	protected String execute(ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		HelloWorldForm helloWorldForm = (HelloWorldForm) form;
		helloWorldForm.setMessage(service.sayHello());
		return "success";
	}

}
