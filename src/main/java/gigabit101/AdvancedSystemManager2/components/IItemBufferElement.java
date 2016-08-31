package gigabit101.AdvancedSystemManager2.components;

public interface IItemBufferElement {
    void prepareSubElements();
    IItemBufferSubElement getSubElement();
    void removeSubElement();
    int retrieveItemCount(int moveCount);
    void decreaseStackSize(int moveCount);
    void releaseSubElements();
}
