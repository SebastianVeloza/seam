package entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2019-10-27T13:13:32.320-0500")
@StaticMetamodel(Nodo.class)
public class Nodo_ {
	public static volatile SingularAttribute<Nodo, Integer> idnodo;
	public static volatile SingularAttribute<Nodo, String> latitudnodo;
	public static volatile SingularAttribute<Nodo, String> longitudnodo;
	public static volatile SingularAttribute<Nodo, String> nombre;
	public static volatile ListAttribute<Nodo, Arista> aristas1;
	public static volatile ListAttribute<Nodo, Arista> aristas2;
	public static volatile ListAttribute<Nodo, Hospital> hospitals;
	public static volatile ListAttribute<Nodo, Paciente> pacientes;
}
