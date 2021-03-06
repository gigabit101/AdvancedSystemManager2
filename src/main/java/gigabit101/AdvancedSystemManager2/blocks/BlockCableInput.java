package gigabit101.AdvancedSystemManager2.blocks;

import gigabit101.AdvancedSystemManager2.init.ModBlocks;
import gigabit101.AdvancedSystemManager2.lib.ModInfo;
import gigabit101.AdvancedSystemManager2.tiles.TileEntityCluster;
import gigabit101.AdvancedSystemManager2.tiles.TileEntityInput;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;


public class BlockCableInput extends BlockContainer
{
    public BlockCableInput()
    {
        super(Material.IRON);
        setCreativeTab(ModBlocks.creativeTab);
        setSoundType(SoundType.METAL);
        setUnlocalizedName(ModInfo.UNLOCALIZED_START + ModBlocks.CABLE_INPUT_UNLOCALIZED_NAME);
        setHardness(1.2F);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta)
    {
        return new TileEntityInput();
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.MODEL;
    }

    @Override
    public boolean canConnectRedstone(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing side)
    {
        return true;
    }

    @Override
    public void onBlockAdded(World world, BlockPos pos, IBlockState state)
    {
        super.onBlockAdded(world, pos, state);

        updateRedstone(world, pos);
    }

//    @Override
//    public void onNeighborBlockChange(World world, BlockPos pos, IBlockState state, Block block) {
//        super.onNeighborBlockChange(world, pos, state, block);
//
//        updateRedstone(world, pos);
//    }

    private void updateRedstone(World world, BlockPos pos)
    {
        TileEntityInput input = TileEntityCluster.getTileEntity(TileEntityInput.class, world, pos);
        if (input != null)
        {
            input.triggerRedstone();
        }
    }
}
