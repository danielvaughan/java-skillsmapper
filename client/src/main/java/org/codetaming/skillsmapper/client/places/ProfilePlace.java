package org.codetaming.skillsmapper.client.places;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class ProfilePlace extends Place {

    private final String id;

    public ProfilePlace(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ProfilePlace{" +
                "id='" + id + '\'' +
                '}';
    }

    @Prefix("profile")
    public static class Tokenizer implements PlaceTokenizer<ProfilePlace> {

        @Override
        public ProfilePlace getPlace(String token) {
            return new ProfilePlace(token);
        }

        @Override
        public String getToken(ProfilePlace place) {
            return place.getId();
        }
    }
}
