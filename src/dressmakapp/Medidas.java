package dressmakapp;

public class Medidas {
	private 
		float LTD, AH, AE, CB, AB, Cc, CC, AC, DB;
		int EVD=7, EVE=2, EHD=7, EHE=7,CHE=4, CHD=5;
	public
	void getMedidas(){
		System.out.println("Largo de talle delantero" + LTD);
		System.out.println("Ancho de hombro" + AH);
		System.out.println("Ancho Espaldao" + AE);
		System.out.println("Contorno de busto" + CB);
		System.out.println("Distancia de Busto" + DB);
		System.out.println("Altura de busto" + AB);
		System.out.println("Contorno de Cintura" + Cc);
		System.out.println("Contorno de Cadera" + CC);
		System.out.println("Altura de Cadera" + AC);
	}
	float setLTD(float a){
		return LTD=a;
	}
	float setAH(float a){
		return AH=a;
	}
	float setAE(float a){
		return AE=a;
	}
	float setAB(float a){
		return AB=a;
	}
	float setCB(float a){
		return CB=a;
	}
	float setDB(float a){
		return DB=a;
	}
	float setCc(float a){
		return Cc=a;
	}
	float setCC(float a){
		return CC=a;
	}
	float setAC(float a){
		return AC=a;
	}
	float ConvertirCmToPx (float a){
	//	return a= a*45;
		return a= (float) (a*37.795276);
	}
	float Escala(float a){
		
		return a=a/2;
	}
	float LVertical(float ltd, float ac){
		float Vertical= ltd+EVD+ac;
		return (ConvertirCmToPx(Vertical));
	}



		
}
