package org.codetaming.skillsmapper.client.places;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

@DefaultPlace
public class PeoplePlace extends Place {

    @Prefix("")
    public static class Tokenizer implements PlaceTokenizer<PeoplePlace> {

        @Override
        public PeoplePlace getPlace(String token) {
            return new PeoplePlace();
        }

        @Override
        public String getToken(PeoplePlace place) {
            return "people";
        }
    }

}
