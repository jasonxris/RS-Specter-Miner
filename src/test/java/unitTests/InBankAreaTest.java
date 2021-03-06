package unitTests;

import com.runemate.game.api.hybrid.entities.Player;
import com.runemate.game.api.hybrid.location.Area;
import com.runemate.game.api.hybrid.region.Players;
import com.xman.bots.mining.stateMiner.data.DataCache;
import com.xman.bots.mining.stateMiner.stateRootNodes.inBankArea.branches.InBankArea;
import com.xman.bots.mining.stateMiner.stateRootNodes.inRoute.branches.IsArrivedAtDestination;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Players.class,DataCache.class})
public class InBankAreaTest {

    @Before
    public void setupPlayer(){

        PowerMockito.mockStatic(Players.class);
        PowerMockito.mockStatic(DataCache.class);

    }

    @Test
    public void playerIsNotInLocal(){
        Area mockArea = Mockito.mock(Area.class);
        DataCache mockCache = Mockito.mock(DataCache.class);

        PowerMockito.when(DataCache.getCache()).thenReturn(mockCache);
        Mockito.when(mockCache.getBankRegion()).thenReturn(mockArea);
        Mockito.when(mockArea.contains(Mockito.any(Player.class),Mockito.anyBoolean())).thenReturn(false);
        PowerMockito.when(Players.getLocal()).thenReturn(null);

        InBankArea inBankArea = new InBankArea();
        assertFalse(inBankArea.validate());
    }

    @Test
    public void areaDoesNotContainPlayer(){
        Area mockArea = Mockito.mock(Area.class);
        DataCache mockCache = Mockito.mock(DataCache.class);
        Player playerMock = Mockito.mock(Player.class);

        PowerMockito.when(DataCache.getCache()).thenReturn(mockCache);
        Mockito.when(mockCache.getBankRegion()).thenReturn(mockArea);
        Mockito.when(mockArea.contains(Mockito.any(Player.class),Mockito.anyBoolean())).thenReturn(false);
        PowerMockito.when(Players.getLocal()).thenReturn(playerMock);

        InBankArea inBankArea = new InBankArea();
        assertFalse(inBankArea.validate());
    }

    @Test
    public void playerHasArrived(){
        Area mockArea = Mockito.mock(Area.class);
        DataCache mockCache = Mockito.mock(DataCache.class);
        Player playerMock = Mockito.mock(Player.class);

        PowerMockito.when(DataCache.getCache()).thenReturn(mockCache);
        Mockito.when(mockCache.getBankRegion()).thenReturn(mockArea);
        Mockito.when(mockArea.contains(Mockito.any(Player.class),Mockito.anyBoolean())).thenReturn(true);
        PowerMockito.when(Players.getLocal()).thenReturn(playerMock);

        InBankArea inBankArea = new InBankArea();
        assertTrue(inBankArea.validate());
    }
}
