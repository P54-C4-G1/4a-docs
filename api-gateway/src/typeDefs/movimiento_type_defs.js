const { gql } = require('apollo-server');

const movimientoTypeDefs = gql `
    type Movimiento {
        idmovimiento: String!
        fecha: String!
        idusuario: String!
        detalle: String!
        valor: Float!
    }

    input MovimientoInput {
        idmovimiento: String!
        idusuario: String!
        detalle: String!
        valor: Float!
    }

    extend type Query {
        movimientoByidmovimiento(idmovimiento: String!): [Movimiento]
        movimientoByidusuario(idusuario: String!): [Movimiento]
    }

    extend type Mutation {
        createMovimiento(Movimiento: MovimientoInput!): Movimiento
    }
`;

module.exports = movimientoTypeDefs;