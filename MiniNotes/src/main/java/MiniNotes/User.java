package MiniNotes;

import java.util.ArrayList;

public class User {
    private String login;
    private String password;
    private String usetId;
    private ArrayList<Notes> notesList;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsetId() {
        return usetId;
    }


    public ArrayList<Notes> getNotesList() {
        return notesList;
    }

    public void setNotesList(ArrayList<Notes> notesList) {
        this.notesList = notesList;
    }
}
