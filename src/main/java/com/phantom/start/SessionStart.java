package com.phantom.start;

import lombok.Getter;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@Getter
public class SessionStart {
    private SessionFactory factory;

    public SessionStart() {
        factory = new Configuration()
                .configure("config/hibernate.cfg.xml")
                .buildSessionFactory();
    }

}
