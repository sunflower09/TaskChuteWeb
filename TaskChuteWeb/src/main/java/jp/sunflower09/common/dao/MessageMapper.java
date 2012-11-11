package jp.sunflower09.common.dao;

import jp.sunflower09.common.entity.Message;

public interface MessageMapper {
	public Message selectByPrimaryKey(int id);

}
