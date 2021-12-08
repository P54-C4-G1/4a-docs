const { gql } = require('apollo-server');

const integranteTypeDefs = gql `
    type Integrante {
        idusuario: String!
        idunidad: String!
        administrador: Boolean!
        abono: Float
    }

    input IntegranteInput {
        idusuario: String!
        idunidad: String!
        administrador: Boolean!
        abono: Float
    }

    extend type Query {
        integranteByidusuario(idusuario: String!): [Integrante]
        integranteByidunidad(idunidad: String!): [Integrante]
    }

    extend type Mutation {
        createIntegrante(Integrante: IntegranteInput!): Integrante
    }
`;

module.exports = integranteTypeDefs;