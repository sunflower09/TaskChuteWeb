package jp.sunflower09.common.dao;

import java.util.List;

import jp.sunflower09.common.bean.TaskCondition;
import jp.sunflower09.common.entity.Task;

public interface TaskMapper {
  public Task selectByPrimaryKey(Integer id);

  public List<Task> findByQuery(TaskCondition taskCondition);

}
