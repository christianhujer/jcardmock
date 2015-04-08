package javacard.framework;

public interface MultiSelectable {
    void deselect(boolean appInstStillActive);
    boolean select(boolean appInstAlreadyActive);
}
