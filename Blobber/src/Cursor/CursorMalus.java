package Cursor;

public class CursorMalus extends ACursorDecorator {

    public CursorMalus() {
        super(-1);
        System.out.println("Malus activated");
    }
}
