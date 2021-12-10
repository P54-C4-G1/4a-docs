const { gql } = require('apollo-server');

const gastoTypeDefs = gql `
    type Gasto {
        idgasto: String!
        idunidad: String!
        idcategoria: String!
        detalle: String!
        valor: Float!
        fecha: String!
    }

    input GastoInput {
        idgasto: String!
        idunidad: String!
        idcategoria: String!
        detalle: String!
        valor: Float!
    }

    extend type Query {
        gastoByidgasto(idgasto: String!): Gasto
        gastoByidunidad(idunidad: String!): [Gasto]
        gastoByidcategoria(idcategoria: String!): [Gasto]
    }

    extend type Mutation {
        createGasto(Gasto: GastoInput!): Gasto
    }
`;

module.exports = gastoTypeDefs;