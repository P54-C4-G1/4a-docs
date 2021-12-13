const { gql } = require('apollo-server');

const categoriaTypeDefs = gql `
    type Categoria {
        idcategoria: String!
        nombre: String!
    }

    input CategoriaInput {
        idcategoria: String!
        nombre: String!
    }

    extend type Query {
        categoriaByidcategoria(idcategoria: String!): Categoria
        categorias(): [Categoria]
    }

    extend type Mutation {
        createCategoria(Categoria: CategoriaInput!): Categoria
    }
`;

module.exports = categoriaTypeDefs;