package questionHandler;

public class question {
	
	private String Domanda;
	private String Risposte;
	private String Soluzione;
	private Boolean corretta;
	
	public question(String tokenizedQuestion)
	{
		
		tokenizedQuestion.replaceAll("(\r\n|\n\r|\r|\n)", "");
		
		Domanda=tokenizedQuestion.substring(0,tokenizedQuestion.indexOf(")")-2);
		
		Risposte=tokenizedQuestion.substring(tokenizedQuestion.indexOf(")")-2 , tokenizedQuestion.lastIndexOf(" ")-2);
		
		Soluzione=tokenizedQuestion.substring(tokenizedQuestion.lastIndexOf(" ")-2);
		
		
		corretta=false;
	}

	public String getQuestion()
	{
		return this.Domanda+"\n"+this.Risposte;
		
	}
	
	public char getAnswer()
	{
		return this.Soluzione.charAt(1);
	}
	
	public void setCorretta()
	{
		this.corretta=true;
	}
	
}
