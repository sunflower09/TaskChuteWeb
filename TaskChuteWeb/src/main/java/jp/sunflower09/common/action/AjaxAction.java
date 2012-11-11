package jp.sunflower09.common.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.arnx.jsonic.JSON;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * Json返却用Actionクラス
 * 
 * @author cyubachi
 * 
 */
public abstract class AjaxAction extends Action {
  /**
   * Json返却用executeメソッド。実装側から返却されたオブジェクトをJsonic経由でJson文字列として出力する。
   * 
   * @param mapping
   *          strutsのexecuteから渡されるmapping
   * @param form
   *          strutsのexecuteから渡されるform
   * @param request
   *          strutsのexecuteから渡されるrequest
   * @param response
   *          strutsのexecuteから渡されるresponse
   */
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

  /**
   * 実装クラス側で実装するexecuteメソッド。画面側に返却したいJsonオブジェクトを返却する。
   * 
   * @param form
   * @param request
   * @param response
   * @return Jsonオブジェクト
   */
  protected abstract Object execute(ActionForm form,
      HttpServletRequest request, HttpServletResponse response);
}
