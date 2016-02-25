package com.elbsoft.demopackinglistwithmvp;

import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import java.util.ArrayList;

public class ViewPackingListImpl extends CustomComponent implements 
        ViewPackingList, Button.ClickListener {

    private VerticalLayout mainLayout = new VerticalLayout();
    private HorizontalLayout insertLayout = new HorizontalLayout();

    private Label labelHeader = new Label("<H1>Packliste</H1>",
            ContentMode.HTML);

    private TextField fieldItemName = new TextField();
    private Button buttonAddItem = new Button("+");
    private Grid gridItemList = new Grid();

    private ArrayList<ViewPackingListListener> listener = new ArrayList<>();

    public ViewPackingListImpl(){
        fieldItemName.setInputPrompt("Das muss mit...");
        gridItemList.addColumn("", String.class);

        insertLayout.addComponent(fieldItemName);
        insertLayout.addComponent(buttonAddItem);

        mainLayout.addComponent(labelHeader);
        mainLayout.addComponent(insertLayout);
        mainLayout.addComponent(gridItemList);

        buttonAddItem.addClickListener(this);
        
        this.setCompositionRoot(mainLayout);
    }

    @Override
    public void addListener(ViewPackingListListener viewPackingListListener) {
        this.listener.add(viewPackingListListener);
    }

    @Override
    public void buttonClick(Button.ClickEvent event) {
        for (ViewPackingListListener viewPackingListListener : listener) {
            viewPackingListListener.buttonClick(fieldItemName.getValue());
        }
    }

    @Override
    public void afterItemSavedSuccessfully(String itemName) {
        gridItemList.addRow(itemName);
        fieldItemName.clear();
    }
}
