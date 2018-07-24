package demos.test.state;

import com.gaoshuhang.sm.annotation.State;
import com.gaoshuhang.sm.model.AbstractState;

@State(stateName = "state-b")
public class StateB extends AbstractState<String>
{
	@Override
	public String handle(String message)
	{
		System.out.println("B->C");
		return "state-c";
	}
}
