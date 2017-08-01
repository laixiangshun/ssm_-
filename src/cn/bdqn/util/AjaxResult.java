package cn.bdqn.util;

public class AjaxResult {
	private String errorMsg;
	private boolean success;
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public AjaxResult(String errorMsg, boolean success) {
		super();
		this.errorMsg = errorMsg;
		this.success = success;
	}
	public AjaxResult() {
		super();
	}
	public AjaxResult(String errorMsg) {
		super();
		this.errorMsg = errorMsg;
	}
	public AjaxResult(boolean success) {
		super();
		this.success = success;
	}
	@Override
	public String toString() {
		return "AjaxResult [errorMsg=" + errorMsg + ", success=" + success
				+ "]";
	}
}
