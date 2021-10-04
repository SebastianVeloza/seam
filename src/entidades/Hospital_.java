package entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2019-10-27T13:13:32.312-0500")
@StaticMetamodel(Hospital.class)
public class Hospital_ {
	public static volatile SingularAttribute<Hospital, Integer> idhospital;
	public static volatile SingularAttribute<Hospital, Integer> numeropacientes;
	public static volatile SingularAttribute<Hospital, Integer> tiempoconsulta;
	public static volatile ListAttribute<Hospital, Conveniohospital> conveniohospitals;
	public static volatile SingularAttribute<Hospital, Nodo> nodo;
	public static volatile ListAttribute<Hospital, Paciente> pacientes;
}
