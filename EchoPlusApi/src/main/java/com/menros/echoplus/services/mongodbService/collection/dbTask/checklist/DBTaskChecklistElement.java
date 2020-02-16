package com.menros.echoplus.services.mongodbService.collection.dbTask.checklist;

public class DBTaskChecklistElement {
    private String name;
    private boolean checked;

    public DBTaskChecklistElement() {
    }

    public DBTaskChecklistElement(String name) {
        this(name, false);
    }

    public DBTaskChecklistElement(String name, boolean checked) {
        this.name = name;
        this.checked = checked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
