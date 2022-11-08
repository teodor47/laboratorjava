import java.util.Arrays;

public class Curs {
    String nume;
    String descriere;
    Profesor profu;
    Student[] studenti;
    Integer[] note;
    public Curs(String nume) {
        this.nume = nume;
    }
    public Curs(String nume, String descriere,
                Profesor profu, Student[] studenti) {
        this.nume = nume;
        this.descriere = descriere;
        this.profu = profu;
        this.studenti = studenti;
        this.note = new Integer[studenti.length];
    }

    public void updateProfesor(Profesor profu) {
        this.profu = profu;
    }

    public void deleteTeacher() {
        this.profu = null;
    }

    public int indexOf(Student student) {
        for (int index = 0; index < studenti.length; index++) {
            if (student.nume == studenti[index].nume && student.prenume == studenti[index].prenume) {
                return index;
            }
        }
        return -1;
    }

    public void noteaza(Student student, int nota) {
        int index = indexOf(student);
        note[index] = nota;
    }

    public void addStudent(Student student) {
        this.studenti = ArrayHelper.push(studenti, student);
        this.note = ArrayHelper.push(this.note, 0);
    }

    public void deleteStudent(Student student) {
        int indexOfStudentToBeRemoved = indexOf(student);
        ArrayHelper.swap(studenti, indexOfStudentToBeRemoved, studenti.length - 1);
        this.studenti = ArrayHelper.pop(studenti);
        ArrayHelper.swap(note, indexOfStudentToBeRemoved, note.length - 1);
        this.note = ArrayHelper.pop(note);
    }

    @Override
    public String toString() {
        String str =
                "Curs: " + "nume=" + nume + ", descriere=" + descriere + ",profu=" + profu + ",\nstudenti:\n";
        for (Student s : studenti) {
            str += s + "\n";
        }
        return str;
    }

    public void reportNote() {
        for(int i = 0; i < studenti.length; i++) {
            System.out.println(studenti[i] + " " + note[i]);
        }
    }

    public void reportStudents() {
        for (Student s: studenti) {
            System.out.println(s);
        }
    }
    public float mediaNotelor() {
        int sum = 0;
        for( int nota: note) {
            sum += nota;
        }
        return sum/(float)note.length;
    }
}