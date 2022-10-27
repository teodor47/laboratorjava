
public class Curs {
    String nume;
    String descriere;
    Profesor profu;
    Student[] studenti;

    public Curs(String nume) {
        this.nume = nume;
    }
    public Curs(String nume, String descriere,
                Profesor profu, Student[] studenti) {
        this.nume = nume;
        this.descriere = descriere;
        this.profu = profu;
        this.studenti = studenti;
    }

    public void UpdateProfesor(Profesor profu) {
        this.profu = profu;
    }

    public void deleteTeacher() {
        this.profu = null;
    }

    public int indexOf(Student student) {
        for (int index = 0; index < studenti.length; index++) {
            if (student.nume == studenti[index].nume) {
                return index;
            }
        }
        return -1;
    }
    public void AddStudent(Student student) {
//lucrand cu array trebuie inserat folosind un sir auxiliar
        int noualungime = studenti.length + 1;
        Student[] aux = new Student[noualungime];
        int index = 0;
        for (Student s : studenti) {
            aux[index++] = s;
        }
        aux[index] = student;
        this.studenti = new Student[noualungime];
        System.arraycopy(aux, 0, studenti, 0, noualungime);
    }

    public void deleteStudent(Student student) {
        int noualungime = studenti.length - 1;
        Student[] aux = new Student[noualungime];
        int index = 0;
        for (Student s : studenti) {
            if ( s.nume == student.nume && s.prenume == student.prenume && s.grupa == student.grupa) { continue; }
            aux[index++] = s;
        }

        aux[index] = student;
        this.studenti = new Student[noualungime];
        System.arraycopy(aux, 0, studenti, 0, noualungime);
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
}