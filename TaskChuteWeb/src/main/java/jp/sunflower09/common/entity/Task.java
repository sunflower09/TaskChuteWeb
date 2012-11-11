package jp.sunflower09.common.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class Task implements Serializable {
  /**
	 * 
	 */
  private static final long serialVersionUID = 1931971779466720842L;

  private Integer id = null;
  private Date taskDate = null;
  private Boolean complete = null;
  private String taskType = null;
  private String section = null;
  private String title = null;
  private Boolean repeat = null;
  private Timestamp startTime = null;
  private Timestamp endTime = null;
  private Float actualMinute = null;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Date getTaskDate() {
    return this.taskDate;
  }

  public void setTaskDate(Date taskDate) {
    this.taskDate = taskDate;
  }

  public Boolean isComplete() {
    return complete;
  }

  public void setComplete(Boolean complete) {
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

  public Boolean isRepeat() {
    return repeat;
  }

  public void setRepeat(Boolean repeat) {
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

  public Float getActualMinute() {
    return actualMinute;
  }

  public void setActualMinute(Float actualMinute) {
    this.actualMinute = actualMinute;
  }

}
