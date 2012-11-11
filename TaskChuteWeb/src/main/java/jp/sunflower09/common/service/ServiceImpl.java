package jp.sunflower09.common.service;

import java.util.ArrayList;
import java.util.List;

import jp.sunflower09.common.bean.JqGridResult;
import jp.sunflower09.common.bean.TaskCondition;
import jp.sunflower09.common.dao.MessageMapper;
import jp.sunflower09.common.dao.TaskMapper;
import jp.sunflower09.common.entity.Message;
import jp.sunflower09.common.entity.Task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceImpl implements MyService {

  @Autowired
  MessageMapper messageMapper;

  @Autowired
  TaskMapper taskMapper;

  @Override
  public String sayHello() {
    Message message = messageMapper.selectByPrimaryKey(1);
    return message.getMessage();
  }

  @Override
  public JqGridResult selectTask(Integer id) {
    Task task = taskMapper.selectByPrimaryKey(1);
    List<Task> taskList = new ArrayList<Task>();
    taskList.add(task);
    return new JqGridResult(taskList, 1, 1, 1);
  }

  @Override
  public JqGridResult findTask(TaskCondition condition) {
    List<Task> taskList = taskMapper.findByQuery(condition);
    return new JqGridResult(taskList, 1, 1, 1);
  }

}
