package com.app.client.mvp.presenter;

import java.util.List;

import com.app.client.mvp.presenter.core.AbstractPresenter;
import com.app.client.mvp.view.View1;
import com.app.shared.transport.ResourceDto;
import com.app.shared.transport.common.DefServiceResponse;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.smartgwt.client.widgets.form.fields.events.ClickEvent;
import com.smartgwt.client.widgets.form.fields.events.ClickHandler;

public class Presenter1 extends AbstractPresenter {
    private final View1 view;
    
    public Presenter1(View1 view) {
        this.view = view;
    }

    @Override
    public void registerUIEventHandlers() {
        view.addButtonItemHandler(new ButtonItemListener());
        view.addCommandButtonHandler(new CommandButtonListener());
    }
    
    /*********************************** HANDLERS ***********************************/
    class ButtonItemListener implements ClickHandler {
        public void onClick(ClickEvent event) {
            rpc.getString("hello", new GetStringCallback());
            rpc.getOneResource(new GetOneResourceCallback());
        }
    }
    
    class CommandButtonListener implements com.smartgwt.client.widgets.events.ClickHandler {
        public void onClick(com.smartgwt.client.widgets.events.ClickEvent event) {
            rpc.getMultipleResources(new GetMultipleResourcesCallback());
            rpc.submit("submit", new SubmitCallback());
        }
    }
    
    /*********************************** ASYNC ***********************************/
    abstract class CommonCallback implements AsyncCallback<DefServiceResponse> {
        @Override
        public void onFailure(Throwable exception) {
            showWarning(exception.getMessage());
        }
    }
    
    class GetStringCallback extends CommonCallback {
        @Override
        public void onSuccess(DefServiceResponse defServiceResponse) {
            String stringResponse = defServiceResponse.getStringResponse();
            System.out.println(stringResponse);
        }
    }
    
    class GetOneResourceCallback extends CommonCallback {
        @Override
        public void onSuccess(DefServiceResponse defServiceResponse) {
            ResourceDto resourceDto = defServiceResponse.getResourceDtoResponse();
            System.out.println(resourceDto.toString());
        }
    }
    
    class GetMultipleResourcesCallback extends CommonCallback {
        @Override
        public void onSuccess(DefServiceResponse defServiceResponse) {
            List<ResourceDto> list = defServiceResponse.getResourceDtoListResponse();
            System.out.println(list);
        }
    }
    
    class SubmitCallback extends CommonCallback {
        @Override
        public void onSuccess(DefServiceResponse defServiceResponse) {
            System.out.println("Submission completed.");
        }
    }
}
