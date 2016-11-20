package org.codetaming.skillsmapper.client.views;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import org.codetaming.skillsmapper.client.events.SelectPersonEvent;
import org.codetaming.skillsmapper.client.events.SelectPersonEventHandler;
import org.codetaming.skillsmapper.client.widgets.ProfileImageWidget;
import org.codetaming.skillsmapper.client.widgets.ProtoWidget;
import org.gwtbootstrap3.client.ui.Label;

import java.util.logging.Logger;

public class ProfileViewWidget extends ProtoWidget implements SelectPersonEventHandler {

    private static final Logger LOGGER = Logger.getLogger("ProfileViewWidget");

    private static Binder uiBinder = GWT.create(ProfileViewWidget.Binder.class);

    private EventBus eventBus;

    @UiField
    Label hashLabel;

    @UiField(provided = true)
    ProfileImageWidget profileImageWidget;

    @Inject
    public ProfileViewWidget(SimpleEventBus eventBus, ProfileImageWidget profileImageWidget) {
        this.eventBus = eventBus;
        this.profileImageWidget = profileImageWidget;
        initWidget(uiBinder.createAndBindUi(this));
        initListeners();
    }

    private void initListeners() {
        eventBus.addHandler(SelectPersonEvent.TYPE, this);
    }

    @Override
    public void onSelectPerson(SelectPersonEvent selectPersonEvent) {
        hashLabel.setText(selectPersonEvent.getHash());
    }

    interface Binder extends UiBinder<Widget, ProfileViewWidget> {
    }
}
