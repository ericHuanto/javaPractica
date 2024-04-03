import java.util.List;

public class Alumno {
  private String nombre;
  private List<Materia> materiasAprobadas;
  private List<Materia> materiasDeseadasAInscribir;

  public Alumno(String nombre, List<Materia> materiasAprobadas, List<Materia> materiasDeseadasAInscribir) {
    this.nombre = nombre;
    this.materiasAprobadas = materiasAprobadas;
    this.materiasDeseadasAInscribir = materiasDeseadasAInscribir;
  }

  public List<Materia> getMateriasAprobadas() {
    return materiasAprobadas;
  }

  public List<Materia> getMateriasDeseadasAInscribir() {
    return materiasDeseadasAInscribir;
  }
}
