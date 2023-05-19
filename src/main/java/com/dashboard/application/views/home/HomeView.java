package com.dashboard.application.views.home;

import javax.annotation.security.PermitAll;

import com.dashboard.application.views.MainLayout;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@PermitAll
@PageTitle("Home")
@Route(value = "home", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class HomeView extends HorizontalLayout {

    private TextField name;
    private Button sayHello;

    public HomeView() {
        name = new TextField("Your name");
        sayHello = new Button("Say hello");
        sayHello.addClickListener(e -> {
            Notification.show("Hello " + name.getValue());
            name.setValue("");
        });
        sayHello.addClickShortcut(Key.ENTER);

        setMargin(true);
        setVerticalComponentAlignment(Alignment.END, name, sayHello);

        add(name, sayHello);
    }

}
