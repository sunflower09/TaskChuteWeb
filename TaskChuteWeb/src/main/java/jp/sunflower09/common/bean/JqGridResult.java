package jp.sunflower09.common.bean;

import java.util.List;

public class JqGridResult {
	int total;
	int page;
	int records;
	List<?> rows;

	public JqGridResult(List<?> rows, int total, int page, int records) {
		this.rows = rows;
		this.total = total;
		this.page = page;
		this.records = records;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRecords() {
		return records;
	}

	public void setRecords(int records) {
		this.records = records;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}
}
