package result;

import java.util.List;
import java.util.Map;

public class ResultFactory {

	private ResultFactory() {
	}

	private static Result successResult = new Result(
			ResultConstans.SUCCESS_CODE, ResultConstans.SUCCESS_MSG);

	public static Result generateSuccessResult() {
		return successResult;
	}

	public static Result generateResult(final String code, final String msg) {
		return new Result(code, msg);
	}

	public static Result generateResult(final String code, final String msg,
			final List<?> data) {
		return new Result(code, msg, data);
	}

	public static Result generateResult(final String code, final String msg, final Object data) {
		return new Result(code, msg, data);
	}

	public static Result generateResult(final String code, final String msg,
			final Map<String, Object> data) {
		return new Result(code, msg, data);
	}
	public static Result generateResultWithDate(final String code, final String msg,
			final Map<String, Object> data) {
		return new Result(code, msg, data);
	}
}

