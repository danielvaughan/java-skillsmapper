package org.codetaming.skillsmapper.client.widgets;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

import org.codetaming.skillsmapper.client.model.Tag;
import org.gwtbootstrap3.client.ui.Heading;
import org.gwtbootstrap3.client.ui.Label;
import org.gwtbootstrap3.client.ui.html.Paragraph;

import java.util.List;
import java.util.logging.Logger;

public class TagBoxWidget extends ProtoWidget {

    private static final Logger LOGGER = Logger.getLogger(TagBoxWidget.class.getName());

    private static Binder uiBinder = GWT.create(Binder.class);

    @UiField
    Paragraph bucket;
    @UiField
    Heading heading;
    @UiField
    TagBoxWidget.MyStyle style;

    @Inject
    public TagBoxWidget() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    public void setTags(List<Tag> tags) {
        bucket.clear();
        for (Tag tag : tags) {
            Label label = new Label(tag.getName());
            label.getElement().addClassName(style.spacing());
            bucket.add(label);
        }
    }

    public void setHeading(String text) {
        heading.setText(text);
    }

    interface MyStyle extends CssResource {
        String spacing();
    }

    interface Binder extends UiBinder<Widget, TagBoxWidget> {
    }

}
