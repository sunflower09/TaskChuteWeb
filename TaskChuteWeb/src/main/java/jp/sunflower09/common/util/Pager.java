package jp.sunflower09.common.util;

public class Pager {
	// デフォルトでページは1
	private Integer page = 1;
	// デフォルトで表示件数は制限なし
	private Integer limit = null;
	// デフォルトでソートフィールドはなし
	private String sortField = null;
	// デフォルトでソートオーダーはasc
	private String sortOrder = "asc";

	// pageとlimitが決まったときにoffsetが決まる。

	private Integer offset = null;

	public Pager(int page, int limit) {
		this.page = page;
		this.limit = limit;
		this.offset = ((this.page - 1) * this.limit);
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
		if (limit != null) {
			this.offset = ((this.page - 1) * this.limit);
		}
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
		if (limit != null) {
			this.offset = ((this.page - 1) * this.limit);
		}
	}

	public String getSortField() {
		return sortField;
	}

	public void setSortField(String sortField) {
		this.sortField = sortField;
	}

	public String getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}

	public Integer getOffset() {
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}

}
