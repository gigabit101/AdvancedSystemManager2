package gigabit101.AdvancedSystemManager2;

import gigabit101.AdvancedSystemManager2.tiles.ITileEntityInterface;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{
    public GuiHandler() {}

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        TileEntity te = world.getTileEntity(new BlockPos(x, y, z));
        if (te != null && te instanceof ITileEntityInterface)
        {
            return ((ITileEntityInterface) te).getContainer(te, player.inventory);
        } else
        {
            return null;
        }
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        TileEntity te = world.getTileEntity(new BlockPos(x, y, z));
        if (te != null && te instanceof ITileEntityInterface)
        {
            return ((ITileEntityInterface) te).getGui(te, player.inventory);
        } else
        {
            return null;
        }
    }
}
