package com.dashboard.application.views;


import com.dashboard.application.components.appnav.AppNav;
import com.dashboard.application.components.appnav.AppNavItem;
import com.dashboard.application.security.SecurityService;
import com.dashboard.application.views.home.HomeView;
import com.dashboard.application.views.mywidgets.MyWidgetsView;
import com.dashboard.application.views.widgets.WidgetsStoreView;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.theme.lumo.LumoUtility;

/**
 * The main view is a top-level placeholder for other views.
 */
public class MainLayout extends AppLayout {

    private H2 viewTitle;

    private final SecurityService securityService;


    public MainLayout(SecurityService securityService) {
        this.securityService = securityService;
        setPrimarySection(Section.DRAWER);
        addDrawerContent();
        addHeaderContent();

    }

    private void addHeaderContent() {
        DrawerToggle toggle = new DrawerToggle();
        toggle.getElement().setAttribute("aria-label", "Menu toggle");

        viewTitle = new H2();
        viewTitle.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);

        addToNavbar(true, toggle, viewTitle);
    }

    private void addDrawerContent() {
        H1 appName = new H1("DashBoard");
        appName.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);

        Header header = new Header(appName);

        Scroller scroller = new Scroller(createNavigation());

        addToDrawer(header, scroller, createFooter());
    }


    private AppNav createNavigation() {
        // AppNav is not yet an official component.
        // For documentation, visit https://github.com/vaadin/vcf-nav#readme
        AppNav nav = new AppNav();

        nav.addItem(new AppNavItem("Home", HomeView.class, "la la-globe"));
        nav.addItem(new AppNavItem("My Widgets", MyWidgetsView.class, "la la-ankh"));
        nav.addItem(new AppNavItem("Widgets Store", WidgetsStoreView.class, "lab la-app-store"));
        return nav;
    }

    private Footer createFooter() {
        Footer layout = new Footer();
        HorizontalLayout createButton = new HorizontalLayout();
        Button logout = new Button("Log out", e -> securityService.logout()); 
        createButton.add(logout);
        layout.add(createButton);
        return layout;
    }

    @Override
    protected void afterNavigation() {
        super.afterNavigation();
        viewTitle.setText(getCurrentPageTitle());
    }

    private String getCurrentPageTitle() {
        PageTitle title = getContent().getClass().getAnnotation(PageTitle.class);
        return title == null ? "" : title.value();
    }
}
