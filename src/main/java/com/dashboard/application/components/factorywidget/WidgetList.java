package com.dashboard.application.components.factorywidget;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.PermitAll;

import org.springframework.stereotype.Component;

@PermitAll
@Component
public class WidgetList {
    
    // Attributes

    private static List<AWidget> widgetList= new ArrayList<AWidget>();

    // Constructors

    public WidgetList() {}

    // Methods

    public boolean add(AWidget widget) {
        int sizetmp = widgetList.size();
        widgetList.add(widget);

        if(widgetList.size() > sizetmp)
            return true;
        else 
            return false;
    }





}

