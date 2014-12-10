package com.mathapp;

import java.util.ArrayList;

import com.logsense.client.LogSense;
import com.mathapp.enums.FunctionModeEnum;
import com.mathapp.functions.Fatorial;
import com.mathapp.functions.interfaces.IFunction;

public class MathApp {

	private static final LogSense logger = new LogSense("http://localhost:3000/interactions", "MathSystem", "MathSolution", "mathapp");

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

		for (IFunction function : functions) {

			String output = String.format(("\tCalculating function %s in mode %s. \n\tResult: %s.\n"),
					function.getType(), function.getMode(), function.calculate(input.getValue()));

			System.out.println(output);
		}

		logger.toString();
	}
}
