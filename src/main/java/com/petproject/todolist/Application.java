package com.petproject.todolist;

import com.petproject.todolist.config.AppConfig;
import com.petproject.todolist.ui.MainMenu;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(AppConfig.class);
        var menu = context.getBean(MainMenu.class);
        menu.execute();
    }
}
