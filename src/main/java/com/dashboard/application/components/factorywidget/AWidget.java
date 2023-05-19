package com.dashboard.application.components.factorywidget;

import com.vaadin.flow.component.html.Image;

public abstract class AWidget {
    
    // Attributes

    protected final String name;
    protected final Image image = new Image();

    // Constructors

    protected AWidget(String name, String url) {
        this.name = name;
        image.setWidth("25%");
        image.setSrc(url);
        image.setAlt(name);
    }

    // Getters and setters

    public String getName() {
        return name;
    }

    public Image getImage() {
        return image;
    }

    
}
