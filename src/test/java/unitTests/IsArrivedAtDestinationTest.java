package unitTests;


import com.runemate.game.api.hybrid.entities.Player;
import com.runemate.game.api.hybrid.location.Area;
import com.runemate.game.api.hybrid.region.Players;
import com.xman.bots.mining.stateMiner.data.DataCache;
import com.xman.bots.mining.stateMiner.stateRootNodes.inRoute.branches.IsArrivedAtDestination;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Players.class})
public class IsArrivedAtDestinationTest {

    DataCache cache = DataCache.getCache();

    @Before
    public void setupPlayer(){

        PowerMockito.mockStatic(Players.class);

    }

    @Test
    public void playerIsNotInLocal(){
        Area mockArea = Mockito.mock(Area.class);

        Mockito.when(mockArea.contains(Mockito.any(Player.class),Mockito.anyBoolean())).thenReturn(false);
        PowerMockito.when(Players.getLocal()).thenReturn(null);

        IsArrivedAtDestination isArrivedAtDestination = new IsArrivedAtDestination("bank",mockArea);
        assertFalse(isArrivedAtDestination.validate());
    }

    @Test
    public void areaDoesNotContainPlayer(){
        Area mockArea = Mockito.mock(Area.class);
        Player playerMock = Mockito.mock(Player.class);

        Mockito.when(mockArea.contains(Mockito.any(Player.class),Mockito.anyBoolean())).thenReturn(false);
        PowerMockito.when(Players.getLocal()).thenReturn(playerMock);

        IsArrivedAtDestination isArrivedAtDestination = new IsArrivedAtDestination("bank",mockArea);
        assertFalse(isArrivedAtDestination.validate());
    }

    @Test
    public void playerHasArrived(){
        Area mockArea = Mockito.mock(Area.class);
        Player playerMock = Mockito.mock(Player.class);

        Mockito.when(mockArea.contains(Mockito.any(Player.class),Mockito.anyBoolean())).thenReturn(true);
        PowerMockito.when(Players.getLocal()).thenReturn(playerMock);

        IsArrivedAtDestination isArrivedAtDestination = new IsArrivedAtDestination("bank",mockArea);
        assertTrue(isArrivedAtDestination.validate());
    }
}
