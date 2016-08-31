package gigabit101.AdvancedSystemManager2.blocks;


import gigabit101.AdvancedSystemManager2.tiles.TileEntityManager;

public interface ISystemListener
{

    void added(TileEntityManager owner);

    void removed(TileEntityManager owner);

}
