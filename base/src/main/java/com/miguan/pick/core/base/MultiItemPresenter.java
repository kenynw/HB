package com.miguan.pick.core.base;


public abstract class MultiItemPresenter<T> extends ItemPresenter<T> {

    @Override
    public final int getLayoutRes() {
        return 0;
    }

    public abstract int getLayoutRes(int itemType);

    public abstract int getItemType(T item);

    public abstract int[] getItemTypes();

}
