
public class Arvutin�htav {
	//kuna m�nguv�ljaku suurus nagunii ei muutu, kasutame massiive. 
	//m�nguv�ljak tuleb kokku 10-st massiivist, kus on iga�hes 10 char elementi 'O'
	//'O' t�hendab meie programmis seda, et tegemist on t�hja kohada, kuhu saab laeva paigutada
	//'X' t�hendab, et seal selles kohas asub laev 
	//ja 'Y', et see koht on k�ll t�hi, aga k�rval asub laev (sinna ei saa laeva paigutada)
	
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

//laud on muutuja, mis sisuliselt �hendab read kokku
private char [][] laud = {a,b,c,d,e,f,g,h,i,j};

//Katsetan, kas git toimib

// meile enda jaoks tehtud toString, et n�ha, mis arvuti m�ngulaua peal toimub, kui programmile midagi lisame
@Override
public String toString() {
	for (char[] rida : laud){
		for (char t�ht : rida){
			System.out.print(t�ht);
		}
		System.out.println();
	};
	return "Jee!";
}
//get meetod, laua jaoks
public char[][] getLaud() {
	return laud;
}
//meetod, millega tuleb suvaline t�isarv 0-9
public static int looJuhuArv() {
	return (int)Math.floor(Math.random()*10);
}
// meetod, mis annab suvaliselt kas 0 v�i 1, kasutame selleks, et valida laeva paigutamise suund
public int valiSuund(){
	return (int)Math.floor(Math.random()*2);
}
//Hakkame laevu paigutama, alustuseks meetod 4-se laeva jaoks
char[][] paigutaLaevNeli(char [][] laud){
		while(true){
		int rida= looJuhuArv(); //0-9
		int veerg = looJuhuArv();
		
		if(valiSuund()==1)	{
			if(veerg+3<10){ //et j�rgmises if-is ei tuleks error out of bounds
							
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
			if(rida+3<10){ //et j�rgmises if-is ei tuleks error out of bounds
				
				if(laud[rida+1][veerg]=='O'&&laud[rida+2][veerg]=='O'&&laud[rida+3][veerg]=='O'){
					// �levalt alla
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

