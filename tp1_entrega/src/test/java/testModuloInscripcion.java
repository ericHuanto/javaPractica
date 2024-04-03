import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class testModuloInscripcion {
  Materia fisica1;
  Materia ingles1;
  Materia arquitectura;
  Materia fisica2;
  Materia sistemasOperativos;
  List<Materia> materiasAprobadasDeEric;
  List<Materia> materiasQueDeseaInscribirEricSimple;
  List<Materia> materiasQueDeseaInscribirEricComplejo1;
  List<Materia> materiasQueDeseaInscribirEricComplejo2;

  @BeforeEach
  void iniciarMaterias() {
    ingles1 = new Materia("ingles1", false, null);
    fisica1 = new Materia("fisica1", false, null);
    fisica2 = new Materia("fisica2", true, fisica1);
    arquitectura = new Materia("arquitectura", false, null);
    sistemasOperativos = new Materia("S.O.", true, arquitectura);
    materiasAprobadasDeEric = new ArrayList<>();
    materiasQueDeseaInscribirEricSimple = new ArrayList<>();
    materiasQueDeseaInscribirEricComplejo1 = new ArrayList<>();
    materiasQueDeseaInscribirEricComplejo2 = new ArrayList<>();
    Collections.addAll(materiasAprobadasDeEric,arquitectura,ingles1);
    Collections.addAll(materiasQueDeseaInscribirEricSimple,fisica1);
    Collections.addAll(materiasQueDeseaInscribirEricComplejo1,sistemasOperativos);
    Collections.addAll(materiasQueDeseaInscribirEricComplejo2,fisica2);
  }

  @Test
  public void unaMateriaSePuedeCrearSinCorrelativas() {
    Materia arquitectura = new Materia("arquitectura", false, null);
    Assertions.assertEquals("arquitectura",arquitectura.getNombre());
    Assertions.assertEquals(arquitectura.getCorrelativas().size(),0);
  }

  @Test
  public void ericPuedeCursarInglesQueNoRequiereCorrelativas() {
    Alumno eric = new Alumno("eric", materiasAprobadasDeEric, materiasQueDeseaInscribirEricSimple);
    Assertions.assertTrue((new Inscripcion(eric)).aprovado());
  }

  @Test
  public void ericPuedeCursarSistemasOperativosQueDependeDeArquitectura() {
    Alumno eric = new Alumno("eric", materiasAprobadasDeEric, materiasQueDeseaInscribirEricComplejo1);
    Assertions.assertTrue((new Inscripcion(eric)).aprovado());
  }

  @Test
  public void ericNoPuedeCursarFisica2QueDependeDeFisica1() {
    Alumno eric = new Alumno("eric", materiasAprobadasDeEric, materiasQueDeseaInscribirEricComplejo2);
    Assertions.assertFalse((new Inscripcion(eric)).aprovado());
  }
}
