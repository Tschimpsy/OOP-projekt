
public class Arvutinähtav {
	//kuna mänguväljaku suurus nagunii ei muutu, kasutame massiive. 
	//mänguväljak tuleb kokku 10-st massiivist, kus on igaühes 10 char elementi 'O'
	//'O' tähendab meie programmis seda, et tegemist on tühja kohada, kuhu saab laeva paigutada
	//'X' tähendab, et seal selles kohas asub laev 
	//ja 'Y', et see koht on küll tühi, aga kõrval asub laev (sinna ei saa laeva paigutada)
	
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

//laud on muutuja, mis sisuliselt ühendab read kokku
private char [][] laud = {a,b,c,d,e,f,g,h,i,j};

//Katsetan, kas git toimib

// meile enda jaoks tehtud toString, et näha, mis arvuti mängulaua peal toimub, kui programmile midagi lisame
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
//get meetod, laua jaoks
public char[][] getLaud() {
	return laud;
}
//meetod, millega tuleb suvaline täisarv 0-9
public static int looJuhuArv() {
	return (int)Math.floor(Math.random()*10);
}
// meetod, mis annab suvaliselt kas 0 või 1, kasutame selleks, et valida laeva paigutamise suund
public int valiSuund(){
	return (int)Math.floor(Math.random()*2);
}
//Hakkame laevu paigutama, alustuseks meetod 4-se laeva jaoks
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
				if (rida == 9 && veerg != 6 && veerg != 0){
					laud[rida-1][veerg] = 'Y';
					laud[rida-1][veerg+1] = 'Y';
					laud[rida-1][veerg+2] = 'Y';
					laud[rida-1][veerg+3] = 'Y'; //lisab X-st üles Y-i
					laud[rida-1][veerg+4] = 'Y'; //Lisab paremale üles nurka Y-i
					laud[rida][veerg-1] = 'Y'; // lisab vasakule äärde Y-i
					laud[rida-1][veerg-1] = 'Y'; // lisab vasakule üles nurka Y-i
					laud[rida][veerg+4] = 'Y'; // lisab vasakule äärde
					
				}
				else if (rida == 9 && veerg == 0){
					laud[rida-1][veerg] = 'Y';
					laud[rida-1][veerg+1] = 'Y';
					laud[rida-1][veerg+2] = 'Y';
					laud[rida-1][veerg+3] = 'Y'; //lisab X-st üles Y-i
					laud[rida][veerg+4] = 'Y'; // lisab paremale äärde Y-i
					laud[rida-1][veerg+4] = 'Y'; // lisab paremale üles nurka Y-i
				}
				else if (rida == 9 && veerg == 6){
					laud[rida-1][veerg] = 'Y';
					laud[rida-1][veerg+1] = 'Y';
					laud[rida-1][veerg+2] = 'Y';
					laud[rida-1][veerg+3] = 'Y'; //lisab X-st üles Y-i
					laud[rida][veerg-1] = 'Y'; // lisab vasakule äärde Y-i
					laud[rida-1][veerg-1] = 'Y'; // lisab vasakule üles nurka Y-i
				}
				else if (rida == 0 && veerg == 6){
					laud[rida+1][veerg] = 'Y';
					laud[rida+1][veerg+1] = 'Y';
					laud[rida+1][veerg+2] = 'Y';
					laud[rida+1][veerg+3] = 'Y'; //lisab X-st alla Y-i
					laud[rida][veerg-1] = 'Y'; // lisab vasakule äärde Y-i
					laud[rida+1][veerg-1] = 'Y'; // lisab vasakule alla nurka Y-i
				}
				else if (rida == 0 && veerg == 0){
					laud[rida+1][veerg] = 'Y';
					laud[rida+1][veerg+1] = 'Y';
					laud[rida+1][veerg+2] = 'Y';
					laud[rida+1][veerg+3] = 'Y'; //lisab X-st alla Y-i
					laud[rida][veerg+4] = 'Y'; // lisab paremale äärde Y-i
					laud[rida+1][veerg+4] = 'Y';
					laud[rida+1][veerg+1] = 'Y'; // lisab paremale alla nurka Y-i
				}
				else if (rida == 0 && veerg != 6){
					laud[rida+1][veerg] = 'Y';
					laud[rida+1][veerg+1] = 'Y';
					laud[rida+1][veerg+2] = 'Y';
					laud[rida+1][veerg+3] = 'Y'; //lisab X-st alla Y-i
					laud[rida][veerg-1] = 'Y'; // lisab vasakule äärde Y-i
					laud[rida+1][veerg-1] = 'Y'; // lisab vasakule alla nurka Y-i
					laud[rida][veerg+4] = 'Y'; // lisab paremale äärde Y-i
					laud[rida+1][veerg+4] = 'Y'; 
					laud[rida+1][veerg+1] = 'Y'; // lisab paremale alla nurka Y-i
				}
				else if (veerg == 0 && rida != 0 & rida != 6){
					laud[rida+1][veerg] = 'Y';
					laud[rida+1][veerg+1] = 'Y';
					laud[rida+1][veerg+2] = 'Y';
					laud[rida+1][veerg+3] = 'Y'; //lisab X-st alla Y-i
					laud[rida-1][veerg] = 'Y';
					laud[rida-1][veerg+1] = 'Y';
					laud[rida-1][veerg+2] = 'Y';
					laud[rida-1][veerg+3] = 'Y'; //lisab X-st üles Y-i
					laud[rida][veerg+4] = 'Y'; // paremale äärde Y-i
					laud[rida+1][veerg+4] = 'Y';
					laud[rida-1][veerg+4] = 'Y';
				}
				else if (veerg == 0){
					laud[rida+1][veerg] = 'Y';
					laud[rida+1][veerg+1] = 'Y';
					laud[rida+1][veerg+2] = 'Y';
					laud[rida+1][veerg+3] = 'Y'; //lisab X-st alla Y-i
					laud[rida-1][veerg] = 'Y';
					laud[rida-1][veerg+1] = 'Y';
					laud[rida-1][veerg+2] = 'Y';
					laud[rida-1][veerg+3] = 'Y'; //lisab X-st üles Y-i
					laud[rida][veerg+4] = 'Y'; // paremale äärde Y-i
					laud[rida+1][veerg+4] = 'Y';
					laud[rida-1][veerg+4] = 'Y';
				}
				else if (veerg == 6 && rida != 0 && rida !=6){
					laud[rida+1][veerg] = 'Y';
					laud[rida+1][veerg+1] = 'Y';
					laud[rida+1][veerg+2] = 'Y';
					laud[rida+1][veerg+3] = 'Y'; //lisab X-st alla Y-i
					laud[rida-1][veerg] = 'Y';
					laud[rida-1][veerg+1] = 'Y';
					laud[rida-1][veerg+2] = 'Y';
					laud[rida-1][veerg+3] = 'Y'; //lisab X-st üles Y-i
					laud[rida][veerg-1] = 'Y'; // lisab vasakule äärde Y-i
					laud[rida+1][veerg-1] = 'Y';
					laud[rida-1][veerg-1] = 'Y';				
				}
				else if (rida == 6 && veerg == 6){
					laud[rida+1][veerg] = 'Y';
					laud[rida+1][veerg+1] = 'Y';
					laud[rida+1][veerg+2] = 'Y';
					laud[rida+1][veerg+3] = 'Y'; //lisab X-st alla Y-i
					laud[rida-1][veerg] = 'Y';
					laud[rida-1][veerg+1] = 'Y';
					laud[rida-1][veerg+2] = 'Y';
					laud[rida-1][veerg+3] = 'Y'; //lisab X-st üles Y-i
					laud[rida][veerg-1] = 'Y'; // lisab vasakule äärde Y-i
					laud[rida+1][veerg-1] = 'Y';
					laud[rida-1][veerg-1] = 'Y';
				}
				else{
					//System.out.println(rida); Debuggimise pärast oli siin
					//System.out.println(veerg);
					laud[rida+1][veerg] = 'Y';
					laud[rida+1][veerg+1] = 'Y';
					laud[rida+1][veerg+2] = 'Y';
					laud[rida+1][veerg+3] = 'Y'; //lisab X-st alla Y-i
					laud[rida-1][veerg] = 'Y';
					laud[rida-1][veerg+1] = 'Y';
					laud[rida-1][veerg+2] = 'Y';
					laud[rida-1][veerg+3] = 'Y'; //lisab X-st üles Y-i
					laud[rida][veerg-1] = 'Y'; // lisab vasakule äärde Y-i
					laud[rida+1][veerg-1] = 'Y';
					laud[rida-1][veerg-1] = 'Y';
					laud[rida][veerg+4] = 'Y'; // paremale äärde Y-i
					laud[rida+1][veerg+4] = 'Y';
					laud[rida-1][veerg+4] = 'Y';
				}
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
					if (veerg == 9 && rida != 0 && rida != 6){
						laud[rida][veerg-1]='Y';
						laud[rida+1][veerg-1]='Y';
						laud[rida+2][veerg-1]='Y';
						laud[rida+3][veerg-1]='Y'; // lisab vasakule Y-i
						laud[rida-1][veerg]='Y'; // üles äärde Y
						laud[rida-1][veerg-1]='Y'; // üles vasakule Y
						laud[rida+4][veerg]='Y'; // lisab alla äärde Y-i
						laud[rida+4][veerg-1]='Y'; // alla vasakule Y
					}
					else if (veerg == 9 && rida == 0){
						laud[rida][veerg-1]='Y';
						laud[rida+1][veerg-1]='Y';
						laud[rida+2][veerg-1]='Y';
						laud[rida+3][veerg-1]='Y';
						laud[rida+4][veerg-1]='Y';
						laud[rida+4][veerg]='Y';
						laud[rida+4][veerg-1]='Y'; // alla vasakule Y
					}
					else if (veerg == 9 && rida == 6){
						laud[rida][veerg-1]='Y';
						laud[rida+1][veerg-1]='Y';
						laud[rida+2][veerg-1]='Y';
						laud[rida+3][veerg-1]='Y';
						laud[rida-1][veerg-1]='Y';
						laud[rida-1][veerg]='Y';
					}
					else if (veerg == 0 && rida != 0 && rida != 6){
						laud[rida][veerg+1]='Y';
						laud[rida+1][veerg+1]='Y';
						laud[rida+2][veerg+1]='Y';
						laud[rida+3][veerg+1]='Y';
						laud[rida+4][veerg] = 'Y';
						laud[rida+4][veerg+1] = 'Y';
						laud[rida-1][veerg] = 'Y';
						laud[rida-1][veerg+1] = 'Y';
					}
					else if (veerg == 0 && rida == 6){
						laud[rida][veerg+1]='Y';
						laud[rida+1][veerg+1]='Y';
						laud[rida+2][veerg+1]='Y';
						laud[rida+3][veerg+1]='Y'; //paremale Y
						laud[rida-1][veerg] = 'Y';
						laud[rida-1][veerg+1] = 'Y';//paremale üles Y
					}
					else if (veerg == 0 && rida == 0){
						laud[rida][veerg+1]='Y';
						laud[rida+1][veerg+1]='Y';
						laud[rida+2][veerg+1]='Y';
						laud[rida+3][veerg+1]='Y'; //paremale Y
						laud[rida+4][veerg] = 'Y';
						laud[rida+4][veerg+1] = 'Y';
					}
					else if (rida == 0){
						laud[rida][veerg+1]='Y';
						laud[rida+1][veerg+1]='Y';
						laud[rida+2][veerg+1]='Y';
						laud[rida+3][veerg+1]='Y';
						laud[rida][veerg-1]='Y';
						laud[rida+1][veerg-1]='Y';
						laud[rida+2][veerg-1]='Y';
						laud[rida+3][veerg-1]='Y';
						laud[rida+4][veerg] = 'Y';
						laud[rida+4][veerg+1] = 'Y';
						laud[rida+4][veerg-1] = 'Y';
					}
					else if(rida == 6){
						laud[rida][veerg+1]='Y';
						laud[rida+1][veerg+1]='Y';
						laud[rida+2][veerg+1]='Y';
						laud[rida+3][veerg+1]='Y';
						laud[rida][veerg-1]='Y';
						laud[rida+1][veerg-1]='Y';
						laud[rida+2][veerg-1]='Y';
						laud[rida+3][veerg-1]='Y';
						laud[rida-1][veerg] = 'Y';
						laud[rida-1][veerg+1] = 'Y';
						laud[rida-1][veerg-1] = 'Y';
					}
					else{
						//System.out.println(rida); Debuggimise pärast oli siin
						//System.out.println(veerg);
						laud[rida][veerg+1]='Y';
						laud[rida+1][veerg+1]='Y';
						laud[rida+2][veerg+1]='Y';
						laud[rida+3][veerg+1]='Y';
						laud[rida][veerg-1]='Y';
						laud[rida+1][veerg-1]='Y';
						laud[rida+2][veerg-1]='Y';
						laud[rida+3][veerg-1]='Y';
						laud[rida-1][veerg] = 'Y';
						laud[rida-1][veerg+1] = 'Y';
						laud[rida-1][veerg-1] = 'Y';
						laud[rida+4][veerg] = 'Y';
						laud[rida+4][veerg+1] = 'Y';
						laud[rida+4][veerg-1] = 'Y';
						
					}
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

