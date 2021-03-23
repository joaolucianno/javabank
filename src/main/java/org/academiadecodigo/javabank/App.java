package org.academiadecodigo.javabank;

import org.academiadecodigo.javabank.controller.Controller;
import org.academiadecodigo.javabank.controller.LoginController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class App {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new FileSystemXmlApplicationContext(
                "src/main/resources/META-INF/spring-config.xml");
        Controller controller = applicationContext.getBean(LoginController.class);
        controller.init();

    }

}
