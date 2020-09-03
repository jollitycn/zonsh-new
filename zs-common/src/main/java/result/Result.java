package result;


public class Result {
	private String code;
	private String msg;
	private Object data;

	public Result(final String code, final String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}

	public Result(final String code, final String msg, final Object data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public String getCode() {
		return code;
	}

	public void setCode(final String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(final String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(final Object data) {
		this.data = data;
	}

}
