package com.app.client.mvp.presenter;

import java.util.List;

import com.app.client.engine.util.UserMessages;
import com.app.client.mvp.presenter.core.AbstractPresenter;
import com.app.client.mvp.view.View1;
import com.app.shared.transport.ResourceDto;
import com.app.shared.transport.common.DefServiceResponse;
import com.smartgwt.client.widgets.form.fields.events.ClickEvent;
import com.smartgwt.client.widgets.form.fields.events.ClickHandler;

public class Presenter1 extends AbstractPresenter<View1> {

    public Presenter1(View1 view, UserMessages userMessages) {
        super(view, userMessages);
    }

    @Override
    protected void createEventHandlers() {
        view.addButtonItemHandler(new ButtonItemListener());
        view.addCommandButtonHandler(new CommandButtonListener());
    }

    /*********************************** HANDLERS ***********************************/
    class ButtonItemListener implements ClickHandler {
        public void onClick(ClickEvent event) {
            rpcFactory.getService1Async().getString("hello", new GetStringCallback());
            rpcFactory.getService1Async().getOneResource(new GetOneResourceCallback());
        }
    }

    class CommandButtonListener implements com.smartgwt.client.widgets.events.ClickHandler {
        public void onClick(com.smartgwt.client.widgets.events.ClickEvent event) {
            rpcFactory.getService1Async().getMultipleResources(new GetMultipleResourcesCallback());
            rpcFactory.getService1Async().submit("submit", new SubmitCallback());
        }
    }

    /*********************************** ASYNC ***********************************/
    class GetStringCallback extends CommonDefCallback {
        @Override
        public void onSuccess(DefServiceResponse defServiceResponse) {
            String stringResponse = defServiceResponse.getStringResponse();
            System.out.println(stringResponse);
        }
    }

    class GetOneResourceCallback extends CommonDefCallback {
        @Override
        public void onSuccess(DefServiceResponse defServiceResponse) {
            ResourceDto resourceDto = defServiceResponse.getResourceDtoResponse();
            System.out.println(resourceDto.toString());
        }
    }

    class GetMultipleResourcesCallback extends CommonDefCallback {
        @Override
        public void onSuccess(DefServiceResponse defServiceResponse) {
            List<ResourceDto> list = defServiceResponse.getResourceDtoListResponse();
            System.out.println(list);
        }
    }

    class SubmitCallback extends CommonDefCallback {
        @Override
        public void onSuccess(DefServiceResponse defServiceResponse) {
            System.out.println("Submission completed.");
        }
    }
}
