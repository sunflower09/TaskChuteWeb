package jp.sunflower09.common.service;

import jp.sunflower09.common.bean.JqGridResult;
import jp.sunflower09.common.bean.TaskCondition;

public interface MyService {

  public String sayHello();

  public JqGridResult selectTask(Integer id);

  public JqGridResult findTask(TaskCondition condition);

}
