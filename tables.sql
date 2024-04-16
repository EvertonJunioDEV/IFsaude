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
