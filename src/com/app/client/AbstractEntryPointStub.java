package com.app.client;

import java.util.HashMap;

import com.smartgwt.client.widgets.events.ClickEvent;
import com.telcordia.granite.platform.ui.client.gui.AbstractStackedEntryPoint;
import com.telcordia.granite.platform.ui.client.gui.ApplicationHeader;
import com.telcordia.granite.platform.ui.client.gui.MainVPanel;
import com.telcordia.granite.platform.ui.client.gui.ToolbarMenuImgButton;
import com.telcordia.granite.platform.ui.client.gui.events.TaskArguments;

public abstract class AbstractEntryPointStub extends AbstractStackedEntryPoint {

    public void onClick(ClickEvent event) {
    }

    @Override
    protected MainVPanel buildMainVPanel(String name, TaskArguments args) {
        return null;
    }

    @Override
    protected ToolbarMenuImgButton buildSelectorButton() {
        return null;
    }

    @Override
    protected void doBuildMainVPanel(String name) {
    }

    @Override
    protected HashMap<String, String> parseInputArguments() {
        HashMap<String, String> arguments = new HashMap<String, String>();
        /* put arguments if needed */
        return arguments;
    }

    @Override
    protected void saveHistory(boolean saveHistory) {
    }

    @Override
    protected ApplicationHeader buildHeader(HashMap<String, Object> args) {
        return null;
    }
}
