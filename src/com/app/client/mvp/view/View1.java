package com.app.client.mvp.view;

import java.util.List;

import com.app.client.mvp.presenter.Presenter1;
import com.app.client.mvp.view.core.AbstractHeaderSupportView;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.events.ClickHandler;
import com.smartgwt.client.widgets.layout.VLayout;
import com.telcordia.granite.platform.ui.client.gui.AbstractContext;
import com.telcordia.granite.platform.ui.client.gui.CommandButton;
import com.telcordia.granite.platform.ui.client.gui.GuiFactory;
import com.telcordia.granite.platform.ui.client.items.ButtonItem;

public class View1 extends AbstractHeaderSupportView<Presenter1> {
    private VLayout mainLayout;
    
    private CommandButton commandButton;
    private ButtonItem buttonItem;
    
    public View1(AbstractContext context, VLayout mainViewport) {
        super(context, mainViewport);
    }

    @Override
    protected Presenter1 definePresenter() {
        return new Presenter1(this);
    }
    
    @Override
    protected void buildUI(GuiFactory gui) {
        buttonItem = gui.createButtonItem("buttonitem_guid", "Button Item!");
        DynamicForm dynamicForm = new DynamicForm();
        dynamicForm.setFields(buttonItem);
        
        commandButton = gui.createCommandButton("commandButton_cmd", "Command Button!");
        
        mainLayout = gui.createVLayout("100%", "100%", 5);
        mainLayout.addMember(dynamicForm);
        mainLayout.addMember(commandButton);
    }
    
    @Override
    protected void drawUIWithMembers(List<Canvas> members) {
        members.add(mainLayout);
    }
    
    public void addButtonItemHandler(ClickHandler clickHandler) {
        buttonItem.addClickHandler(clickHandler);
    }
    
    public void addCommandButtonHandler(com.smartgwt.client.widgets.events.ClickHandler clickHandler) {
        commandButton.addClickHandler(clickHandler);
    }
}
