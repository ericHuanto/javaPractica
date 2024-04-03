import java.util.List;

public class Inscripcion {
  private List<Materia> materiasAInscribir;
  private List<Materia> materiasAprobadas;

  public Inscripcion(Alumno alumno) {
    this.materiasAInscribir = alumno.getMateriasDeseadasAInscribir();
    this.materiasAprobadas = alumno.getMateriasAprobadas();
  }

  public boolean aprovado() {
    return materiasAInscribir.stream().allMatch(ma -> puedeMateria(ma));
  }

  private boolean puedeMateria(Materia materia) {
    boolean bandera = false;
    if(materia.siNecesitaCorrelativas()) {
      System.out.println("esta materia necesita correlativa");
      materiasAprobadas.contains(materia);

      bandera = materiasAprobadas.containsAll(materia.getCorrelativas());
    } else {
      //System.out.println("la materia es simple");
      bandera = true;
    }
    return bandera;
  }
}

