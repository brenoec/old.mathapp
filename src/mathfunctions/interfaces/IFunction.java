package mathfunctions.interfaces;

import mathapp.enums.FunctionModeEnum;
import mathapp.enums.FunctionTypeEnum;
import mathapp.exceptions.InvalidFunctionModeException;

public interface IFunction {
	public int calculate(int value) throws InvalidFunctionModeException;
	
	public FunctionTypeEnum getType();
	
	public FunctionModeEnum getMode();
}
