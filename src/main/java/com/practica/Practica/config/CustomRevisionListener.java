package com.practica.Practica.config;

import com.practica.Practica.entities.audit.Revision;
import org.hibernate.envers.RevisionListener;

public class CustomRevisionListener implements RevisionListener {
    public void newRevision(Object revisionEntity){ final Revision revision = (Revision) revisionEntity;
    }
}
