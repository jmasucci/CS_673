package CS673.CS673.flows;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.webflow.core.FlowException;
import org.springframework.webflow.execution.FlowExecutionOutcome;
import org.springframework.webflow.execution.repository.FlowExecutionRestorationFailureException;
import org.springframework.webflow.execution.repository.NoSuchFlowExecutionException;
import org.springframework.webflow.execution.repository.snapshot.SnapshotNotFoundException;
import org.springframework.webflow.mvc.servlet.AbstractFlowHandler;

public class RegistrationFlowHandler extends AbstractFlowHandler {

    private static final String DEFAULT_URL = "/";

    @Override
    public String getFlowId() {
    	return "register";
    }
    
	@Override
	public String handleExecutionOutcome(FlowExecutionOutcome outcome, HttpServletRequest req, HttpServletResponse res) {
		return DEFAULT_URL;
	}

	@Override
	public String handleException(FlowException e, HttpServletRequest request, HttpServletResponse response) {
		if (e instanceof FlowExecutionRestorationFailureException)
        {
            if (e.getCause() instanceof SnapshotNotFoundException)
            {
                return DEFAULT_URL;
            }
        }
		if (e instanceof NoSuchFlowExecutionException) {
			return DEFAULT_URL;
		}
		else {
			throw e;
		}
	}

}