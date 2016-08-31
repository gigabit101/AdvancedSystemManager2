package gigabit101.AdvancedSystemManager2.items;

import gigabit101.AdvancedSystemManager2.AdvancedSystemManager2;
import gigabit101.AdvancedSystemManager2.init.ModBlocks;
import gigabit101.AdvancedSystemManager2.lib.ModInfo;
import gigabit101.AdvancedSystemManager2.tiles.TileEntityManager;
import gigabit101.AdvancedSystemManager2.util.ItemNBTHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.network.internal.FMLNetworkHandler;

import java.util.List;

/**
 * Created by Gigabit101 on 31/08/2016.
 */
public class ItemRemoteAccessor extends Item
{
    public ItemRemoteAccessor()
    {
        setCreativeTab(ModBlocks.creativeTab);
        setUnlocalizedName(ModInfo.UNLOCALIZED_START + "remoteaccessor");
        setMaxStackSize(1);
    }

    public void writePosToNbt(ItemStack stack, BlockPos pos)
    {
        ItemNBTHelper.setInt(stack, "X", pos.getX());
        ItemNBTHelper.setInt(stack, "Y", pos.getY());
        ItemNBTHelper.setInt(stack, "Z", pos.getZ());
    }

    public BlockPos readPosFromNbt(ItemStack stack)
    {
        if(ItemNBTHelper.verifyExistance(stack, "X") && ItemNBTHelper.verifyExistance(stack, "Y") && ItemNBTHelper.verifyExistance(stack, "Y"))
        {
            BlockPos pos = new BlockPos( ItemNBTHelper.getInt(stack, "X", 0), ItemNBTHelper.getInt(stack, "Y", 0), ItemNBTHelper.getInt(stack, "Z", 0));
            return pos;
        }
        return null;
    }

    @Override
    public EnumActionResult onItemUseFirst(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ, EnumHand hand)
    {
        if(player.isSneaking() && world.getTileEntity(pos) instanceof TileEntityManager)
        {
            if(readPosFromNbt(stack) == null)
            {
                writePosToNbt(stack, pos);
            }
        }
        return super.onItemUseFirst(stack, player, world, pos, side, hitX, hitY, hitZ, hand);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World world, EntityPlayer player, EnumHand hand)
    {
        if (!world.isRemote && !player.isSneaking() && stack.hasTagCompound())
        {
            if (readPosFromNbt(stack) != null)
            {
                BlockPos managerPos = readPosFromNbt(stack);
                if(world.isAreaLoaded(managerPos, 10))
                {
                    FMLNetworkHandler.openGui(player, AdvancedSystemManager2.instance, 1, world, managerPos.getX(), managerPos.getY(), managerPos.getZ());
                }
                else
                {
                    player.addChatComponentMessage(new TextComponentString("Chunk is not loaded"));
                }
            }
        }
        return super.onItemRightClick(stack, world, player, hand);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced)
    {
        if(readPosFromNbt(stack) != null)
        {
            BlockPos pos = readPosFromNbt(stack);
            tooltip.add("X " + pos.getX());
            tooltip.add("Y " + pos.getY());
            tooltip.add("Z " + pos.getZ());
        }
        else
        {
            tooltip.add("Right Click on manager to link device");
        }
        super.addInformation(stack, playerIn, tooltip, advanced);
    }
}
