package jp.sunflower09.common.bean;

import java.sql.Timestamp;

import jp.sunflower09.common.entity.Task;
import jp.sunflower09.common.util.Pager;

public class TaskCondition extends Task {
  /**
   * 
   */
  private static final long serialVersionUID = -7624644012211001265L;

  private Timestamp dateFrom = null;
  private Timestamp dateTo = null;
  private Timestamp startTimeFrom = null;
  private Timestamp startTimeTo = null;
  private Timestamp endTimeFrom = null;
  private Timestamp endTimeTo = null;

  private Pager pager = null;

  public Timestamp getDateFrom() {
    return dateFrom;
  }

  public void setDateFrom(Timestamp dateFrom) {
    this.dateFrom = dateFrom;
  }

  public Timestamp getDateTo() {
    return dateTo;
  }

  public void setDateTo(Timestamp dateTo) {
    this.dateTo = dateTo;
  }

  public Timestamp getStartTimeFrom() {
    return startTimeFrom;
  }

  public void setStartTimeFrom(Timestamp startTimeFrom) {
    this.startTimeFrom = startTimeFrom;
  }

  public Timestamp getStartTimeTo() {
    return startTimeTo;
  }

  public void setStartTimeTo(Timestamp startTimeTo) {
    this.startTimeTo = startTimeTo;
  }

  public Timestamp getEndTimeFrom() {
    return endTimeFrom;
  }

  public void setEndTimeFrom(Timestamp endTimeFrom) {
    this.endTimeFrom = endTimeFrom;
  }

  public Timestamp getEndTimeTo() {
    return endTimeTo;
  }

  public void setEndTimeTo(Timestamp endTimeTo) {
    this.endTimeTo = endTimeTo;
  }

  public Pager getPager() {
    return pager;
  }

  public void setPager(Pager pager) {
    this.pager = pager;
  }

}
