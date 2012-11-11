package jp.sunflower09.common.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.sunflower09.common.bean.JqGridResult;
import jp.sunflower09.common.bean.TaskCondition;
import jp.sunflower09.common.service.MyService;

import org.apache.struts.action.ActionForm;
import org.springframework.beans.factory.annotation.Autowired;

public class AjaxSampleAction extends AjaxAction {

  @Autowired
  MyService service;

  @Override
  protected Object execute(ActionForm form, HttpServletRequest request,
      HttpServletResponse response) {
    TaskCondition condition = new TaskCondition();
    condition.setId(1);
    JqGridResult jqGridResult = service.findTask(condition);
    return jqGridResult;
  }

}
