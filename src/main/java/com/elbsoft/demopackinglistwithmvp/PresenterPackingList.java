package com.elbsoft.demopackinglistwithmvp;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

public class PresenterPackingList implements 
        ViewPackingList.ViewPackingListListener {

    @Inject
    private ModelItemService itemService;

    @Inject
    private ViewPackingList packingListView;
    
    @PostConstruct
    public void init(){
        packingListView.addListener(this);
    }
    
    public ViewPackingList getView(){
        return packingListView;
    }

    @Override
    public void buttonClick(String itemName) {
        if (itemService.saveItem(itemName)){
            packingListView.afterItemSavedSuccessfully(itemName);
        }
    }
}
