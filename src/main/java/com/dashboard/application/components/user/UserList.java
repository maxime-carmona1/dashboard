package com.dashboard.application.components.user;

import com.dashboard.application.api.rest.User;
import com.dashboard.application.api.services.UsersService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("User List")
@Route("/users")
public class UserList extends VerticalLayout {

    public UserList(UsersService service) {

        Grid<User> grid = new Grid<User>(User.class);
         grid.setItems(service.getUsers());

         add(grid);
    }
}
