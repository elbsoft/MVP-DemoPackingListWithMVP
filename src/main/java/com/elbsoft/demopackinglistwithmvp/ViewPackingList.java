package com.elbsoft.demopackinglistwithmvp;

public interface ViewPackingList {
    
    public void addListener(ViewPackingListListener viewPackingListListener);
    public void afterItemSavedSuccessfully(String itemName);
    
    public interface ViewPackingListListener{
        public void buttonClick(String itemName);
    }
}
