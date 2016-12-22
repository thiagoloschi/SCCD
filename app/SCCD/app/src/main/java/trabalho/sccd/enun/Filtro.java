package trabalho.sccd.enun;

/**
 * Created by saw on 11/12/16.
 */

public enum Filtro {
    SEM_FITRO("SEMFILTRO"), MAIOR_SALARIO("MAIORSALARIO"), ULTIMAS_VAGAS("ULTIMASVAGAS");

    private String filtro;
    Filtro(String filtro) {
        this.filtro = filtro;
    }

    @Override
    public String toString() {
        return filtro;
    }
}
