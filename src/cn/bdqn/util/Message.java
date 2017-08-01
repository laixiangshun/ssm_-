package cn.bdqn.util;

public enum Message {
	SUCCESS("操作成功!"),
	ERROR("操作失败!"),
	IS_EXIST("已存在!");
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	private Message(String message) {
		this.message = message;
	}
	
}
