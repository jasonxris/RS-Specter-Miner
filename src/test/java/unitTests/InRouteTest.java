package unitTests;


import com.runemate.game.api.hybrid.entities.Player;
import com.runemate.game.api.hybrid.location.Area;
import com.runemate.game.api.hybrid.region.Players;
import com.xman.bots.mining.stateMiner.data.DataCache;
import com.xman.bots.mining.stateMiner.stateRootNodes.inRoute.branches.InRoute;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Players.class, DataCache.class})
public class InRouteTest {

    @Before
    public void setupPlayer(){

        PowerMockito.mockStatic(Players.class);
        PowerMockito.mockStatic(DataCache.class);

    }

    @Test
    public void validateFalse_InBankArea(){
        Area mockArea = Mockito.mock(Area.class);
        DataCache mockCache = Mockito.mock(DataCache.class);
        Player playerMock = Mockito.mock(Player.class);

        PowerMockito.when(DataCache.getCache()).thenReturn(mockCache);
        Mockito.when(mockCache.getBankRegion()).thenReturn(mockArea);
        Mockito.when(mockArea.contains(Mockito.any(Player.class),Mockito.anyBoolean())).thenReturn(true);
        PowerMockito.when(Players.getLocal()).thenReturn(playerMock);

        InRoute inRoute = new InRoute("bank");
        assertFalse(inRoute.validate());

    }
    @Test
    public void validateFalse_InMineArea(){
        Area mockArea = Mockito.mock(Area.class);
        DataCache mockCache = Mockito.mock(DataCache.class);
        Player playerMock = Mockito.mock(Player.class);

        PowerMockito.when(DataCache.getCache()).thenReturn(mockCache);
        Mockito.when(mockCache.getMineRegion()).thenReturn(mockArea);
        Mockito.when(mockArea.contains(Mockito.any(Player.class),Mockito.anyBoolean())).thenReturn(true);
        PowerMockito.when(Players.getLocal()).thenReturn(playerMock);

        InRoute inRoute = new InRoute("mine");
        assertFalse(inRoute.validate());

    }

    @Test
    public void validateTrueStillInRoute_NotInBankArea(){
        Area mockArea = Mockito.mock(Area.class);
        DataCache mockCache = Mockito.mock(DataCache.class);
        Player playerMock = Mockito.mock(Player.class);

        PowerMockito.when(DataCache.getCache()).thenReturn(mockCache);
        Mockito.when(mockCache.getBankRegion()).thenReturn(mockArea);
        Mockito.when(mockArea.contains(Mockito.any(Player.class),Mockito.anyBoolean())).thenReturn(false);
        PowerMockito.when(Players.getLocal()).thenReturn(playerMock);

        InRoute inRoute = new InRoute("bank");
        assertTrue(inRoute.validate());

    }

    @Test
    public void validateTrue_NotInMineArea(){
        Area mockArea = Mockito.mock(Area.class);
        DataCache mockCache = Mockito.mock(DataCache.class);
        Player playerMock = Mockito.mock(Player.class);

        PowerMockito.when(DataCache.getCache()).thenReturn(mockCache);
        Mockito.when(mockCache.getMineRegion()).thenReturn(mockArea);
        Mockito.when(mockArea.contains(Mockito.any(Player.class),Mockito.anyBoolean())).thenReturn(false);
        PowerMockito.when(Players.getLocal()).thenReturn(playerMock);

        InRoute inRoute = new InRoute("mine");
        assertTrue(inRoute.validate());

    }

    @Test
    public void validateFalseBotIsStuck(){

    }
}
