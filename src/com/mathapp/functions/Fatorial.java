package com.mathapp.functions;

import com.mathapp.enums.FunctionModeEnum;
import com.mathapp.enums.FunctionTypeEnum;
import com.mathapp.exceptions.InvalidFunctionModeException;
import com.mathapp.functions.interfaces.IFunction;

public class Fatorial implements IFunction {

	private FunctionModeEnum mode;
	private final FunctionTypeEnum type = FunctionTypeEnum.FAT;
	
	public Fatorial(FunctionModeEnum mode) {
		this.mode = mode;
	}

	public int calculate(int x) throws InvalidFunctionModeException {

		switch (mode) {
		case ITERATIVE:
			return iterative(x);

		case RECURSIVE:
			return recursive(x);

		default:
			throw new InvalidFunctionModeException(
					"FunctionModeEnum mode must be FunctionModeEnum.ITERATIVE or FunctionModeEnum.RECURSIVE for fatorial function.");
		}
	}

	private int recursive(int x) {
		if (x > 0) {
			return x * recursive(x - 1);
		} else if (x == 0 || x == 1) {
			return 1;
		}

		return 0;
	}

	private int iterative(int x) {
		if (x >= 0) {
			int result = 1;

			for (int i = 2; i <= x; i++) {
				result *= i;
			}

			return result;
		}

		return 0;
	}
	
	public FunctionTypeEnum getType() {
		return type;
	}

	public FunctionModeEnum getMode() {
		return mode;
	}

	public void setMode(FunctionModeEnum mode) {
		this.mode = mode;
	}
}
