
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import pdfHandler.*;
import questionHandler.question;

public class finanza {
	
	public static void main(String args[])
	
	{
		/*
		//TEST stuff just ignore. 
		String s="00001 Estraendo una carta da un mazzo di carte napoletane, \r\n" + 
				"				qual è la probabilità di estrarre un tre o un quattro? \r\n" + 
				"						a) 1/10 b) 1/5 c) 1/3 d) 1/2 b"; 
		String D;
						String R;
						String S;
						System.out.println("s");
						D=s.substring(0,s.indexOf(")")-2);
						System.out.println(D);
						R=s.substring(s.indexOf(")")-2, s.length()-1);
						System.out.println(R);
						S=s.substring(s.length()-1);
						System.out.println(S);
		*/
		int counter=0;
		int errori=0;
		String r;
	 	String s;
		int i;
		Scanner sc = new Scanner(System.in);   
		char c;   
	String[] pdfs=pdfHandler.pdfSearch();
	String name;
	question temp;
	String[] tokenizedPDF;
	
	ArrayList<question> domande=new ArrayList<question>();
	
	System.out.println("Ho trovato " + pdfs.length +" PDF");
	
	System.out.println("Sto importando le domande...qualche secondo di pazienza");
	for(i=0; i<pdfs.length; i++)
	{
		name=pdfs[0].substring(0 , pdfs[0].indexOf("."));
		
		tokenizedPDF=pdfHandler.ImportPDF(name);
		
		for(int j=1; j < tokenizedPDF.length; j++)
		{
			
			temp=new question(tokenizedPDF[j]);
			domande.add(temp);
			
		}
	}
		
		System.out.println("Ho raccolto "+domande.size()+" domande");
		
		
		System.out.println("Vuoi randomizzare le domande?\n s->si n->no");
			 c = sc.next().charAt(0);  
			 s=Character.toString(c);
		
			 if(s.equals("S") || s.equals("s"))
			 {
				 Collections.shuffle(domande);
				 
			 }
			 
		i=0;	
		
			 while(i<domande.size())
			 {
				 temp=(question) domande.get(i);
				 r=Character.toString(temp.getAnswer());
				 System.out.println(temp.getQuestion());
				 System.out.println("\n");
				 
				 System.out.println("Fino ad ora hai risposto a "+counter+ " di cui "+errori+ " sbagliate ");
				 c = sc.next().charAt(0);  
				 s=Character.toString(c)+"";
				 
				 	if(s.equalsIgnoreCase(r))
				 			{
				 				System.out.println("**** RISPOSTA ESATTA****");
				 				temp.setCorretta();
				 			}
				 	else
				 			{
				 				System.out.println("**** RISPOSTA SBAGLIATA. SOLUZIONE CORRETTA "+ temp.getAnswer() +" ****");
				 				errori++;
				 			}
				 	
				 	i++;
				 	counter++;
				 	
			 }
		
		
		
	}
	
	
	
	
	
	}	
		
	