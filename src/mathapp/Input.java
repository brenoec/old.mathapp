package mathapp;

import mathapp.enums.FunctionTypeEnum;

public class Input {

	private FunctionTypeEnum function;
	private int value;

	public Input(String[] args) throws Exception {
		if (args.length != 2) {
			throw new Exception("Invalid input. Try 'fat 5', for example.");
		}

		setFunction(args[0]);
		this.value = Integer.parseInt(args[1]);

		// System.out.print(String.format("%s(%s) = ", function, value));
	}

	public FunctionTypeEnum getFunction() {
		return function;
	}

	public void setFunction(String function) {
		if (FunctionTypeEnum.FAT.toString().equalsIgnoreCase(function)) {
			this.function = FunctionTypeEnum.FAT;
		} else {
			this.function = null;
		}
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
