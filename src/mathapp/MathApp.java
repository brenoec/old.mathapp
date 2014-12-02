package mathapp;

import java.util.ArrayList;
import java.util.HashMap;

import com.logsense.client.LogSense;
import com.logsense.client.entities.InteractionEntity;
import com.logsense.client.entities.locations.OuterLocationEntity;

import mathapp.enums.FunctionModeEnum;
import mathfunctions.Fatorial;
import mathfunctions.interfaces.IFunction;

public class MathApp {

	public static long globalIdentifier = 0;
	public static ArrayList<InteractionEntity> interactions = new ArrayList<InteractionEntity>();
	
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
		
		LogSense logger = new LogSense("http://localhost:3000/interactions");
		
		InteractionEntity interaction = new InteractionEntity();
		interaction.setDescription("si description");
		interaction.setName("si name");
		interaction.setStatus("si just fine");
		
		interactions.add(interaction);
		
		OuterLocationEntity location = new OuterLocationEntity();
		
		location.setDescription("description");
		location.setName("name");
		location.setSolution("solution");
		location.setSystem("system");
		
		logger.log(interaction);
	}
}
