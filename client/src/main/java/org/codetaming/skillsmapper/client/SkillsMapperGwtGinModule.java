package org.codetaming.skillsmapper.client;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;
import org.codetaming.skillsmapper.client.widgets.MainPanel;
import org.codetaming.skillsmapper.client.widgets.PeopleListWidget;

public class SkillsMapperGwtGinModule extends AbstractGinModule {

    @Override
    protected void configure() {
        bind(SimpleEventBus.class).in(Singleton.class);
        bind(MainPanel.class).in(Singleton.class);
        bind(PeopleListWidget.class).in(Singleton.class);
    }
}
