package MiniNotes;

import javax.xml.crypto.Data;
import java.util.ArrayList;

public class Notes {
    public String noteName;
    private int noteId;
    private Data timeCreate;
    public Data timeUpdate;
    public ArrayList<String> noteBody;

    public Notes(String noteName, int noteId, Data timeCreate, Data timeUpdate, ArrayList<String> noteBody) {
        this.noteName = noteName;
        this.noteId = noteId;
        this.timeCreate = timeCreate;
        this.timeUpdate = timeUpdate;
        this.noteBody = noteBody;
    }

    public String getNoteName() {
        return noteName;
    }

    public void setNoteName(String noteName) {
        this.noteName = noteName;
    }

    public int getNoteId() {
        return noteId;
    }

    public Data getTimeCreate() {
        return timeCreate;
    }

    public Data getTimeUpdate() {
        return timeUpdate;
    }

    public void setTimeUpdate(Data timeUpdate) {
        this.timeUpdate = timeUpdate;
    }

    public ArrayList<String> getNoteBody() {
        return noteBody;
    }

    public void setNoteBody(ArrayList<String> noteBody) {
        this.noteBody = noteBody;
    }
}
