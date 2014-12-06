package mathapp;

import java.util.ArrayList;

import mathapp.enums.FunctionModeEnum;
import mathfunctions.Fatorial;
import mathfunctions.interfaces.IFunction;

public class MathApp {

	public static void main(String[] args) throws Exception {
		Input input = new Input(args);

		ArrayList<IFunction> functions = new ArrayList<IFunction>();

		switch (input.getFunction()) {
		case FAT:
			functions.add(new Fatorial(FunctionModeEnum.ITERATIVE));
			functions.add(new Fatorial(FunctionModeEnum.RECURSIVE));
			break;

		default:
			break;
		}

		System.out.println(String.format("\nInput: %s(%s)\n", input.getFunction(), input.getValue()));

		for (IFunction function: functions) {
			System.out.println(String.format(("\tCalculating function %s in mode %s. \n\tResult: %s.\n"),
					function.getType(),
					function.getMode(),
					function.calculate(input.getValue())));
		}
	}
}
