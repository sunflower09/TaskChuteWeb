package jp.sunflower09.common.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.arnx.jsonic.JSON;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public abstract class AjaxAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		Object jsonObject = execute(form, request, response);

		String jsonString = JSON.encode(jsonObject);
		response.setContentType("application/json; charset=UTF-8");

		PrintWriter writer = response.getWriter();
		writer.print(jsonString);
		writer.close();

		return null;
	}

	protected abstract Object execute(ActionForm form,
			HttpServletRequest request, HttpServletResponse response);
}
