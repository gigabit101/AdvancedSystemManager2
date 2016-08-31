package gigabit101.AdvancedSystemManager2.blocks;


import gigabit101.AdvancedSystemManager2.tiles.TileEntityClusterElement;
import gigabit101.AdvancedSystemManager2.tiles.TileEntityIntake;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

//This is indeed not a subclass to the cable, you can't relay signals through this block
public class BlockCableIntake extends BlockCableDirectionAdvanced
{

    @Override
    public TileEntity createNewTileEntity(World world, int meta)
    {
        return new TileEntityIntake();
    }

    @Override
    protected Class<? extends TileEntityClusterElement> getTeClass()
    {
        return TileEntityIntake.class;
    }

}
