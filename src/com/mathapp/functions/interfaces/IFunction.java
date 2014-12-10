package com.mathapp.functions.interfaces;

import com.mathapp.enums.FunctionModeEnum;
import com.mathapp.enums.FunctionTypeEnum;
import com.mathapp.exceptions.InvalidFunctionModeException;

public interface IFunction {
	public int calculate(int value) throws InvalidFunctionModeException;
	
	public FunctionTypeEnum getType();
	
	public FunctionModeEnum getMode();
}
