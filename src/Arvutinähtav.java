
public class Arvutinähtav {
private char[] a = {'O','O','O','O','O','O','O','O','O','O'};
private char[] b = {'O','O','O','O','O','O','O','O','O','O'};
private char[] c = {'O','O','O','O','O','O','O','O','O','O'};
private char[] d = {'O','O','O','O','O','O','O','O','O','O'};
private char[] e = {'O','O','O','O','O','O','O','O','O','O'};
private char[] f = {'O','O','O','O','O','O','O','O','O','O'};
private char[] g = {'O','O','O','O','O','O','O','O','O','O'};
private char[] h = {'O','O','O','O','O','O','O','O','O','O'};
private char[] i = {'O','O','O','O','O','O','O','O','O','O'};
private char[] j = {'O','O','O','O','O','O','O','O','O','O'};

private char [][] laud = {a,b,c,d,e,f,g,h,i,j};




@Override
public String toString() {
	for (char[] rida : laud){
		for (char täht : rida){
			System.out.print(täht);
		}
		System.out.println();
	};
	return "Jee!";
}
public char[][] getLaud() {
	return laud;
}
public void setLaud(char[][] laud) {
	this.laud = laud;
}
public static int looJuhuArv() {
	return (int)Math.floor(Math.random()*10);
}
public int valiSuund(){
	return (int)Math.floor(Math.random()*2);
}
char[][] paigutaLaevNeli(char [][] laud){
		while(true){
		int rida= looJuhuArv(); //0-9
		int veerg = looJuhuArv();
		
		if(valiSuund()==1)	{
			if(veerg+3<10){ //et järgmises if-is ei tuleks error out of bounds
							
			if(laud[rida][veerg+1]=='O'&&laud[rida][veerg+2]=='O'&&laud[rida][veerg+3]=='O'){
				//vasakult paremale
				
				laud[rida][veerg]='X';
				laud[rida][veerg+1]='X';
				laud[rida][veerg+2]='X';
				laud[rida][veerg+3]='X';
				break;
			}
		}
		else{
			if(rida+3<10){ //et järgmises if-is ei tuleks error out of bounds
				
				if(laud[rida+1][veerg]=='O'&&laud[rida+2][veerg]=='O'&&laud[rida+3][veerg]=='O'){
					// ülevalt alla
					laud[rida][veerg]='X';
					laud[rida+1][veerg]='X';
					laud[rida+2][veerg]='X';
					laud[rida+3][veerg]='X';
					break;}
		}
			
		}
		}}
	
	return laud;
}
	
	/*while (true){
		int rida= looJuhuArv();
		int veerg = looJuhuArv();
		if(asd[rida][veerg]!='X'||asd[rida][veerg]!='Y'){
			asd[rida][veerg]='X';
			break;
		}
	}*/
}

