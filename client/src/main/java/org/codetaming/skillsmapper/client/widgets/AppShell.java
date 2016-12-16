package org.codetaming.skillsmapper.client.widgets;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasOneWidget;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.gwtbootstrap3.client.ui.Container;

import java.util.logging.Logger;

@Singleton
public class AppShell extends Composite implements HasOneWidget {

    interface Binder extends UiBinder<Widget, AppShell> {
    }

    private Binder uiBinder = GWT.create(Binder.class);

    private static final Logger LOGGER = Logger.getLogger(AppShell.class.getName());

    @UiField
    Container display;

    @Inject
    public AppShell(ActivityManager activityManager) {
        initWidget(uiBinder.createAndBindUi(this));
        activityManager.setDisplay(this);
    }

    @Override
    public Widget getWidget() {
        return display.getWidgetCount() == 0 ? null : display.getWidget(0);
    }

    @Override
    public void setWidget(Widget widget) {
        display.clear();
        if (widget != null) {
            display.add(widget);
        }
    }

    public void setWidget(IsWidget w) {
        setWidget(w == null ? null : w.asWidget());
    }
}
