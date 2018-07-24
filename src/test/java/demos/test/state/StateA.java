package demos.test.state;

import com.gaoshuhang.sm.annotation.State;
import com.gaoshuhang.sm.model.AbstractState;

@State(stateName = "state-a")
public class StateA extends AbstractState<String>
{
	@Override
	public String handle(String message)
	{
		if(message.equals("A"))
		{
			System.out.println("A->A");
			return "state-a";
		}
		else
		{
			System.out.println("A->B");
			return "state-b";
		}
	}
}
