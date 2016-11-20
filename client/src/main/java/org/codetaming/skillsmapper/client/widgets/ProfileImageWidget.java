package org.codetaming.skillsmapper.client.widgets;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.inject.Inject;
import org.codetaming.skillsmapper.client.events.SelectPersonEvent;
import org.codetaming.skillsmapper.client.events.SelectPersonEventHandler;
import org.codetaming.skillsmapper.client.model.ImageInfo;
import org.codetaming.skillsmapper.client.services.ImageService;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;
import org.gwtbootstrap3.client.ui.Image;

import java.util.logging.Logger;

public class ProfileImageWidget extends ProtoWidget implements SelectPersonEventHandler {

    private static final Logger LOGGER = Logger.getLogger("ProfileImageWidget");

    private EventBus eventBus;

    private Image image = new Image();

    @Inject
    public ProfileImageWidget(SimpleEventBus eventBus) {
        this.eventBus = eventBus;
        initWidget(image);
        initListeners();
    }

    private void initListeners() {
        eventBus.addHandler(SelectPersonEvent.TYPE, this);
    }

    @Override
    public void onSelectPerson(SelectPersonEvent selectPersonEvent) {
        reload(selectPersonEvent.getHash());
    }

    private void reload(String hash) {
        ImageService imageService = GWT.create(ImageService.class);
        imageService.getImageByHash(hash, new MethodCallback<ImageInfo>() {
            @Override
            public void onFailure(final Method method, final Throwable exception) {
                LOGGER.severe(exception.getMessage());
            }

            @Override
            public void onSuccess(Method method, ImageInfo imageInfo) {
                LOGGER.info("Setting image url to: " + imageInfo.getImageUrl());
                image.setUrl(imageInfo.getImageUrl());
                image.setTitle(imageInfo.getName());
            }
        });
    }
}
