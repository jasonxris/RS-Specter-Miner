package unitTests;

import com.xman.bots.mining.stateMiner.RootNodeWrapper;
import com.xman.bots.mining.stateMiner.stateRootNodes.inRoute.branches.InRoute;
import com.xman.bots.mining.stateMiner.stateRootNodes.isMinerReady.branches.IsMinerReady;
import com.xman.bots.mining.stateMiner.universalLeafStates.SetRoute;
import com.xman.bots.mining.stateMiner.universalLeafStates.SetStateMinerReady;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class SetStateMinerReadyTest {

    private RootNodeWrapper wrap;

    @Before
    public void createRootNode(){
        wrap = RootNodeWrapper.getInstance();
        InRoute expectedClass = new InRoute("random");
        SetRoute bankRoute = new SetRoute("bank");
        assertNotEquals(expectedClass.getClass(),wrap.getCurrentState().getClass());
        bankRoute.execute();
        assertEquals(expectedClass.getClass(),wrap.getCurrentState().getClass());
    }

    @Test
    public void setRootNodeToRoute(){
        IsMinerReady expectedClass = new IsMinerReady();
        SetStateMinerReady setToIsMinerReady = new SetStateMinerReady();
        setToIsMinerReady.execute();
        assertEquals(expectedClass.getClass(),wrap.getCurrentState().getClass());
    }

}
