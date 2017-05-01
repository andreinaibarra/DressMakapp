package dressmakapp;

public class Cliente {
	
	Medidas med;
	String nombre;
	int cedula;
	long telefono;
		
	Cliente(){
		med = new Medidas();
		nombre = "";
		cedula = 0;
		telefono = 0;
	}
		
	void asignar(Medidas m, int ced, String n, long tel){
		med = m;
		nombre = n;
		cedula = ced;
		telefono = tel;
	}
}
