package org.codetaming.skillsmapper.client.widgets;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import org.codetaming.skillsmapper.client.model.Tag;
import org.gwtbootstrap3.client.ui.Label;
import org.gwtbootstrap3.client.ui.PanelBody;

import java.util.Set;
import java.util.logging.Logger;

public class TagBoxWidget extends ProtoWidget {

    private static final Logger LOGGER = Logger.getLogger("TagBoxWidget");

    @UiField
    PanelBody panelBody;

    @Inject
    public TagBoxWidget() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    public void setTags(Set<Tag> tags) {
        panelBody.clear();
        for (Tag tag : tags) {
            panelBody.add(new Label(tag.getName()));
        }
    }

    interface Binder extends UiBinder<Widget, TagBoxWidget> {
    }

    private static Binder uiBinder = GWT.create(Binder.class);

}
