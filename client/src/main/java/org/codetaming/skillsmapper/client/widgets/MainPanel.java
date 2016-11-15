package org.codetaming.skillsmapper.client.widgets;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class MainPanel extends Composite {

    private static Binder uiBinder = GWT.create(Binder.class);

    private SimpleEventBus eventBus;

    @UiField(provided = true)
    PeopleListWidget peopleListWidget;

    @Inject
    public MainPanel(SimpleEventBus eventBus, PeopleListWidget peopleListWidget) {
        this.eventBus = eventBus;
        this.peopleListWidget = peopleListWidget;
        initWidget(uiBinder.createAndBindUi(this));
    }

    interface Binder extends UiBinder<Widget, MainPanel> {
    }

}
