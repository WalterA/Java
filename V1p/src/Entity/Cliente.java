package Entity;
//Una classe Cliente con ID del cliente, nome, cognome, e-mail, password etc.
public class Cliente {
		private Integer id;
		private String nome , cognome, email, password;
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getCognome() {
			return cognome;
		}
		public void setCognome(String cognome) {
			this.cognome = cognome;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public Cliente(Integer id, String nome, String cognome, String email, String password) {
			super();
			this.id = id;
			this.nome = nome;
			this.cognome = cognome;
			this.email = email;
			this.password = password;
		}
		public Cliente() {
			super();
		}
		@Override
		public String toString() {
			return "Cliente [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", email=" + email + ", password="
					+ password + "]";
		}
		
}
