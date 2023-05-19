package com.dashboard.application.views.widgets;

import org.springframework.beans.factory.annotation.Autowired;

import com.dashboard.application.components.factorywidget.WidgetList;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.notification.Notification;

public class WidgetsStoreViewCard extends ListItem {

    @Autowired
    private static WidgetList widgetList = new WidgetList();

    public WidgetsStoreViewCard(String text, String url) {
        addClassNames("bg-contrast-5", "flex", "flex-col", "items-start", "p-m", "rounded-l");

        Div div = new Div();
        div.addClassNames("bg-contrast", "flex items-center", "justify-center", "mb-m", "overflow-hidden",
                "rounded-m w-full");
        div.setHeight("160px");

        Image image = new Image();
        image.setWidth("100%");
        image.setSrc(url);
        image.setAlt(text);

        div.add(image);

        Span header = new Span();
        header.addClassNames("text-xl", "font-semibold");
        header.setText(text);

        Span subtitle = new Span();
        subtitle.addClassNames("text-s", "text-secondary");
        subtitle.setText("Card subtitle");

        Paragraph description = new Paragraph(
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut.");
        description.addClassName("my-m");

        Button addButton = new Button("Add");
        addButton.addClickListener(e -> {
            if(widgetList.add(null))
                Notification.show("Widget \"" + text + "\" has been added.");
            else 
                Notification.show("Problem : Widget \"" + text + "\" hasn't been added.");
        });

        add(div, header, subtitle, description, addButton);

    }
}
