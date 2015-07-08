package be.vdab;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;

import javax.servlet.annotation.WebServlet;


@Title("Hello,World")
@Theme("valo")
@Widgetset("com.realdolmen.helloworld.MyAppWidgetset")
public class HelloWorld extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true
        );
        Label label = new Label("Hello!");
        Button button = new Button("Not a button");

        button.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
             Notification.show("Still not a button");
            }
        });

        layout.addComponent(label);
        layout.addComponent(button);

        setContent(layout);

    }

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = HelloWorld.class)
    public static class Servlet extends VaadinServlet{}
}
