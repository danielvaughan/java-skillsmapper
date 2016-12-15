package org.codetaming.skillsmapper.client.widgets;

import com.google.web.bindery.event.shared.EventBus;

import org.codetaming.skillsmapper.client.events.SelectPersonEvent;
import org.codetaming.skillsmapper.client.model.Person;
import org.gwtbootstrap3.client.ui.Column;
import org.gwtbootstrap3.client.ui.Image;
import org.gwtbootstrap3.client.ui.LinkedGroupItem;
import org.gwtbootstrap3.client.ui.LinkedGroupItemText;
import org.gwtbootstrap3.client.ui.Row;
import org.gwtbootstrap3.client.ui.constants.ColumnSize;

public class PersonListItemWidget extends LinkedGroupItem {

    public PersonListItemWidget(final Person person, final EventBus eventBus) {
        super();
        Row row = new Row();
        String imageUrl = person.getImageUrl() == null ? "http://common.gcscc.site/img/silhouette.png" : person.getImageUrl();
        Image image = new Image(imageUrl);
        image.setResponsive(true);
        image.setHeight("50px");
        image.setAltText("Picture of " + person.getName());
        image.addStyleName("person-thumbnail");
        row.add(new Column(ColumnSize.LG_3, image));
        row.add(new Column(ColumnSize.LG_9, new LinkedGroupItemText(person.getName())));
        addClickHandler(clickEvent -> {
            eventBus.fireEvent(new SelectPersonEvent(person.getURI()));
        });
        add(row);
    }
}
