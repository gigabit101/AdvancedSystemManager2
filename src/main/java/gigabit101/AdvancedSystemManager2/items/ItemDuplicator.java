package gigabit101.AdvancedSystemManager2.items;

import gigabit101.AdvancedSystemManager2.init.ModBlocks;
import gigabit101.AdvancedSystemManager2.lib.ModInfo;
import gigabit101.AdvancedSystemManager2.tiles.TileEntityManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by Gigabit101 on 31/08/2016.
 */
public class ItemDuplicator extends Item
{
    public ItemDuplicator()
    {
        setUnlocalizedName(ModInfo.UNLOCALIZED_START + "duplicator");
        setMaxStackSize(1);
        setCreativeTab(ModBlocks.creativeTab);
    }
}
