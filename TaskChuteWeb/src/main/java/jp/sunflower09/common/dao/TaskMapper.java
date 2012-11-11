package jp.sunflower09.common.dao;

import jp.sunflower09.common.entity.Task;

public interface TaskMapper {
	public Task selectByPrimaryKey(Integer id);

}
