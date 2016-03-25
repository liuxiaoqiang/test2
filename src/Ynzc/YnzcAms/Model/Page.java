package Ynzc.YnzcAms.Model;

/**
 * 
 * @author Rabbit
 * 
 */
public class Page {

	public static final int DEFAULT_PAGE_SIZE = 10;

	private int pageIndex;
	private int pageSize;
	private int totalCount;
	private int pageCount;
	private int firstResult;

	public Page(int firstResult, int pageSize) {
		// check:
		this.firstResult = firstResult;
		this.pageSize = pageSize;
	}

	public Page(int firstResult) {
		this(firstResult, DEFAULT_PAGE_SIZE);
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getPageCount() {
		return pageCount;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public int getFirstResult() {
		return this.firstResult;
	}

	public boolean getHasPrevious() {
		return pageIndex > 1;
	}

	public boolean getHasNext() {
		return pageIndex < pageCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		pageCount = totalCount / pageSize
				+ (totalCount % pageSize == 0 ? 0 : 1);
	}

	public boolean isEmpty() {
		return totalCount == 0;
	}

}
