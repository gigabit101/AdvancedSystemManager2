package gigabit101.AdvancedSystemManager2.interfaces;

import gigabit101.AdvancedSystemManager2.blocks.UserPermission;
import gigabit101.AdvancedSystemManager2.tiles.TileEntityRelay;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;

import java.util.List;

public class ContainerRelay extends ContainerBase
{
    private TileEntityRelay relay;

    public ContainerRelay(TileEntityRelay relay, InventoryPlayer player)
    {
        super(relay, player);
        this.relay = relay;
    }

    @Override
    public boolean canInteractWith(EntityPlayer entityplayer)
    {
        return entityplayer.getDistanceSq(relay.getPos().getX(), relay.getPos().getY(), relay.getPos().getZ()) <= 64;
    }

    @Override
    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();

        if (oldPermissions != null)
        {
            relay.updateData(this);
        }
    }

//    @Override
//    public void onCraftGuiOpened(ICrafting player) {
//        super.onCraftGuiOpened(player);
//        PacketHandler.sendAllData(this, player, relay);
//        oldPermissions = new ArrayList<UserPermission>();
//        for (UserPermission permission : relay.getPermissions()) {
//            oldPermissions.add(permission.copy());
//        }
//        oldCreativeMode = relay.isCreativeMode();
//        oldOpList = relay.doesListRequireOp();
//    }

    public List<UserPermission> oldPermissions;
    public boolean oldCreativeMode;
    public boolean oldOpList;

}
