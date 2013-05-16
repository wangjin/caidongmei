package com.caidongmei.alumniassociation.util;

import java.util.List;

/**
 * �Զ����ҳ���
 * @author Acai
 */
public class PageModel {
	private int currPage;		//��ǰҳ
	private int totalRecords;	//�ܼ�¼��
	private List<?> list; 		//�����
	private int pageSize;		//ÿҳ��¼��
	public int getCurrPage() {
		return currPage;
	}
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	public int getTotalRecords() {
		return totalRecords;
	}
	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}
	public List<?> getList() {
		return list;
	}
	public void setList(List<?> list) {
		this.list = list;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	/**
	 * ��ȡ��ҳ��
	 * @return ��ҳ�� 
	 */
	public int getTotalPage(){
		return (totalRecords + pageSize- 1) / pageSize;
	}
	/**
	 * ��ȡ��һҳ
	 * @return ��һҳ
	 */
	public int getFirstPage(){
		return 1;
	}
	/**
	 * ��ȡ��һҳ
	 * @return ��һҳ
	 */
	public int getPreviousPage(){
		return currPage <= 1 ? 1 : currPage - 1;
	}
	/**
	 * ��ȡ��һҳ
	 * @return ��һҳ
	 */
	public int getNextPage(){
		if(currPage >= getTotalPage()){
			return getLastPage();
		}
		return currPage + 1;
	}
	/**
	 * ��ȡ���һҳ
	 * @return ���һҳ
	 */
	public int getLastPage(){
		//�����ҳ������0����1�����򷵻���ҳ��
		return getTotalPage() <= 0 ? 1 : getTotalPage();
	}
}
