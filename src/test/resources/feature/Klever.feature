#language: pt
#encoding: UTF-8
#Author: Marcos
#Date: 19/10/2021
#version: 1.0


@smokeTest
Funcionalidade:  Desafio Web
  Suite comtemplando os cenarios de busca no site da Klever


  @smokeTest @searchPair
  Esquema do Cenario: Validar busca de uma pair na tela home
    Dado que esteja na aba Markets da Klever
    Quando informar uma "<pair>" no campo de busca
    Entao deve ser retornado em tela as informaçoes dessa "<pair>"
    Exemplos:
      | pair  |
      | MATIC |
      | BNB   |
      | KFI   |

  @smokeTest @searchNFT
  Cenario: Validar busca de NFTs com dois tipos de filtro
    Dado que esteja na aba de NFTs
    Quando filtrar a busca por "Agility Affinity"
    E filtrar por "Agility Attribute"
    Entao deve ser retornado em tela os NFTs filtrados

