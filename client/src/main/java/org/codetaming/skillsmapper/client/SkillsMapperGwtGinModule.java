package org.codetaming.skillsmapper.client;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;

import org.codetaming.skillsmapper.client.controllers.LoggingController;
import org.codetaming.skillsmapper.client.places.DefaultPlace;
import org.codetaming.skillsmapper.client.places.PeoplePlace;
import org.codetaming.skillsmapper.client.views.PeopleViewWidget;
import org.codetaming.skillsmapper.client.widgets.PeopleListWidget;
import org.codetaming.skillsmapper.client.widgets.ProfileDetailsWidget;
import org.codetaming.skillsmapper.client.widgets.SkillsWidget;

public class SkillsMapperGwtGinModule extends AbstractGinModule {

    @Override
    protected void configure() {
        bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);
        bind(LoggingController.class).in(Singleton.class);
        bind(MainPanel.class).in(Singleton.class);
        bind(SkillsWidget.class).in(Singleton.class);
        bind(PeopleListWidget.class).in(Singleton.class);
        bind(PeopleViewWidget.class).in(Singleton.class);
        bind(ProfileDetailsWidget.class).in(Singleton.class);
        bind(Place.class).annotatedWith(DefaultPlace.class).to(PeoplePlace.class);
    }

    @Singleton
    @Provides
    PlaceController providePlaceController(com.google.web.bindery.event.shared.EventBus eventBus) {
        return new PlaceController(eventBus);
    }

    @Singleton
    @Provides
    PlaceHistoryHandler providePlaceHistoryHandler(PlaceHistoryMapper mapper, PlaceController placeController, EventBus eventBus, @DefaultPlace Place defaultPlace) {
        PlaceHistoryHandler phh = new PlaceHistoryHandler(mapper);
        phh.register(placeController, eventBus, defaultPlace);
        return phh;
    }
}
