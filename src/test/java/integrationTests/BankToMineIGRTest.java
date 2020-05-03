package integrationTests;


import com.runemate.game.api.hybrid.region.GameObjects;
import com.runemate.game.api.script.framework.tree.LeafTask;
import com.runemate.game.api.script.framework.tree.TreeTask;
import com.xman.bots.mining.stateMiner.stateRootNodes.inBankArea.branches.InBankArea;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest({GameObjects.class})
public class BankToMineIGRTest {


    @Test
    public void inBankAndReadyToMineRock(){
        InBankArea inBankArea = new InBankArea();
        boolean validation = inBankArea.validate();

        assertTrue(validation);
       TreeTask nextTask = inBankArea.successTask();

    }

    @Test
    public void inBankWithFullInvToMineRock(){

    }

    @Test
    public void inBankWithoutPickaxeEquipped_PickaxeInbank(){

    }

    @Test
    public void inBankWithNoPickaxe(){

    }

}
