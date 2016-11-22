package org.codetaming.skillsmapper.client;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;
import org.codetaming.skillsmapper.client.controllers.LoggingController;
import org.codetaming.skillsmapper.client.views.PeopleViewWidget;
import org.codetaming.skillsmapper.client.widgets.PeopleListWidget;
import org.codetaming.skillsmapper.client.widgets.ProfileDetailsWidget;
import org.codetaming.skillsmapper.client.widgets.ProfileImageWidget;
import org.codetaming.skillsmapper.client.widgets.SkillsWidget;

public class SkillsMapperGwtGinModule extends AbstractGinModule {

    @Override
    protected void configure() {
        bind(SimpleEventBus.class).in(Singleton.class);
        bind(LoggingController.class).in(Singleton.class);
        bind(MainPanel.class).in(Singleton.class);
        bind(SkillsWidget.class).in(Singleton.class);
        bind(PeopleListWidget.class).in(Singleton.class);
        bind(PeopleViewWidget.class).in(Singleton.class);
        bind(ProfileImageWidget.class).in(Singleton.class);
        bind(ProfileDetailsWidget.class).in(Singleton.class);
    }
}
