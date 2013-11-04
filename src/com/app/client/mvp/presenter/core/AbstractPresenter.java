package com.app.client.mvp.presenter.core;

import com.app.client.engine.eventbus.EventBusController;
import com.app.client.engine.util.AsyncRpcFactory;
import com.app.client.engine.util.UserMessages;
import com.app.client.mvp.view.core.AbstractViewProvider;
import com.app.shared.transport.common.DefServiceResponse;
import com.google.gwt.user.client.rpc.AsyncCallback;

public abstract class AbstractPresenter<T extends AbstractViewProvider> {
    protected static final EventBusController eventBus = new EventBusController();
    private final UserMessages userMessages;

    // create RPC factory if there are many asynchronous-services.
    protected AsyncRpcFactory rpcFactory;
    protected final T view;

    public AbstractPresenter(T view, UserMessages userMessages) {
        this.view = view;
        this.userMessages = userMessages;
    }

    public final void loadView() {
        view.load();
        createRpcFactory();
        createEventHandlers();
    }

    private void createRpcFactory() {
        rpcFactory = new AsyncRpcFactory();
    }

    /****************************************** ABSTRACT ******************************************/
    protected abstract void createEventHandlers();

    /****************************************** COMMON ******************************************/
    protected abstract class CommonDefCallback implements AsyncCallback<DefServiceResponse> {
        @Override
        public void onFailure(Throwable exception) {
            String errorMessage = exception.getMessage();
            userMessages.showWarning(errorMessage);
        }
    }
}
