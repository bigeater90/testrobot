package robot.Execpt;

public class UndefinedRoadbookException extends Exception {
    public UndefinedRoadbookException() {
        super("Aucun road book défini");
    }
}
