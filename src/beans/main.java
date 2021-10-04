package beans;
//Hecho por:Sebastian Veloza

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import com.sun.javafx.binding.SelectBinding.AsInteger;

import beans.AristaBeans;
import entidades.Arista;
import entidades.Hospital;
import entidades.Nodo;
import entidades.Paciente;

public class main {

	public static void main(String[] args) {
		HospitalBeans hospitales = new HospitalBeans();
		hospitales.inicializar();
		for (int i = 0; i < hospitales.getHospitales().size(); i++) {

			int pas = (int) (Math.random() * 30);
			int tiempoConsulta = (int) (Math.random() * 10) + 5;
			hospitales.editarHospital(hospitales.getHospitales().get(i).getIdhospital(), pas, tiempoConsulta);

		}

		Scanner sc = new Scanner(System.in); // para lectura de datos
//inicializamos las clases
		AristaBeans aristas = new AristaBeans();
		NodoBeans nodos = new NodoBeans();
		PacientesBeans paciente = new PacientesBeans();
		HospitalBeans hospital = new HospitalBeans();		
		ConveniosBeans convenio = new ConveniosBeans();
		ConvenioHospitalBeans conveniohospital = new ConvenioHospitalBeans();
		
//Inicializamos la base de datos 
		paciente.inicializar();
		aristas.inicializar();
		nodos.inicializar();		
		convenio.inicializar();
		conveniohospital.inicializar();	
		
		

	
		hospital.inicializar();

		 //hacer lista de aristas
		String aristalist[] = new String[aristas.getAristas().size()];
		
		
		for (int i = 0; i < aristas.getAristas().size(); i++) {

			

		//	aristas.editarArista(aristas.getAristas().get(i).getIdarista(), velocidad);			
			aristalist[i] = aristas.getAristas().get(i).getIdarista() + ". De  "
					+ aristas.getAristas().get(i).getNodo1().getNombre() + " Hasta "
					+ aristas.getAristas().get(i).getNodo2().getNombre();
				

		}


		aristas.inicializar();
//Guardamos la ubicacion del usuarios mediante un combo box 
		String iniciales[] = new String[nodos.getNodos().size()];
		for (int i = 0; i < nodos.getNodos().size(); i++) {

			iniciales[i] = i + ". " + nodos.getNodos().get(i).getNombre();
		}

		Object nodoInicial = JOptionPane.showInputDialog(null, "Seleccione Ubicacion actual ", "Ubicacion",
				JOptionPane.DEFAULT_OPTION, null, iniciales, "seleccione");
		int inicial = -1;

		for (int i = 0; i < nodos.getNodos().size(); i++) {
			if (nodoInicial.toString().equals(iniciales[i])) {
				inicial = i;
			}
		}

		

		// Borrar arista

		try {
			boolean eliminar = true;

			while (eliminar) {

				int opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
						"Quieres borrar alguna arista\n" + "indica\n" + "1.si quieres borrar\n" + "2.Presione 'Enter' o aceptar para continuar"));

				if (opcion == 1) {

					/////////////////////////////////////////

					Object arsitaeliminar = JOptionPane.showInputDialog(null, "Seleccione arista a eliminar ", "Arista",
							JOptionPane.DEFAULT_OPTION, null, aristalist, "seleccione");

					StringTokenizer tok = new StringTokenizer(arsitaeliminar.toString(), ".");
					String n = tok.nextToken();
				//	aristas.eliminarArista(Integer.parseInt(n));
				//	aristas.inicializar();
					
					aristas.getAristas().get(Integer.parseInt(n)).setVisitable(0);
					/*
					 * for (int i = 0; i < nodos.getNodos().size(); i++) { if
					 * (nodoInicial.toString().equals(iniciales[i])) { inicial = i; } }
					 */

				} else {
					eliminar = false;
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		
		//Pedir al usuario que seleccione su EPS
		String convenioslist[] = new String[convenio.getConvenios().size()];
		for (int i = 0; i < convenio.getConvenios().size(); i++) {
//hacemos un arreglo de la base de datos de la tabla convenio
			convenioslist[i] = convenio.getConvenios().get(i).getIdconvenio() + ". " + convenio.getConvenios().get(i).getNombreconvenio();
		}

		Object opcConvenio = JOptionPane.showInputDialog(null, "Seleccione su EPS ", "EPS",
				JOptionPane.DEFAULT_OPTION, null, convenioslist, "seleccione");
		
		//Partimos la cadenas en tokens  y escogemos el primero que es el id
		
		StringTokenizer conv = new StringTokenizer(opcConvenio.toString(), ".");
		String convStr = conv.nextToken();
		
		
		//Inicializamos el dijkstra
		Dijkstra dijkstraAlgorithm = new Dijkstra(nodos.getNodos().size());
		
		
		
		for (int i = 0; i < aristas.getAristas().size(); ++i) {
			
			
		//Extraemos la matriz de la base de datos y la guardamos en el dijkstra
			if(aristas.getAristas().get(i).getVisitable()==1) {		
			
			int tiempo =aristas.getAristas().get(i).getPeso()/aristas.getAristas().get(i).getVelocidad();
			dijkstraAlgorithm.addEdge(aristas.getAristas().get(i).getNodo1().getIdnodo(),
					aristas.getAristas().get(i).getNodo2().getIdnodo(),tiempo , true);
			}
		}
		
		
		
		//Creamos una lista de rutas hacia los hospitales
		ArrayList<Rutas>rutaList=new ArrayList<Rutas>();
		//Guardamos la ubicacion en el metodo dijkstra como nodo inicial
		dijkstraAlgorithm.dijkstra(inicial);
		for (int i = 0; i < conveniohospital.getConveniohospitales().size(); i++) {
			
			if(conveniohospital.getConveniohospitales().get(i).getConvenio().getIdconvenio()==Integer.parseInt(convStr))
			{
				
				//Creamos un arreglo ruta donde se guardara la ruta el peso  
				//System.out.println(conveniohospital.getConveniohospitales().get(i).getHospital().getNodo().getNombre());				
				String[] ruta= new String[2];
				
				ruta= dijkstraAlgorithm.printShortestPath(conveniohospital.getConveniohospitales().get(i).getHospital().getNodo().getIdnodo());
				
				Rutas rutaclass = new Rutas();
				rutaclass.setRuta(ruta[0]);
				rutaclass.setPeso(Integer.parseInt(ruta[1]));
				rutaclass.setPaciente(conveniohospital.getConveniohospitales().get(i).getHospital().getNumeropacientes());
				rutaclass.setTimpopaciente(conveniohospital.getConveniohospitales().get(i).getHospital().getTiempoconsulta());
				rutaclass.setTiempollegada(Integer.parseInt(ruta[1]));
				rutaclass.setTiempototal(rutaclass.getPaciente()*rutaclass.getTimpopaciente()+rutaclass.getPeso());
				rutaList.add(rutaclass);			
				
				
			}
			
		}
		//creamos una variable con un valor max para encontrar el centro de salud que tenga menos tiempo 
		double menortiempo=100000;
		
		Rutas rutaclass2 = new Rutas();
		
		int hopitapaciente=-1;
		for (int i = 0; i < rutaList.size(); i++) {
			
			
			if(menortiempo>rutaList.get(i).getTiempototal()) {
				menortiempo=rutaList.get(i).getTiempototal();
				rutaclass2=rutaList.get(i);
				
				hopitapaciente=i;
			}
		}
		//Imprimimos la ruta y las variables obtenidas
		JOptionPane.showMessageDialog(null,rutaclass2.getRuta()+" \n con tiempo de llegada de "
				+rutaclass2.getPeso()+"min, \n con  "
				+rutaclass2.getPaciente()+" pacientes \n tiempo promedio de atencion   "
				+rutaclass2.getTimpopaciente()+" min, \n con un tiempo total de espera "
				+rutaclass2.getTimpopaciente()*rutaclass2.getPaciente()+" min \n para un total de timpo "
				+rutaclass2.getTiempototal()+" min");
		
	
		
		
		
	//Guardamos en la base el nodo inicial el nodo final y el nombre del paciente
	
		Paciente pasienteCargar = new Paciente();

		pasienteCargar.setNodo(nodos.getNodos().get(inicial));
		pasienteCargar.setHospital(hospital.getHospitales().get(hopitapaciente));
		String nombrePaciente="";
		
		while(nombrePaciente.equals("")){
			nombrePaciente=JOptionPane.showInputDialog(null, "Nombre del paciente");
		}
		
			pasienteCargar.setNombrePaciente(nombrePaciente);
		
		paciente.setPaciente(pasienteCargar);
		paciente.guardarPaciente();	
	
	}
}


class Dijkstra {

	// similar a los defines de C++
	private final int MAX = 10005; // maximo numero de vértices
	private final int INF = 1 << 30; // definimos un valor grande que represente la distancia infinita inicial, basta
										// conque sea superior al maximo valor del peso en alguna de las aristas

	private List<List<Node>> ady = new ArrayList<List<Node>>(); // lista de adyacencia
	public int distancia[] = new int[MAX]; // distancia[ u ] distancia de vértice inicial a vértice con ID = u
	private boolean visitado[] = new boolean[MAX]; // para vértices visitados
	private PriorityQueue<Node> Q = new PriorityQueue<Node>(); // priority queue propia de Java, usamos el comparador
																// definido para que el de menor valor este en el tope
	private int V; // numero de vertices
	private int previo[] = new int[MAX]; // para la impresion de caminos
	private int pesos[] = new  int[MAX];
	private boolean dijkstraEjecutado;
	
	private String printf="";
	
	// private RutaBean ruta = new RutaBean();
	private int nodoInicial;
	private int nodoDestino;
	
	private int distamin=1000000000;

	private NodoBeans nodos = new NodoBeans();
	
	
	private AristaBeans arista = new AristaBeans();
	
	

	private HospitalBeans hospital = new HospitalBeans();

	Dijkstra(int V) {
		this.V = V;
		for (int i = 0; i <= V; ++i)
			ady.add(new ArrayList<Node>()); // inicializamos lista de adyacencia
		dijkstraEjecutado = false;
	}

	// En el caso de java usamos una clase que representara el pair de C++
	class Node implements Comparable<Node> {
		int first, second;

		Node(int d, int p) { // constructor
			this.first = d;
			this.second = p;
		}

		public int compareTo(Node other) { // es necesario definir un comparador para el correcto funcionamiento del
											// PriorityQueue
			if (second > other.second)
				return 1;
			if (second == other.second)
				return 0;
			return -1;
		}
	};

	// función de inicialización
	private void init() {
		for (int i = 0; i <= V; ++i) {
			distancia[i] = INF; // inicializamos todas las distancias con valor infinito
			visitado[i] = false; // inicializamos todos los vértices como no visitados
			previo[i] = -1; // inicializamos el previo del vertice i con -1
		}
	}

	// Paso de relajacion
	private void relajacion(int actual, int adyacente, int peso) {
		// Si la distancia del origen al vertice actual + peso de su arista es menor a
		// la distancia del origen al vertice adyacente
		
	

		if (distancia[actual] + peso < distancia[adyacente]) {
			distancia[adyacente] = distancia[actual] + peso; // relajamos el vertice actualizando la distancia
			
			previo[adyacente] = actual; // a su vez actualizamos el vertice previo
			pesos[adyacente]=peso;
			Q.add(new Node(adyacente, distancia[adyacente])); // agregamos adyacente a la cola de prioridad
		
		}
		
		
	}

	void dijkstra(int inicial) {

		nodoInicial = inicial;

		init(); // inicializamos nuestros arreglos
		Q.add(new Node(inicial, 0)); // Insertamos el vértice inicial en la Cola de Prioridad
		distancia[inicial] = 0; // Este paso es importante, inicializamos la distancia del inicial como 0
		int actual, adyacente, peso;
		while (!Q.isEmpty()) { // Mientras cola no este vacia
			actual = Q.element().first; // Obtengo de la cola el nodo con menor peso, en un comienzo será el inicial
			Q.remove(); // Sacamos el elemento de la cola
			if (visitado[actual])
				continue; // Si el vértice actual ya fue visitado entonces sigo sacando elementos de la
							// cola
			visitado[actual] = true; // Marco como visitado el vértice actual

			for (int i = 0; i < ady.get(actual).size(); ++i) { // reviso sus adyacentes del vertice actual
				adyacente = ady.get(actual).get(i).first; // id del vertice adyacente
				peso = ady.get(actual).get(i).second; // peso de la arista que une actual con adyacente ( actual ,
														// adyacente )
				if (!visitado[adyacente]) { // si el vertice adyacente no fue visitado
					relajacion(actual, adyacente, peso); // realizamos el paso de relajacion
				}
			}
		}

		hospital.inicializar();
		nodos.inicializar();
		// System.out.printf("Distancias mas cortas iniciando en vertice %d\n",
		// inicial);
		for (int i = 0; i < V; ++i) {

			for (int j = 0; j < hospital.getHospitales().size(); j++) {

				if (nodos.getNodos().get(i).getIdnodo() == hospital.getHospitales().get(j).getNodo().getIdnodo()) {
					// System.out.printf("Vertice %d , distancia mas corta = %d\n", i,
					// distancia[i]);
					/*int paciente = (int) (Math.random() * 30) + 1;
					int TiempoConsulta = (int) (Math.random() * 30) + 1;
					int TiempoEspera = paciente * TiempoConsulta;
					int tiempototal = (3 * distancia[i]) / 500;// mru t=d/v V=60km/h=1000minutos
*/
					/*
					 * JOptionPane.showMessageDialog(null,j+"."+hospital.getHospitales().get(j).
					 * getNodo().getNombre()+"\n* Numero de pacientes en hospital: "+paciente
					 * +"\n* El tiempo de consulta es de: "+TiempoConsulta+" Minutos"
					 * +"\n* distancia mas corta :  "+ distancia[i]+" mts"
					 * +"\n***Tiempo total en llegar al centro de salud " +
					 * "desde su ubicacion actual es de: "+tiempototal +" Minutos***");
					 * 
					 */
				}

			}

		}

		dijkstraEjecutado = true;
	}

	void addEdge(int origen, int destino, int peso, boolean dirigido) {
		ady.get(origen).add(new Node(destino, peso)); // grafo diridigo
		if (!dirigido)
			ady.get(destino).add(new Node(origen, peso)); // no dirigido
	}

	String[] printShortestPath(int destino) {
		
		String[] ruta=new String[2];
		//int destino = -1;
		if (!dijkstraEjecutado) {
			System.out.println(
					"Es necesario ejecutar el algorithmo de Dijkstra antes de poder imprimir el camino mas corto");
	
		}
				try {
			
			
			arista.inicializar();
			print(destino);
			System.out.printf("\n");
			

			
			ruta[0]=printf;
					
			printf="";
			
		
			ruta[1]=""+distancia[destino];
		
		
			
			

		} catch (Exception e) {
			// TODO: handle exception
		}
return ruta;
	}

	// Impresion del camino mas corto desde el vertice inicial y final ingresados
	void print(int destino) {
		
		
	
			
		
		if (previo[destino] != -1) // si aun poseo un vertice previo
			
		{	
			
			print(previo[destino]); // recursivamente sigo explorando
		
		 
		printf+=nodos.getNodos().get(destino).getIdnodo()+". "+nodos.getNodos().get(destino).getNombre() + " ( " + nodos.getNodos().get(destino).getLatitudnodo()
				+ ", " + nodos.getNodos().get(destino).getLongitudnodo() + " )\n ";
		
		}
		
		
	
		
		
	
	}
	
	

	public int getNumberOfVertices() {
		return V;
	}

	public void setNumberOfVertices(int numeroDeVertices) {
		V = numeroDeVertices;
	}

}
