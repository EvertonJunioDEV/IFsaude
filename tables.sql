CREATE TABLE Pacientes (
    Id INT AUTO_INCREMENT PRIMARY KEY,
    Nome VARCHAR(100),
    DataNascimento DATE,
    Sexo ENUM('Masculino', 'Feminino', 'Outro'),
    Endereco VARCHAR(255),
    Telefone VARCHAR(20)
);

CREATE TABLE Agendamentos (
    Id INT AUTO_INCREMENT PRIMARY KEY,
    PacienteID INT,
    DataAgendamento DATE,
    DataConsulta DATE,
    Observacoes TEXT,
    FOREIGN KEY (PacienteID) REFERENCES Pacientes(Id)
);

CREATE TABLE Prontuarios (
    Id INT AUTO_INCREMENT PRIMARY KEY,
    PacienteID INT,
    Queixas VARCHAR(255),
    Diagnostico VARCHAR(255),
    Tratamento VARCHAR(255),
    DataConsulta DATE,
    FOREIGN KEY (PacienteID) REFERENCES Pacientes(Id)
);


INSERT INTO Pacientes (Nome, DataNascimento, Sexo, Endereco, Telefone)
VALUES
  ('João Silva', '1980-01-01', 'Masculino', 'Rua das Flores, 123', '(11) 9999-9999'),
  ('Maria Oliveira', '1990-02-02', 'Feminino', 'Avenida Paulista, 456', '(12) 8888-8888'),
  ('Pedro Souza', '2000-03-03', 'Outro', 'Rua Tiradentes, 789', '(13) 7777-7777');
  
  
INSERT INTO Agendamentos (PacienteID, DataAgendamento, DataConsulta, Observacoes)
VALUES
  (1, '2024-04-10', '2024-04-15', 'Consulta de acompanhamento'),
  (2, '2024-04-11', '2024-04-16', 'Revisão médica'),
  (3, '2024-04-12', '2024-04-17', 'Primeira consulta');
  
  
INSERT INTO Prontuarios (PacienteID, Queixas, Diagnostico, Tratamento, DataConsulta)
VALUES
  (1, 'Dor de cabeça e tontura', 'Hipertensão arterial', 'Medicamentos e repouso', '2024-04-15'),
  (2, 'Dores nas costas', 'Lumbago', 'Fisioterapia e analgésicos', '2024-04-16'),
  (3, 'Tosse e coriza', 'Resfriado comum', 'Repouso e medicamentos', '2024-04-17');
  
