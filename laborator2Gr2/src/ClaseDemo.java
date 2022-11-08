import java.util.ArrayList;

public class ClaseDemo {

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        //definire studenti
        Student[] studenti = new Student[]{new Student("Andrei","Negoita",2231),new Student("Ion","Mateescu",4221)};
        //definire profesor
        Profesor prof = new Profesor("Anton","Panaitescu");
        //definire curs nou
        Curs curs = new Curs("Rezistenta Materialelor", "calculul reacţiunilor,\n" +
                "diagramele de eforturi, calculul caracteristicilor geometrice ale\n" +
                "suprafeţelor plane şi calculul elementelor de rezistenţă la solicitări simple\n"
                , prof, studenti);
        Curs curs2 = new Curs("PCLP", "calculul reacţiunilor,\n" +
                "diagramele de eforturi, calculul caracteristicilor geometrice ale\n" +
                "suprafeţelor plane şi calculul elementelor de rezistenţă la solicitări simple\n"
                , prof, studenti);
        //adaugare curs in lista de cursuri
        ManagerCursuri cursuri = new ManagerCursuri();
        cursuri.addCurs(curs);
        cursuri.addCurs(curs2);
        cursuri.stergereCurs(curs2);
        curs.addStudent(new Student("Aaaaa", "BBBBB"));
        curs.noteaza(new Student("Aaaaa", "BBBBB"), 10);
        curs.noteaza(new Student("Andrei", "Negoita"), 10);
        curs.noteaza(new Student("Ion","Mateescu"), 5);
        cursuri.reportNote();
    }
}
