package org.codetaming.skillsmapper.client.places;

import com.google.gwt.place.shared.PlaceHistoryMapperWithFactory;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;

import org.codetaming.skillsmapper.client.SkillsMapperGwtAppGinjector;
import org.codetaming.skillsmapper.client.places.SkillsMapperPlaceHistoryMapper.SkillsMapperPlaceTokenizers;

public interface SkillsMapperPlaceHistoryMapper extends PlaceHistoryMapperWithFactory<SkillsMapperPlaceTokenizers> {

    @Inject
    @Override
    void setFactory(SkillsMapperPlaceTokenizers factory);

    @ImplementedBy(SkillsMapperGwtAppGinjector.class)
    interface SkillsMapperPlaceTokenizers {
        PeoplePlace.Tokenizer peopleTokenizer();
        ProfilePlace.Tokenizer profileTokenizer();
    }
}
