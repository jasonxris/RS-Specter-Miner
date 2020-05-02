package unitTests;

import com.xman.bots.mining.stateMiner.RootNodeWrapper;
import com.xman.bots.mining.stateMiner.stateRootNodes.inRoute.branches.InRoute;
import com.xman.bots.mining.stateMiner.universalLeafStates.SetRoute;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SetRouteTest {

    private RootNodeWrapper wrap;

    @Before
    public void createRootNode(){
        wrap = RootNodeWrapper.getInstance();
    }

    @Test
    public void setRootNodeToRoute(){
        InRoute expectedClass = new InRoute("random");
        SetRoute bankRoute = new SetRoute("bank");
        assertNotEquals(expectedClass.getClass(),wrap.getCurrentState().getClass());
        bankRoute.execute();
        assertEquals(expectedClass.getClass(),wrap.getCurrentState().getClass());
    }

}
