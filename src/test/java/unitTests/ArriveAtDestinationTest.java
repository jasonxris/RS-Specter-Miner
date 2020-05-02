package unitTests;


import com.runemate.game.api.hybrid.entities.Player;
import com.runemate.game.api.hybrid.location.Area;
import com.xman.bots.mining.stateMiner.data.DataCache;
import com.xman.bots.mining.stateMiner.stateRootNodes.inRoute.branches.ArriveAtDestination;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Player.class})
public class ArriveAtDestinationTest {

    DataCache cache = DataCache.getCache();
    @Test
    public void playerISNotInLocal(){
        Area mockArea = Mockito.mock(Area.class);
        Mockito.when(mockArea.contains(Mockito.any(Player.class))).thenReturn(true);

        ArriveAtDestination arriveAtDestination = new ArriveAtDestination("bank",mockArea);
    }

    @Test
    public void areaDoesNotContainPlayer(){

    }

    @Test
    public void playerHasArrived(){

    }
}
