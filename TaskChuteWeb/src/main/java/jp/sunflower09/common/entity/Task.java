package jp.sunflower09.common.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Task implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1931971779466720842L;

	private Integer id;
	private boolean complete;
	private String taskType;
	private String section;
	private String title;
	private boolean repeat;
	private Timestamp startTime;
	private Timestamp endTime;
	private float actualMinute;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isComplete() {
		return complete;
	}

	public void setComplete(boolean complete) {
		this.complete = complete;
	}

	public String getTaskType() {
		return taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isRepeat() {
		return repeat;
	}

	public void setRepeat(boolean repeat) {
		this.repeat = repeat;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public float getActualMinute() {
		return actualMinute;
	}

	public void setActualMinute(float actualMinute) {
		this.actualMinute = actualMinute;
	}

}
