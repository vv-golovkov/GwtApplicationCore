package com.app.client;

import java.util.HashMap;

import com.app.client.engine.context.ApplicationTasks;
import com.app.client.engine.context.Context;
import com.app.client.engine.context.command.BuildGuiCommand;
import com.app.client.engine.util.StatusbarManager;
import com.app.client.mvp.presenter.Presenter1;
import com.app.client.mvp.presenter.core.AbstractPresenter;
import com.app.client.mvp.view.View1;
import com.telcordia.granite.platform.ui.client.gui.AbstractContext;
import com.telcordia.granite.platform.ui.client.gui.events.TaskArguments;
import com.telcordia.granite.platform.ui.client.utils.CmdChainWithWait;

public class ApplicationEntryPoint extends AbstractEntryPointStub {

    @Override
    protected AbstractContext buildContext(HashMap<String, String> args) {
        return new Context(this);
    }

    @Override
    protected CmdChainWithWait createStartupChain(HashMap<String, String> args) {
        CmdChainWithWait chain = new CmdChainWithWait();
        chain.addCommand(new BuildGuiCommand((Context) context));
        return chain;
    }

    @Override
    protected boolean doTaskRequest(int task, TaskArguments args) {
        if (task == ApplicationTasks.BUILD_GUI) {
            return buildGui(null);
        }
        return false;
    }

    @Override
    protected boolean buildGui(HashMap<String, Object> args) {
        mainViewport = context.gui().createVLayout("100%", "100%", 0);
        mainViewport.setMembersMargin(5);

        // useHistoryFeature();

        AbstractPresenter<?> presenter = getPresenter1();
        presenter.loadView();

        return true;
    }
    
    private AbstractPresenter<?> getPresenter1() {
        View1 view = new View1(context, mainViewport);
        StatusbarManager statusbarManager = new StatusbarManager(context.statusBar());
        return new Presenter1(view, statusbarManager);
    }

    /*
     * private void useHistoryFeature() { HistoryManager history = new
     * HistoryManager(this); history.apply(); }
     */
}
