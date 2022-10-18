import org.w3c.dom.css.CSSImportRule;

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

    public void AddCurs(Curs curs)
    {
        int noualungime = cursuri.length+1;
        Curs[] aux = new Curs[noualungime];
        int index =0;
        for(Curs c : cursuri) // foreach === for(int i = 0; i < cursur.length; i++) { Curs c = cursuri[i]; }
        {
            aux[index++] = c;
        }
        aux[index] = curs;
        this.cursuri = new Curs[noualungime];
        System.arraycopy(aux, 0, cursuri, 0,
                noualungime);
    }

    public void Modifica(Curs cursExistent, Curs newCurs) {
        int index = this.indexOf(cursExistent);
        this.cursuri[index] = newCurs;
    }

    public  void StergereCurs(Curs curs) {

        int noualungime = cursuri.length-1;
        Curs[] aux = new Curs[noualungime];
        int index =0;
        for(Curs c : cursuri) // foreach === for(int i = 0; i < cursur.length; i++) { Curs c = cursuri[i]; }
        {

            if ( c.nume == curs.nume ) { continue;}
            aux[index++] = c;
        }

        this.cursuri = new Curs[noualungime];
        System.arraycopy(aux, 0, cursuri, 0,
                noualungime);
    }
    public void AfiseazaCursuriLaConsola()
    {
        for(Curs c : cursuri)
            System.out.println(c);
    }
}
