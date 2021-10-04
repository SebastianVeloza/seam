package entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2019-10-27T13:13:32.328-0500")
@StaticMetamodel(Paciente.class)
public class Paciente_ {
	public static volatile SingularAttribute<Paciente, Integer> idpaciente;
	public static volatile SingularAttribute<Paciente, String> nombrePaciente;
	public static volatile SingularAttribute<Paciente, Hospital> hospital;
	public static volatile SingularAttribute<Paciente, Nodo> nodo;
}
