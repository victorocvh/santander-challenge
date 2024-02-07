from faker import Faker
import csv
import re 
import random
import datetime
import faker_commerce

fake = Faker('pt_BR')
fake.add_provider(faker_commerce.Provider)

clientes = []
funcionarios = []
produtos = []

def gera_dados_cliente():
    fields = ['id','nome','email','cpf','telefone','dt_criacao','is_deleted']

    with open('dados/cliente.csv','w', newline='') as file:
        writer = csv.writer(file)
        writer.writerow(fields)
        for i in range(100):
            dados = [
                i+1, 
                fake.name(), 
                fake.email(), 
                fake.cpf(),
                re.sub(r'[^0-9]', '', fake.phone_number()),
                fake.date_time(),
                fake.boolean()
            ]
            clientes.append(dados)
            writer.writerow(dados)

def gera_tipo_funcionario():
    fields = ['id','descricao']
    with open('dados/tipo_funcionario.csv','w', newline='') as file:
        writer = csv.writer(file)
        writer.writerow(fields)
        writer.writerow([1,'Vendedor'])

def gera_dados_funcionario():
    fields = ['id','nome','email','telefone','dt_contratacao','ativo', 'tipo_funcionario_id']
    with open('dados/funcionario.csv', 'w', newline='') as file:
        writer = csv.writer(file)
        writer.writerow(fields)
        for i in range(10):
            dados = [
                i + 1,
                fake.name(),
                fake.email(),
                re.sub(r'[^0-9]', '', fake.phone_number()),
                fake.date_time(),
                fake.boolean(),
                1
            ]
            funcionarios.append(dados)
            writer.writerow(dados)

def gera_dados_produtos():
    produtos_name = [ "Barra de pull-up", "Anéis olímpicos", "Paralelas", "Corda de pular", "Barras paralelas para dips", 
    "Saco de areia", "Colete ponderado", "Faixas de resistência", "Bola suíça", "Luvas de treino", "Meiões de compressão",
    "Tênis de corrida", "Tapete de yoga", "Protetores de punho", "Cinto de levantamento de peso", "Grips para barra",
    "Bolsa esportiva", "Elásticos de resistência", "Roda abdominal", "Sapatilhas de treino"
    ]

    fields = ['id', 'nome_produto', 'descricao', 'preco', 'dt_atualizacao_preco', 'ativo']

    with open('dados/produto.csv','w', newline='') as file:
        writer = csv.writer(file)
        writer.writerow(fields)
        for i in range(len(produtos_name)):
            dados = [
                i + 1,
                produtos_name[i],
                '',
                random.uniform(1, 100),
                None,
                fake.boolean()
            ]
            produtos.append(dados)
            writer.writerow(dados)




gera_dados_cliente()
gera_dados_produtos()
gera_tipo_funcionario()
gera_dados_funcionario()
