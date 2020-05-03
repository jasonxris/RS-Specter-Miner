package integrationTests;

import com.runemate.game.api.hybrid.local.hud.interfaces.Equipment;
import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.hybrid.region.GameObjects;
import com.runemate.game.api.script.framework.tree.TreeTask;
import com.xman.bots.mining.stateMiner.RootNodeWrapper;
import com.xman.bots.mining.stateMiner.data.DataCache;
import com.xman.bots.mining.stateMiner.stateRootNodes.inRoute.branches.InRoute;
import com.xman.bots.mining.stateMiner.stateRootNodes.isMinerReady.branches.IsMinerReady;
import com.xman.bots.mining.stateMiner.universalLeafStates.SetRoute;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Equipment.class, Inventory.class})
public class IsMinerReadyIGRTest {

    RootNodeWrapper wrapper;
    IsMinerReady isMinerReadyClass = new IsMinerReady();
    SetRoute setRoute = new SetRoute("bank");
    InRoute inRoute = new InRoute("bank");

    @Before
    public void setup(){
        PowerMockito.mockStatic(Equipment.class);
        PowerMockito.mockStatic(Inventory.class);
        wrapper = RootNodeWrapper.getInstance();
    }

    @Test
    public void miner_Ready_Mine(){
        IsMinerReady isMinerReady = new IsMinerReady();

        PowerMockito.when(Equipment.containsAnyOf(DataCache.getCache().getPICKAXES())).thenReturn(true);
        PowerMockito.when(Inventory.containsAnyOf(DataCache.getCache().getPICKAXES())).thenReturn(true);
        PowerMockito.when(Inventory.isFull()).thenReturn(false);

        // Run is miner validation method, validate that it returned true
        boolean isMinerValidation = isMinerReady.validate();
        assertTrue(isMinerValidation);

        // Run the isMinerSuccessTask, Validate that the task is the SetRoute
        TreeTask task = isMinerReady.successTask();
        assertEquals(task.getClass(),setRoute.getClass());

        //Run the tasks execution
        // validate that the wrapper state changed
        task.execute();
        assertEquals(wrapper.getCurrentState().getClass(),inRoute.getClass());

    }


    @Test
    public void miner_HalfInv_Pick(){
        IsMinerReady isMinerReady = new IsMinerReady();
        PowerMockito.when(Equipment.containsAnyOf(DataCache.getCache().getPICKAXES())).thenReturn(true);
        PowerMockito.when(Inventory.containsAnyOf(DataCache.getCache().getPICKAXES())).thenReturn(true);
        PowerMockito.when(Inventory.isFull()).thenReturn(false);

        // Run is miner validation method, validate that it returned true
        boolean isMinerValidation = isMinerReady.validate();
        assertTrue(isMinerValidation);

        // Run the isMinerSuccessTask, Validate that the task is the SetRoute
        TreeTask task = isMinerReady.successTask();
        assertEquals(task.getClass(),setRoute.getClass());

        //Run the tasks execution
        // validate that the wrapper state changed
        task.execute();
        assertEquals(wrapper.getCurrentState().getClass(),inRoute.getClass());

    }

    @Test
    public void miner_FullInv_Pick(){
        IsMinerReady isMinerReady = new IsMinerReady();
        PowerMockito.when(Equipment.containsAnyOf(DataCache.getCache().getPICKAXES())).thenReturn(true);
        PowerMockito.when(Inventory.containsAnyOf(DataCache.getCache().getPICKAXES())).thenReturn(true);
        PowerMockito.when(Inventory.isFull()).thenReturn(true);

        // Run is miner validation method, validate that it returned true
        boolean isMinerValidation = isMinerReady.validate();
        assertFalse(isMinerValidation);

        // Run the isMinerSuccessTask, Validate that the task is the SetRoute
        TreeTask task = isMinerReady.failureTask();
        assertEquals(task.getClass(),setRoute.getClass());

        //Run the tasks execution
        // validate that the wrapper state changed
        task.execute();
        assertEquals(wrapper.getCurrentState().getClass(),inRoute.getClass());


    }

    @Test
    public void miner_EmptyInv_NoPick(){
        IsMinerReady isMinerReady = new IsMinerReady();
        PowerMockito.when(Equipment.containsAnyOf(DataCache.getCache().getPICKAXES())).thenReturn(false);
        PowerMockito.when(Inventory.containsAnyOf(DataCache.getCache().getPICKAXES())).thenReturn(false);
        PowerMockito.when(Inventory.isFull()).thenReturn(false);

        // Run is miner validation method, validate that it returned true
        boolean isMinerValidation = isMinerReady.validate();
        assertFalse(isMinerValidation);

        // Run the isMinerSuccessTask, Validate that the task is the SetRoute
        TreeTask task = isMinerReady.successTask();
        assertEquals(task.getClass(),setRoute.getClass());

        //Run the tasks execution
        // validate that the wrapper state changed
        task.execute();
        assertEquals(wrapper.getCurrentState().getClass(),inRoute.getClass());

    }


}
