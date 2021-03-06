package gigabit101.AdvancedSystemManager2.blocks;

import gigabit101.AdvancedSystemManager2.init.ModBlocks;
import gigabit101.AdvancedSystemManager2.lib.ModInfo;
import gigabit101.AdvancedSystemManager2.tiles.TileEntityBUD;
import gigabit101.AdvancedSystemManager2.tiles.TileEntityCluster;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCableBUD extends BlockContainer
{
    public BlockCableBUD()
    {
        super(Material.IRON);
        setCreativeTab(ModBlocks.creativeTab);
        setSoundType(SoundType.METAL);
        setUnlocalizedName(ModInfo.UNLOCALIZED_START + ModBlocks.CABLE_BUD_UNLOCALIZED_NAME);
        setHardness(1.2F);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta)
    {
        return new TileEntityBUD();
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.MODEL;
    }

    @Override
    public void onNeighborChange(IBlockAccess world, BlockPos pos, BlockPos neighbor)
    {
        TileEntityBUD bud = TileEntityCluster.getTileEntity(TileEntityBUD.class, world, pos);
        if (bud != null)
        {
            bud.onTrigger();
        }
    }
}
