package entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2019-10-27T13:13:32.280-0500")
@StaticMetamodel(Convenio.class)
public class Convenio_ {
	public static volatile SingularAttribute<Convenio, Integer> idconvenio;
	public static volatile SingularAttribute<Convenio, String> nombreconvenio;
	public static volatile ListAttribute<Convenio, Conveniohospital> conveniohospitals;
}
