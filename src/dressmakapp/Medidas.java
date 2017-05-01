package dressmakapp;

public class Medidas {
	private double LTD;
	private double AH;
	private double AE;
	private double CB;
	private double AB;
	private double Cc;
	private double CC;
	private double AC;
	private double DB;
	int EVD=7, EVE=2, EHD=7, EHE=7,CHE=4, CHD=5;
	
	public
	
	Medidas(){
		LTD = 0;
		AH = 0;
		AE = 0;
		CB = 0;
		AB = 0;
		Cc = 0;
		CC = 0;
		AC = 0;
		DB = 0;
		EVD = 7;
		EVE = 2; 
		EHD = 7;
		EHE = 7;
		CHE = 4; 
		CHD=5;
	}
	
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

	double getLTD(){
		return LTD;
	}
	
	double getCB(){
		return CB;
	}
	
	double getDB(){
		return DB;
	}
	
	double getAH(){
		return AH;
	}
	double getAE(){
		return AE;
	}
	double getAB(){
		return AB;
	}
	double getAC(){
		return AC;
	}

	double getCC(){
		return CC;
	}
	
	double getCc(){
		return Cc;
	}
	double getEVD(){
		return (Escala1(ConvertirCmToPx(EVD)));
	}
	double getEVE(){
		return (Escala1(ConvertirCmToPx(EVE)));
	}
	double getEHD(){
		return (Escala1(ConvertirCmToPx(EHD)));
	}
	double getEHE(){
		return (Escala1(ConvertirCmToPx(EHE)));
	}
	void setLTD(double a){
		LTD=a;
	}
	void setAH(double a){
		AH=a;
	}
	void setAE(double a){
		AE=a;
	}
	void setAB(double a){
		AB=a;
	}
	void setCB(double a){
		CB=a;
	}
	void setDB(double a){
		DB=a;
	}
	void setCc(double a){
		Cc=a;
	}
	void setCC(double a){
		 CC=a;
	}
	void setAC(double a){
		 AC=a;
	}
	double ConvertirCmToPx (double a){
	//	return a= a*45;
		return a= (double) (a*37.795276);
	}
	double Escala1(double a){
		return a=a/5;
	}
	
	double getPX(double a){
		return (Escala1(ConvertirCmToPx(a)));
	}
	
	double getPxLTD(){
		return getPX(LTD);
	}
	
	double getPxCB(){
		return getPX(CB);
	}
	
	double getPxDB(){
		return getPX(DB);
	}
	
	double getPxAH(){
		return getPX(AH);
	}
	double getPxAE(){
		return getPX(AE);
	}
	double getPxAB(){
		return getPX(AB);
	}
	double getPxAC(){
		return getPX(AC);
	}

	double getPxCC(){
		return getPX(CC);
	}
	
	double getPxCc(){
		return getPX(Cc);
	}
	////////////////////////////////////////////////////////////////////////////////////
	//cuadro base patron plano (hacerlo luego en otra clase)
	////////////////////////////////////////////////////////////////////////////////////
	double LVertical(double ltd, double ac){ //linea vertical del cuadrado basico
		double Vertical= ltd+EVD+ac;
		return (Escala1(ConvertirCmToPx(Vertical)));
	}
	double LHorizontal(double CC){//linea horizontal del cuadrado basico
		double Horizontal= (CC/2)+10;
		return (Escala1(ConvertirCmToPx(Horizontal)));
	}
	
	double PosLcintura(){//posicion de la linea de cintura
		double LV= LVertical(this.LTD,this.AC);
		double aux=this.AC;
		aux= Escala1(ConvertirCmToPx(aux));
		return (LV-aux);
	}

	double PosLbusto(){//posicion de la linea de busto
		double Lc= PosLcintura();
		double aux=(this.LTD)/2;
		aux=Escala1(ConvertirCmToPx(aux));
		return (Lc-aux);
	}

	double PosLespalda(){//posicion de la linea de espalda
		double Le= PosLbusto();
		double aux=(this.LTD)/4;
		aux=Escala1(ConvertirCmToPx(aux));
		return (Le-aux);
	}
	
	
	public double[] PosLine2cm(double XBus, double XCin, double PosBus, double PosCin){
		double ad, op;//catetos
		double angRadian;//angulos en radianes y grados
		System.out.println("Xbus: "+ XBus + "   Xcin: "+XCin);
		ad= Math.abs(XBus-XCin);
		System.out.println("ad: "+ad);
		System.out.println("posbus: "+ PosBus + "   Poscin: "+PosCin);
		op= Math.abs(PosBus-PosCin);
		System.out.println("op: "+op);
		double aux;
		aux = (double) (op/ad);
		angRadian = Math.atan(aux);
		double posX, posY;
		System.out.println("angulo en grados "+ Math.toDegrees(angRadian));
		posX=0;
		posY=0;
		posX= (double) Math.cos(Math.toDegrees(angRadian))*Escala1(ConvertirCmToPx(2));
		posY= (double) Math.sin(Math.toDegrees(angRadian))*Escala1(ConvertirCmToPx(2));
		
		return new double[]{Math.abs(posX),Math.abs(posY)}; 
	}
	
}
