import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Materia {
  private String nombre;
  private Boolean necesitaCorrelativa;
  private List<Materia> correlativas = new ArrayList<>();

  public Materia(String nombre, Boolean necesitaCorrelativa, Materia... materias ) {
    this.nombre = nombre;
    this.necesitaCorrelativa = necesitaCorrelativa;
    //Collections.addAll(this.correlativas, correlativas);
    if(materias != null) {
      for(Materia ma:materias) {
        this.correlativas.add(ma);
      }
    }

  }

  public String getNombre() {
    return nombre;
  }

  public Boolean siNecesitaCorrelativas() {
    return necesitaCorrelativa;
  }

  public List<Materia> getCorrelativas() {
    return correlativas;
  }
}
