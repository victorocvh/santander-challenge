import pandas as pd 
import datetime, random, faker
import locale 
fake = faker.Faker()
locale.setlocale(locale.LC_TIME, 'pt_BR.UTF-8')
df_clientes = pd.read_csv('dados/cliente.csv')
df_produtos = pd.read_csv('dados/produto.csv')
df_produtos['dt_atualizacao_preco'] = pd.to_datetime(df_produtos['dt_atualizacao_preco'], errors='coerce')
df_funcionario = pd.read_csv('dados/funcionario.csv')

df_vendas = pd.DataFrame(columns=[
    'id','id_cliente','id_funcionario','id_produto','quantidade','valor_total','data_venda','observacoes'
])

def generate_tabela_preco():

    lista_preco = []
    id_counter = 1

    for i, produto in df_produtos.iterrows():
        n_atualizacoes = random.randint(1,5)
        max_date = datetime.datetime(1,1,1)

        for _ in range(n_atualizacoes):

            novo_preco = random.uniform(10, 100)
            funcionario = df_funcionario.sample(n=1)
            dt_atualizacao = fake.date_time_ad(start_datetime=datetime.datetime(2023, 12, 1, 0, 0, 0))
            
            if dt_atualizacao > max_date:
                max_date = dt_atualizacao

            nova_entrada = {
                'id': id_counter,
                'id_produto': int(produto['id']),
                'id_funcionario': int(funcionario['id'].iloc[0]),
                'preco': novo_preco,
                'dt_atualizacao': dt_atualizacao
            }
            id_counter += 1
            lista_preco.append(nova_entrada)
        
        
        df_produtos.at[i, 'dt_atualizacao_preco'] = max_date
        
    df_tabela_preco = pd.DataFrame(lista_preco)
    df_tabela_preco.to_csv('dados/hist_preco_produto.csv', index=False)
    df_produtos.to_csv('dados/produto.csv', index=False)

def generate_tabela_vendas():
    lista_vendas = []

    for i in range(random.randint(1,300)):
        
        cliente = df_clientes.sample(n=1)
        funcionario = df_funcionario.sample(n=1)
        produto = df_produtos.sample(n=1)
        qtd = random.randint(1,100)
        min_date = max(cliente['dt_criacao'].iloc[0], funcionario['dt_contratacao'].iloc[0])
        dt_venda = fake.date_time_ad(start_datetime=datetime.datetime.strptime(min_date,"%Y-%m-%d %H:%M:%S.%f"))
        nova_venda = {
            'id': i + 1,
            'id_cliente': int(cliente['id'].iloc[0]),
            'id_funcionario': int(funcionario['id'].iloc[0]),
            'id_produto': int(produto['id'].iloc[0]),
            'quantidade': qtd,
            'valor_total': qtd * float(produto['preco'].iloc[0]),
            'valor_unit': float(produto['preco'].iloc[0]),
            'data_venda': dt_venda,
            'observacoes': ''
        }

        lista_vendas.append(nova_venda)
        df = pd.DataFrame(lista_vendas)
        df['mes_venda'] = df['data_venda'].apply(lambda x: x.strftime('%b').lower())
        df['mes'] = df['data_venda'].dt.month
        df.to_csv('dados/vendas.csv', index=False)

generate_tabela_preco()
generate_tabela_vendas()