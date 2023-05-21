CREATE DATABASE siga
GO
USE siga

GO
CREATE TABLE Aluno(
ra INT NOT NULL IDENTITY(1111, 1),
nome VARCHAR(100)
PRIMARY KEY(ra)
)

GO
CREATE TABLE Curso(
codigo INT NOT NULL IDENTITY,
nome VARCHAR(50) NOT NULL
PRIMARY KEY(codigo)
)

GO
CREATE TABLE Disciplina(
codigo CHAR(8) NOT NULL,
nome VARCHAR(50) NOT NULL,
sigla VARCHAR(4) NOT NULL,
turno CHAR(1) NOT NULL,
num_aulas INT NOT NULL,
codigo_curso INT NOT NULL
PRIMARY KEY(codigo)
FOREIGN KEY(codigo_curso) REFERENCES Curso(codigo)
)

GO
CREATE TABLE Avaliacao(
codigo INT NOT NULL IDENTITY,
tipo VARCHAR(2) NOT NULL,
PRIMARY KEY(codigo)
)

GO
CREATE TABLE Faltas(
ra_aluno INT NOT NULL,
codigo_disciplina CHAR(8) NOT NULL,
data_falta DATE NOT NULL,
presenca INT NOT NULL
PRIMARY KEY(ra_aluno, codigo_disciplina, data_falta)
FOREIGN KEY(ra_aluno) REFERENCES Aluno(ra),
FOREIGN KEY(codigo_disciplina) REFERENCES Disciplina(codigo)
)

GO
CREATE TABLE Notas(
ra_aluno INT NOT NULL,
codigo_disciplina CHAR(8) NOT NULL,
codigo_avaliacao INT NOT NULL,
nota DECIMAL(7,2) NOT NULL,
peso DECIMAL(7,2) NULL
PRIMARY KEY(ra_aluno, codigo_disciplina, codigo_avaliacao)
FOREIGN KEY(ra_aluno) REFERENCES Aluno(ra),
FOREIGN KEY(codigo_disciplina) REFERENCES Disciplina(codigo),
FOREIGN KEY(codigo_avaliacao) REFERENCES Avaliacao(codigo)
)

GO
-- Trigger que atualiza o peso de cada nota de acordo com o tipo da avaliacao e a disciplina
CREATE TRIGGER t_insertNotas ON Notas
FOR INSERT
AS
BEGIN
	DECLARE @codigo_disciplina CHAR(8),
		@codigo_avaliacao INT,
		@ra_aluno INT
	SET @ra_aluno = (SELECT ra_aluno FROM inserted)
	SET @codigo_disciplina = (SELECT codigo_disciplina FROM inserted)
	SET @codigo_avaliacao = (SELECT codigo_avaliacao FROM inserted)

	-- AOC, LHW, BDD
	IF(@codigo_disciplina = '4203-010' OR @codigo_disciplina = '4203-020'
		OR @codigo_disciplina = '4208-010' OR @codigo_disciplina = '4226-004')
	BEGIN
		IF(@codigo_avaliacao = 1) -- P1
		BEGIN
			UPDATE Notas SET peso = 0.3 WHERE ra_aluno = @ra_aluno
				AND codigo_disciplina = @codigo_disciplina
				AND codigo_avaliacao = @codigo_avaliacao
		END
		ELSE
		BEGIN
			IF(@codigo_avaliacao = 2) -- P2
			BEGIN
				UPDATE Notas SET peso = 0.5 WHERE ra_aluno = @ra_aluno
					AND codigo_disciplina = @codigo_disciplina
					AND codigo_avaliacao = @codigo_avaliacao
			END
			ELSE
			BEGIN
				IF(@codigo_avaliacao = 3) -- T
				BEGIN
					UPDATE Notas SET peso = 0.2 WHERE ra_aluno = @ra_aluno
						AND codigo_disciplina = @codigo_disciplina
						AND codigo_avaliacao = @codigo_avaliacao
				END
			END
		END
	END
	ELSE
	BEGIN
		-- SOI
		IF(@codigo_disciplina = '4213-003' OR @codigo_disciplina = '4213-013')
		BEGIN
			IF(@codigo_avaliacao = 1 OR @codigo_avaliacao = 2) -- P1 e P2
			BEGIN
				UPDATE Notas SET peso = 0.35 WHERE ra_aluno = @ra_aluno
					AND codigo_disciplina = @codigo_disciplina
					AND codigo_avaliacao = @codigo_avaliacao
			END
			ELSE
			BEGIN
				IF(@codigo_avaliacao = 3) -- T
				BEGIN
					UPDATE Notas SET peso = 0.3 WHERE ra_aluno = @ra_aluno
						AND codigo_disciplina = @codigo_disciplina
						AND codigo_avaliacao = @codigo_avaliacao
				END
				ELSE
				BEGIN
					IF(@codigo_avaliacao = 5) -- PE
					BEGIN
						UPDATE Notas SET peso = 0.2 WHERE ra_aluno = @ra_aluno
							AND codigo_disciplina = @codigo_disciplina
							AND codigo_avaliacao = @codigo_avaliacao
					END
				END
			END
		END
		ELSE
		BEGIN
			-- LBD
			IF(@codigo_disciplina = '4233-005')
			BEGIN
				IF(@codigo_avaliacao = 1 OR @codigo_avaliacao = 2 OR @codigo_avaliacao = 3) -- P1, P2 e P3
				BEGIN
					UPDATE Notas SET peso = 0.33 WHERE ra_aluno = @ra_aluno
						AND codigo_disciplina = @codigo_disciplina
						AND codigo_avaliacao = @codigo_avaliacao
				END
			END
			ELSE
			BEGIN
				-- MPC
				IF(@codigo_avaliacao = 6) -- MC
				BEGIN
					UPDATE Notas SET peso = 0.8 WHERE ra_aluno = @ra_aluno
						AND codigo_disciplina = @codigo_disciplina
						AND codigo_avaliacao = @codigo_avaliacao
				END
				ELSE -- MR
				BEGIN
					UPDATE Notas SET peso = 0.2 WHERE ra_aluno = @ra_aluno
						AND codigo_disciplina = @codigo_disciplina
						AND codigo_avaliacao = @codigo_avaliacao
				END
			END
		END
	END
END

GO
-- Trigger que não deixa exceder o número limite de semanas de aula ministradas
CREATE TRIGGER t_insertFaltas ON Faltas
FOR INSERT
AS
BEGIN
	DECLARE @aulas_totais INT,
		@aulas_ministradas INT,
		@ra_aluno INT,
		@codigo_disciplina CHAR(8),
		@qtd_datas INT
	SET @ra_aluno = (SELECT ra_aluno FROM inserted)
	SET @codigo_disciplina = (SELECT codigo_disciplina FROM inserted)
	SET @qtd_datas = (SELECT COUNT(data_falta) 
		FROM Faltas 
		WHERE ra_aluno = @ra_aluno AND codigo_disciplina = @codigo_disciplina)
	IF(@codigo_disciplina = '4208-010' 
		OR @codigo_disciplina = '5005-220')
	BEGIN
		SET @aulas_totais = 40
		SET @aulas_ministradas = (@qtd_datas * 2)
	END
	ELSE
	BEGIN
		SET @aulas_totais = 80
		SET @aulas_ministradas = (@qtd_datas * 4)
	END
	IF(@aulas_ministradas > @aulas_totais)
	BEGIN
		ROLLBACK TRANSACTION
		RAISERROR('Número de aulas já atingiu o total', 16, 1)
	END
END

GO
-- Trigger que verifica o número de presenca de acordo com a disciplina
CREATE TRIGGER t_verificarFaltas ON Faltas
FOR INSERT
AS
BEGIN
	DECLARE @codigo_disciplina CHAR(8),
		@presenca INT
	SET @codigo_disciplina = (SELECT codigo_disciplina FROM inserted)
	SET @presenca = (SELECT presenca FROM inserted)

	IF(@codigo_disciplina = '4208-010' 
		OR @codigo_disciplina = '5005-220')
	BEGIN
		IF(@presenca < 0 OR @presenca > 2)
		BEGIN
			ROLLBACK TRANSACTION
			RAISERROR('Número da presença inválido', 16, 1)
		END
	END
	ELSE
	BEGIN
		IF(@presenca < 0 OR @presenca > 4)
		BEGIN
			ROLLBACK TRANSACTION
			RAISERROR('Número da presença inválido', 16, 1)
		END
	END
END