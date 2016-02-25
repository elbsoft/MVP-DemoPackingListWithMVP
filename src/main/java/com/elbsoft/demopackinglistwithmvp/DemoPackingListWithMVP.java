package com.elbsoft.demopackinglistwithmvp;

import com.vaadin.annotations.Theme;
import com.vaadin.cdi.CDIUI;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Component;
import com.vaadin.ui.UI;
import javax.inject.Inject;

@CDIUI
@Theme("valo")
public class DemoPackingListWithMVP extends UI{
    
    @Inject
    private PresenterPackingList presenterPackingList;

    @Override
    protected void init(VaadinRequest request) {
        setContent((Component)presenterPackingList.getView());
    }
}
