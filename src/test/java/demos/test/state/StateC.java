package demos.test.state;

import com.gaoshuhang.sm.annotation.State;
import com.gaoshuhang.sm.model.AbstractState;

@State(stateName = "state-c")
public class StateC extends AbstractState<String>
{
	@Override
	public String handle(String message)
	{
		System.out.println("C->C");
		return "state-c";
	}
}
