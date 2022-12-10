import java.sql.*;

public class Aluno {
	private String nomeAluno;
	private int idadeAluno;
	private float pesoAluno;
	private float alturaAluno;
	private String objetivoAluno;
	
	public Aluno(String nome, int idade, float peso, float altura, String objetivo) {
		this.nomeAluno = nome;
		this.idadeAluno = idade;
		this.pesoAluno = peso;
		this.alturaAluno = altura;
		this.objetivoAluno = objetivo;
	}
	
	public String getNomeAluno() {
		return this.nomeAluno;
	}
	
	public void setNomeAluno(String nome) {
		this.nomeAluno = nome;
	}
	
	public int getIdadeAluno() {
		return this.idadeAluno;
	}
	
	public void setIdadeAluno(int idade) {
		this.idadeAluno = idade;
	}
	
	public float getPesoAluno() {
		return this.pesoAluno;
	}
	
	public void setPesoAluno(float peso) {
		this.pesoAluno = peso;
	}
	
	public float getAlturaAluno() {
		return this.alturaAluno;
	}
	
	public void setAlturaAluno(float altura) {
		this.alturaAluno = altura;
	}
	
	public String getObjetivoAluno() {
		return this.objetivoAluno;
	}
	
	public void setObjetivoAluno(String objetivo) {
		this.objetivoAluno = objetivo;
	}
	
	public void insereAlunoDatabase() {
		{
			try
			{
			String url =
			"jdbc:sqlserver://localhost;databaseName=BDALUNO;integratedSecurity=true";
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con;
			con = DriverManager.getConnection(url);
			Statement st = con.createStatement();
			String x = "INSERT INTO tb_alunos (nm_aluno, qt_idadealuno, qt_pesoaluno, ds_objetivoaluno) VALUES (" + this.getNomeAluno() + " , " + this.getIdadeAluno() + " , " + this.getPesoAluno() + " , " + this.getAlturaAluno() + " , " + this.getObjetivoAluno() + ")";
			st.executeUpdate(x);
			con.close();
			}
			catch (Exception e)
			{
			System.out.println("Erro: " + e.getMessage());
			}
		}
	}
}
