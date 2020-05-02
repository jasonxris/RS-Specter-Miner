package unitTests;

import com.xman.bots.mining.stateMiner.RootNodeWrapper;
import com.xman.bots.mining.stateMiner.stateRootNodes.inBankArea.branches.InBankArea;
import com.xman.bots.mining.stateMiner.stateRootNodes.inMineArea.branches.InMineArea;
import com.xman.bots.mining.stateMiner.stateRootNodes.inRoute.leaves.SetStateToArea;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class SetStateToAreaTest {


    @Test
    public void setStateToBankArea(){
        RootNodeWrapper wrap = RootNodeWrapper.getInstance();
        InBankArea expectedClass = new InBankArea();

        SetStateToArea setStateToArea = new SetStateToArea("bank");

        assertNotEquals(expectedClass.getClass(),wrap.getCurrentState().getClass());
        setStateToArea.execute();
        assertEquals(expectedClass.getClass(),wrap.getCurrentState().getClass());
    }
    @Test
    public void setStateToMineArea(){
        RootNodeWrapper wrap = RootNodeWrapper.getInstance();
        InMineArea expectedClass = new InMineArea();

        SetStateToArea setStateToArea = new SetStateToArea("mine");
        assertNotEquals(expectedClass.getClass(),wrap.getCurrentState().getClass());
        setStateToArea.execute();
        assertEquals(expectedClass.getClass(),wrap.getCurrentState().getClass());
    }
}
