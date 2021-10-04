package entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2019-10-27T13:13:32.789-0500")
@StaticMetamodel(Arista.class)
public class Arista_ {
	public static volatile SingularAttribute<Arista, Integer> idarista;
	public static volatile SingularAttribute<Arista, Integer> peso;
	public static volatile SingularAttribute<Arista, Integer> velocidad;
	public static volatile SingularAttribute<Arista, Integer> visitable;
	public static volatile SingularAttribute<Arista, Nodo> nodo1;
	public static volatile SingularAttribute<Arista, Nodo> nodo2;
}
