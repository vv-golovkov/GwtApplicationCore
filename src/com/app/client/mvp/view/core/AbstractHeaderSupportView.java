package com.app.client.mvp.view.core;

import java.util.ArrayList;
import java.util.List;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.HTMLFlow;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.VLayout;
import com.telcordia.granite.platform.ui.client.gui.AbstractContext;
import com.telcordia.granite.platform.ui.client.gui.ApplicationHeader;
import com.telcordia.granite.platform.ui.client.gui.GuiUtils;
import com.telcordia.granite.platform.ui.client.gui.Statusbar;

public abstract class AbstractHeaderSupportView extends AbstractViewProvider {
    private static final String LOGOTYPE = "logo/StcLogo_Trans.png";
    private ApplicationHeader applicationHeader;
    private VLayout mainViewport;
    private Statusbar statusbar;

    public AbstractHeaderSupportView(AbstractContext context, VLayout mainViewport) {
        super(context);
        this.mainViewport = mainViewport;
        this.statusbar = context.statusBar();
        this.applicationHeader = getApplicationHeader(context);
    }

    private ApplicationHeader getApplicationHeader(AbstractContext context) {
        String contents = getPageTitleDesign("--- GWT Application Stub ---");
        return new ApplicationHeader(context, new HTMLFlow(contents), new ClickHandler() {
            public void onClick(ClickEvent event) {
                String command = GuiUtils.getCommand(event);
                System.out.println(command);
                /*--- Strings.S_LOGOUT
                Strings.S_HELP_CONTENTS ---*/
            }
        });

    }

    private String getPageTitleDesign(String pageTitle) {
        String contents = "<table style='align:center;border:20;nowrap:nowrap;'><tr>" + "<td><img src='images/"
                + LOGOTYPE + "' width='94' height='41'/></td>" + "<td nowrap><font size='2'><b>" + pageTitle
                + "</b></font></td></tr></table>";
        return contents;
    }

    @Override
    protected void drawUI() {
        List<Canvas> members = new ArrayList<Canvas>();
        members.add(applicationHeader);
        drawUIWithMembers(members);
        members.add(statusbar);
        mainViewport.setMembers(members.toArray(new Canvas[members.size()]));
        members.clear();
        if (mainViewport.isDrawn()) {
            mainViewport.redraw();
        } else {
            mainViewport.draw();
        }
    }

    protected abstract void drawUIWithMembers(List<Canvas> members);
}
