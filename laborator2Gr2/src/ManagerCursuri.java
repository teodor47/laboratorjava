public class ManagerCursuri {
    Curs[] cursuri;

    public ManagerCursuri()
    {
        cursuri = new Curs[0];
    }

    int indexOf(Curs curs) {
        for(int index = 0; index < cursuri.length; index++) {
            if (cursuri[index].nume == curs.nume ) {
                return index;
            }
        }
        return -1;
    }

    void replaceStudent(Curs fromCurs, Student oldStudent, Student withNewStudent) {
        Curs curs = cursuri[this.indexOf(fromCurs)];
        curs.studenti[curs.indexOf(oldStudent)] = withNewStudent;
    }
    public void addCurs(Curs curs)
    {
        this.cursuri = ArrayHelper.push(this.cursuri, curs);
    }

    public void modifica(Curs cursExistent, Curs newCurs) {
        int index = this.indexOf(cursExistent);
        this.cursuri[index] = newCurs;
    }

    public  void stergereCurs(Curs curs) {
        ArrayHelper.swap(this.cursuri, indexOf(curs), cursuri.length - 1);
        this.cursuri = ArrayHelper.pop(this.cursuri);
    }
    public void afiseazaCursuriLaConsola()
    {
        for(Curs c : cursuri)
            System.out.println(c);
    }

    // Raport note tuturor studentilor
    public void reportNote() {
        for(Curs c: cursuri) {
            c.reportNote();
        }
    }

    public void reportStudents(Curs curs) {
        this.cursuri[indexOf(curs)].reportStudents();
    }
    // Raport note la un anumit curs
    public void reportNote(Curs curs) {
        this.cursuri[indexOf(curs)].reportNote();
    }

    // Raport note date de un profesor
    public float reportMediaNotelor(Profesor profesor) {
        float mediaNotelor = 0.0f;
        int count = 0;
        for(Curs c : cursuri) {
            if (c.profu.nume.equals(profesor.nume) && c.profu.prenume.equals(profesor.prenume)) {
                mediaNotelor += c.mediaNotelor();
                count++;
            }
        }
        return mediaNotelor / count;
    }
}
