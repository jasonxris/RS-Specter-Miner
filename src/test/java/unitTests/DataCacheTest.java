package unitTests;

import com.runemate.game.api.hybrid.location.Coordinate;
import com.xman.bots.mining.stateMiner.data.DataCache;
import org.junit.Test;
import org.powermock.modules.junit4.PowerMockRunner;
import static org.junit.Assert.*;

public class DataCacheTest {

    DataCache cache = DataCache.getCache();

    @Test
    public void initialValuesLoaded(){
        assertNotNull(cache.getMineRegion());
        assertNotNull(cache.getBankRegion());

        assertNotNull(cache.getSelectedPickaxe());
        assertNotNull(cache.getBankBoothCoord());
        assertNotNull(cache.getWANTED_ITEMS());
        assertNotNull(cache.getBotWeb());
        assertNotNull(cache.getPICKAXES());
    }

    @Test
    public void chooseRandomBank(){
        Coordinate coord1 = cache.getBankBoothCoord();
        Coordinate coord2 = cache.getBankBoothCoord();
        Coordinate coord3 = cache.getBankBoothCoord();
        Coordinate coord4 = cache.getBankBoothCoord();
        if(coord1.equals(coord2)){
            if(coord1.equals(coord3)){
                if(coord1.equals(coord4)){
                    assert false;
                }
            }
        }
        assert true;
    }

    @Test
    public void assertMineAreasAreBigEnough(){
       int height =  cache.getMineRegion().getArea().getHeight();
       int width =  cache.getMineRegion().getArea().getWidth();
       int area = height * width;
       if(area < 0){
           assert false;
       }
       else{
           assert true;
       }

    }

    @Test
    public void assertBankAreasAreBigEnough(){
        int height =  cache.getBankRegion().getArea().getHeight();
        int width =  cache.getBankRegion().getArea().getWidth();
        int area = height * width;
        if(area >0){
            assert true;
        }else{
            assert false;
        }
    }

    @Test
    public void loadsConfigurationFile(){
        assert false;

    }

    @Test
    public void priorityOreChosen(){
        assert false;
    }

    @Test
    public void bestPickaxeChosen(){
        assert false;
    }

}
