package com.menros.echoplus.services.mongodbService.collection.dbTask.checklist;

import java.util.ArrayList;
import java.util.List;

public class DBTaskChecklist {
    private String name;
    private List<DBTaskChecklistElement> checklist;

    public DBTaskChecklist() {
    }

    public DBTaskChecklist(String name) {
        this(name, new ArrayList<>());
    }

    public DBTaskChecklist(String name, List<DBTaskChecklistElement> checklist) {
        this.name = name;
        this.checklist = checklist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DBTaskChecklistElement> getChecklist() {
        return checklist;
    }

    public void setChecklist(List<DBTaskChecklistElement> checklist) {
        this.checklist = checklist;
    }
}
